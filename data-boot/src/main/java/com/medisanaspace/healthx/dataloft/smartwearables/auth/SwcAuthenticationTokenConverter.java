package com.medisanaspace.healthx.dataloft.smartwearables.auth;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SwcAuthenticationTokenConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    private static final String REALM_ACCESS = "realm_access";
    private static final String RESOURCE_ACCESS = "resource_access";
    private static final String ROLES = "roles";
    private static final String SWC_RESSOURCE_CLAIM = "swc";

    public AbstractAuthenticationToken convert(Jwt jwt) {
        var roleAuthorities = getRoles(jwt).stream()
                .map(role -> "ROLE_" + role)
                .map(SimpleGrantedAuthority::new)
                .toList();

        return new SwcAuthToken(roleAuthorities, jwt);
    }

    private static List<String> getRoles(Jwt jwt) {
        var mappedRoles = new LinkedList<String>();

        if (jwt.hasClaim(REALM_ACCESS)) {
            var realmAccess = jwt.getClaimAsMap(REALM_ACCESS);
            var roles = realmAccess.get(ROLES);

            if (roles instanceof List<?>) {
                mappedRoles.addAll((List<String>) roles);
            }
        }

        if(jwt.hasClaim(RESOURCE_ACCESS)) {
            var resourceAccess = jwt.getClaimAsMap(RESOURCE_ACCESS);
            if (resourceAccess.containsKey(SWC_RESSOURCE_CLAIM)) {
                var swcClientRessource = (HashMap<String, List<String>>) resourceAccess.get(RESOURCE_ACCESS);
                var roles = (List<String>) swcClientRessource.get(ROLES);
                mappedRoles.addAll(roles);
            }
        }

        return mappedRoles.stream()
                .distinct()
                .toList();
    }
}