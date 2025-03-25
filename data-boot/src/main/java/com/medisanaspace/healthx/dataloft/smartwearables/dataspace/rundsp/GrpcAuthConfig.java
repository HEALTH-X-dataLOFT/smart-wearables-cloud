package com.medisanaspace.healthx.dataloft.smartwearables.dataspace.rundsp;

import com.medisanaspace.WebSecurityConfig;
import com.medisanaspace.healthx.dataloft.smartwearables.auth.AuthProperties;
import com.medisanaspace.healthx.dataloft.smartwearables.auth.SwcAuthenticationTokenConverter;
import com.nimbusds.jose.*;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.jwk.source.JWKSourceBuilder;
import com.nimbusds.jose.proc.*;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;
import com.nimbusds.jwt.proc.JWTProcessor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.security.authentication.BearerAuthenticationReader;
import net.devh.boot.grpc.server.security.authentication.CompositeGrpcAuthenticationReader;
import net.devh.boot.grpc.server.security.authentication.GrpcAuthenticationReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.security.oauth2.server.resource.BearerTokenAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Key;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

@Profile("!test")
@Configuration
@Slf4j
public class GrpcAuthConfig {

    private static final JWEAlgorithm JWE_ALGORITHM = JWEAlgorithm.RSA_OAEP_256;
    private static final JWSAlgorithm JWS_ALGORITHM = JWSAlgorithm.RS256;
    private static final EncryptionMethod ENCRYPTION_METHOD = EncryptionMethod.A128CBC_HS256;
    public static final String JWK_URI_SUFFIX = "/protocol/openid-connect/certs";

    private final OAuth2ResourceServerProperties.Jwt properties;
    private final JWKSet privateKeyJWKSet;
    private final String jwtJWKSetURI;
    private final List<String> trustedIssuers;
    private final boolean rejectJWT;
    private final Map<String, JWSKeySelector<SecurityContext>> selectors = new ConcurrentHashMap<>();

    @Autowired
    public GrpcAuthConfig(OAuth2ResourceServerProperties properties,
                          AuthProperties authProperties,
                          @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}") String jwtJWKSetURI) {
        String jwePrivateKeyFileName = authProperties.getJwe().getPrivateKeyFile();

        this.properties = properties.getJwt();
        this.privateKeyJWKSet = loadPrivateKeyFromJWK(jwePrivateKeyFileName);
        this.jwtJWKSetURI = jwtJWKSetURI;
        this.rejectJWT = authProperties.getJwe().isRejectJWT();

