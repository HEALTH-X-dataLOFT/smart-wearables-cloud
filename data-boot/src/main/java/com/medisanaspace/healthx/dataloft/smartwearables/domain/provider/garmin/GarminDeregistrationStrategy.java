package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.garmin;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.DeregistrationStrategy;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.ProviderAuthConfigRegistry;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.oauth.OAuthProperties;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.transport.OAuthRequestFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProviders.GARMIN;

@Component
@Slf4j
public class GarminDeregistrationStrategy implements DeregistrationStrategy {

    private final ProviderAuthConfigRegistry authConfigRegistry;
    private final OAuthRequestFactory oAuthRequestFactory;

    @Autowired
    public GarminDeregistrationStrategy(ProviderAuthConfigRegistry authConfigRegistry, OAuthRequestFactory oAuthRequestFactory) {
        this.authConfigRegistry = authConfigRegistry;
        this.oAuthRequestFactory = oAuthRequestFactory;
    }

    public void performDeregistration(String userId) {
        OAuthProperties oAuthProperties = authConfigRegistry.configurationFor(GARMIN);
        try {
            HttpResponse response = oAuthRequestFactory
                    .builderFor(userId, GARMIN)
                    .buildDeleteRequest(new GenericUrl(oAuthProperties.getDeregistrationUrl()))
                    .execute();
            if(response.getStatusCode() != 204) {
                throw new DeregistrationFailedException("Got unexpected status code " + response.getStatusCode());
            }
            log.info("User {} was successfully deregistered from provider {}", userId, GARMIN);
        } catch (IOException e) {
            log.error("OAuth deregistration failed for user {} and provider {} due to an error: ", userId, GARMIN, e);
        }
    }

    private static class DeregistrationFailedException extends IOException {
        public DeregistrationFailedException(String message) {
            super(message);
        }
    }
}
