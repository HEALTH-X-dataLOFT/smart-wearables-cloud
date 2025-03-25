package com.medisanaspace.healthx.dataloft.smartwearables.domain.helper;

import com.medisanaspace.healthx.dataloft.smartwearables.auth.SwcAuthToken;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.jwt.Jwt;

import java.security.Principal;
import java.util.UUID;

public class UserIdHelper {

    private UserIdHelper() {
    }

    public static UUID parseUserIdFromPrincipal(Principal userPrincipal) {
        if (userPrincipal instanceof SwcAuthToken authToken) {
            return authToken.getId();
        }
        if (userPrincipal instanceof Jwt jwt) {
            String subjectId = jwt.getSubject();
            return UUID.fromString(subjectId);
        }
        if (userPrincipal instanceof OAuth2AuthenticationToken oauth2AuthToken) {
            Object principal = oauth2AuthToken.getPrincipal();
            if(principal instanceof DefaultOidcUser oidcUser) {
                String subjectId = oidcUser.getSubject();
                return UUID.fromString(subjectId);
            }
            return null;
        }
        return null;
    }
}
