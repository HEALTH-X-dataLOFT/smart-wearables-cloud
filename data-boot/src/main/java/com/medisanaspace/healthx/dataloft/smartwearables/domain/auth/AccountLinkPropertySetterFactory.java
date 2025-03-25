package com.medisanaspace.healthx.dataloft.smartwearables.domain.auth;

import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.oauth.AccessTokenData;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProviders;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.garmin.GarminAccountLinkPropertySetter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
public class AccountLinkPropertySetterFactory {

    public AccountLinkPropertySetter forProvider(ActivityProviders provider, AccessTokenData accessTokenData) {
        if(Objects.requireNonNull(provider).equals(ActivityProviders.GARMIN)) {
            log.info("Returning instance of GarminAccountLinkPropertySetter for provider " + provider);
            return new GarminAccountLinkPropertySetter(accessTokenData);
        }
        log.info("Returning identity function as GarminAccountLinkPropertySetter for provider " + provider);
        return link -> link.setExternalApiUserId(null);
    }
}
