package com.medisanaspace;

import com.medisanaspace.healthx.dataloft.smartwearables.auth.AuthProperties;
import com.medisanaspace.healthx.dataloft.smartwearables.auth.SwcAuthenticationTokenConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.server.resource.authentication.*;
import org.springframework.security.web.SecurityFilterChain;

import java.util.*;
import java.util.function.Predicate;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, proxyTargetClass = true, jsr250Enabled = true)
@Slf4j
public class WebSecurityConfig {

    private static final String LOGOUT_SUCCESS_URL = "/";
    private static final String GROUPS = "groups";
    private static final String REALM_ACCESS_CLAIM = "realm_access";
    private static final String RESSOURCE_ACCESS_CLAIM = "resource_access";
    private static final String ROLES_CLAIM = "roles";
    private static final String SWC_RESSOURCE_CLAIM = "swc";

    private final KeycloakLogoutHandler keycloakLogoutHandler;
    private final Map<String, AuthenticationManager> authenticationManagers = new HashMap<>();
    private final JwtIssuerAuthenticationManagerResolver authenticationManagerResolver = new JwtIssuerAuthenticationManagerResolver(authenticationManagers::get);
    private final RequestSecurity requestSecurity;

    public WebSecurityConfig(KeycloakLogoutHandler keycloakLogoutHandler, AuthProperties authProperties, RequestSecurity requestSecurity) {
        this.keycloakLogoutHandler = keycloakLogoutHandler;
        this.requestSecurity = requestSecurity;
        authProperties.getIssuers().stream()
                .filter(Predicate.not(String::isBlank))
                .forEach(this::addManager);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/available").permitAll()
                        .requestMatchers("/garmin-api/**").access((authentication, context) ->
                                new AuthorizationDecision(requestSecurity.check(context.getRequest())))
                        .anyRequest().authenticated()
                );

        http
                .oauth2ResourceServer(oauth2 -> {
                    oauth2.authenticationManagerResolver(this.authenticationManagerResolver);
                })
                .oauth2Login(Customizer.withDefaults())
                .logout(logout -> logout.addLogoutHandler(keycloakLogoutHandler)
                        .logoutSuccessUrl(LOGOUT_SUCCESS_URL));

        return http.build();
    }

    //    +++ BEGIN JWT BEARER AUTH CONFIGURATION +++

    private void addManager(String issuer) {
        log.info("Add JWT issuer: {}", issuer);
        JwtDecoder jwtDecoder = JwtDecoders.fromIssuerLocation(issuer);
        JwtAuthenticationProvider authenticationProvider = new JwtAuthenticationProvider(jwtDecoder);
        authenticationProvider.setJwtAuthenticationConverter(WebSecurityConfig::authenticationTokenConverter);
        authenticationManagers.put(issuer, authenticationProvider::authenticate);
    }

    public static AbstractAuthenticationToken authenticationTokenConverter(Jwt jwt) {
        try {
            var converter = new SwcAuthenticationTokenConverter();
            return converter.convert(jwt);
        } catch (Exception e) {
            log.error("Can't create authentication token: " + e.getMessage());
        }

        log.warn("Creating standard JwtAuthenticationToken. May break some functionality like RBAC");
        return new JwtAuthenticationToken(jwt);
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        grantedAuthoritiesConverter.setAuthoritiesClaimName(ROLES_CLAIM);
        grantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
        return jwtAuthenticationConverter;
    }

    //    +++ END JWT BEARER AUTH CONFIGURATION +++

    @Bean
    public GrantedAuthoritiesMapper userAuthoritiesMapperForKeycloak() {
        return authorities -> {
            Set<GrantedAuthority> mappedAuthorities = new HashSet<>();
            var authority = authorities.iterator().next();
            boolean isOidc = authority instanceof OidcUserAuthority;

            if (isOidc) {
                var oidcUserAuthority = (OidcUserAuthority) authority;
                var userInfo = oidcUserAuthority.getUserInfo();

                // Tokens can be configured to return roles under
                // Groups or REALM ACCESS hence have to check both
                if (userInfo.hasClaim(RESSOURCE_ACCESS_CLAIM)) {
                    var ressourceAccess = userInfo.getClaimAsMap(RESSOURCE_ACCESS_CLAIM);
                    if (ressourceAccess.containsKey(SWC_RESSOURCE_CLAIM)) {
                        var swcClientRessource = (HashMap<String, Collection<String>>) ressourceAccess.get(SWC_RESSOURCE_CLAIM);
                        var roles = (Collection<String>) swcClientRessource.get(ROLES_CLAIM);
                        mappedAuthorities.addAll(generateAuthoritiesFromClaim(roles));
                    }
                }
                if (userInfo.hasClaim(REALM_ACCESS_CLAIM)) {
                    var realmAccess = userInfo.getClaimAsMap(REALM_ACCESS_CLAIM);
                    var roles = (Collection<String>) realmAccess.get(ROLES_CLAIM);
                    mappedAuthorities.addAll(generateAuthoritiesFromClaim(roles));
                } else if (userInfo.hasClaim(GROUPS)) {
                    Collection<String> roles = userInfo.getClaim(GROUPS);
                    mappedAuthorities.addAll(generateAuthoritiesFromClaim(roles));
                }
            } else {
                var oauth2UserAuthority = (OAuth2UserAuthority) authority;
                Map<String, Object> userAttributes = oauth2UserAuthority.getAttributes();

                if (userAttributes.containsKey(REALM_ACCESS_CLAIM)) {
                    Map<String, Object> realmAccess = (Map<String, Object>) userAttributes.get(REALM_ACCESS_CLAIM);
                    Collection<String> roles = (Collection<String>) realmAccess.get(ROLES_CLAIM);
                    mappedAuthorities.addAll(generateAuthoritiesFromClaim(roles));
                }
            }
            return mappedAuthorities;
        };
    }

    <T> Collection<SimpleGrantedAuthority> generateAuthoritiesFromClaim(Collection<T> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .toList();
    }
}