        this.trustedIssuers = new ArrayList<>(Arrays.asList(this.properties.getIssuerUri()));
        this.trustedIssuers.addAll(authProperties.getIssuers());
    }

    @Bean
    AuthenticationManager grpcAuthenticationManager(JwtDecoder jwtDecoder) {
        final List<AuthenticationProvider> providers = new ArrayList<>();
        JwtAuthenticationProvider jwtAuthenticationProvider = new JwtAuthenticationProvider(jwtDecoder);

        jwtAuthenticationProvider.setJwtAuthenticationConverter(WebSecurityConfig::authenticationTokenConverter);
        providers.add(jwtAuthenticationProvider);
        return new ProviderManager(providers);
    }

    @Bean
    GrpcAuthenticationReader authenticationReader() {
        final List<GrpcAuthenticationReader> readers = new ArrayList<>();
        readers.add(new BearerAuthenticationReader(this::parseAuthentication));
        return new CompositeGrpcAuthenticationReader(readers);
    }

    @Bean
    JwtDecoder jwtDecoder() throws MalformedURLException {
        NimbusJwtDecoder decoder = new NimbusJwtDecoder(jwtProcessor());
        OAuth2TokenValidator<Jwt> validator = JwtValidators.createDefault();
        decoder.setJwtValidator(getValidators(validator));
        return decoder;
    }

    @Bean
    public JWTProcessor<SecurityContext> jwtProcessor() throws MalformedURLException {
        // JWK Set and key selector for JWT verification
        JWKSource<SecurityContext> jwsJwkSource = JWKSourceBuilder.create(new URL(jwtJWKSetURI))
                .build();
        JWSKeySelector<SecurityContext> jwsKeySelector = new JWSVerificationKeySelector<>(JWS_ALGORITHM,
                jwsJwkSource);

        // JWK Set and key selector for containing JWE verification
        JWKSource<SecurityContext> jweJwkSource = new ImmutableJWKSet<>(this.privateKeyJWKSet);
        JWEKeySelector<SecurityContext> jweKeySelector = new JWEDecryptionKeySelector<>(JWE_ALGORITHM,
                ENCRYPTION_METHOD, jweJwkSource);

        ConfigurableJWTProcessor<SecurityContext> jwtProcessor = new HealthXJWTProcessor<>();
        jwtProcessor.setJWSKeySelector(jwsKeySelector);
        jwtProcessor.setJWEKeySelector(jweKeySelector);
        jwtProcessor.setJWTClaimsSetAwareJWSKeySelector(this::selectJWSKeyByTrustedIssuer);

        return jwtProcessor;
    }

    /**
     * Returns the JWS key for the issuer specified by the{@link JWTClaimsSet}s {@code iss} claim
     */
    private List<? extends Key> selectJWSKeyByTrustedIssuer(JWSHeader jwsHeader, JWTClaimsSet jwtClaimsSet, SecurityContext securityContext) throws KeySourceException {
        String issuer = jwtClaimsSet.getIssuer();
        Function<String, JWSKeySelector<SecurityContext>> fromIssuer = iss ->
                Optional.ofNullable(iss)
                        .map(GrpcAuthConfig::inferIssuerJWKUrl)
                        .orElseThrow(() -> new IllegalArgumentException("Unknown issuer"));

        return this.selectors.computeIfAbsent(issuer, fromIssuer)
                .selectJWSKeys(jwsHeader, securityContext);
    }

    /**
     * Creates the associated JWK URL from a given issuer's base URI
     */
    private static JWSAlgorithmFamilyJWSKeySelector<SecurityContext> inferIssuerJWKUrl(String issuerUrl) {
        String uri = issuerUrl + JWK_URI_SUFFIX;
        try {
            return JWSAlgorithmFamilyJWSKeySelector.fromJWKSetURL(new URL(uri));
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    private Authentication parseAuthentication(String rawToken) {
        return new BearerTokenAuthenticationToken(rawToken);
    }

    /**
     * Returns the validators to use for JWT validation wrapped within a {@link DelegatingOAuth2TokenValidator}
     */
    private OAuth2TokenValidator<Jwt> getValidators(OAuth2TokenValidator<Jwt> defaultValidator) {
        List<String> audiences = this.properties.getAudiences();
        List<OAuth2TokenValidator<Jwt>> validators = new ArrayList<>();
        validators.add(defaultValidator);
        validators.add(new JwtIssuerCollectionValidator(this.trustedIssuers));
        validators.add(new JwtClaimValidator<List<String>>(JwtClaimNames.AUD,
                aud -> aud != null && !Collections.disjoint(aud, audiences)));
        if (this.rejectJWT) {
            validators.add(jweValidator());
        }
        return new DelegatingOAuth2TokenValidator<>(validators);
    }

    /**
     * Returns a lambda function which validates that a given token represents a JWE and not a JWT
     */
    private static OAuth2TokenValidator<Jwt> jweValidator() {
        return token -> {
            try {
                JWEObject.parse(token.getTokenValue());
            } catch (ParseException e) {
                log.warn("Token rejected: A valid JWE is required for authentication with the gRPC server (change auth.jwe.reject-jwt config parameter to allow JWT tokens)");
                return OAuth2TokenValidatorResult.failure(new OAuth2Error("Token rejected: A valid JWE is required for authentication with the gRPC server (change auth.jwe.reject-jwt config parameter to allow JWT tokens)"));
            }
            return OAuth2TokenValidatorResult.success();
        };

    }

    /**
     * Loads the JWE decryption private key from the specified JSON/JWK file
     */
    private JWKSet loadPrivateKeyFromJWK(String pathToJwkFile) {
        try {
            File jwkFile = new File(pathToJwkFile);
            String jwkContent;
            try (var stream = new FileInputStream(jwkFile)) {
                jwkContent = new String(stream.readAllBytes());
            }
            JWK jwk = JWK.parse(jwkContent);
            return new JWKSet(jwk);
        } catch (IOException e) {
            log.error("Failed to load JWK file for JWE decryption: ", e);
            return null;
        } catch (ParseException e) {
            log.error("Failed to parse JWK file for JWE decryption: ", e);
            return null;
        }
    }
}
