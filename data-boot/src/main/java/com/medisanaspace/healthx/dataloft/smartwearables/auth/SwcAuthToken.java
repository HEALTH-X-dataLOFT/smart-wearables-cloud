package com.medisanaspace.healthx.dataloft.smartwearables.auth;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Getter
public class SwcAuthToken extends AbstractAuthenticationToken {

    private final Jwt jwt;
    private final String name;
    private final UUID id;

    public SwcAuthToken(Collection<? extends GrantedAuthority> authorities, Jwt jwt) {
        super(authorities);
        this.jwt = jwt;
        this.name = jwt.getClaim("preferred_username");
        this.id = UUID.fromString(jwt.getSubject());
        this.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return this.jwt;
    }

    @Override
    public Object getPrincipal() {
        return jwt;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
