package com.medisanaspace.healthx.dataloft.smartwearables.dataspace.rundsp;

import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimValidator;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.function.Predicate;

public class JwtIssuerCollectionValidator implements OAuth2TokenValidator<Jwt> {

    private final Collection<String> trustedIssuers;
    private final JwtClaimValidator<String> validator;

    public JwtIssuerCollectionValidator(Collection<String> trustedIssuers) {
        this.trustedIssuers = trustedIssuers;
        Assert.notEmpty(trustedIssuers, "At least one trusted issuer must be provided");
        Predicate<String> testClaimValue = claimValue -> claimValue != null && this.trustedIssuers.contains(claimValue);
        this.validator = new JwtClaimValidator<>("iss", testClaimValue);
    }

    @Override
    public OAuth2TokenValidatorResult validate(Jwt token) {
        Assert.notNull(token, "token cannot be null");
        return this.validator.validate(token);
    }
}
