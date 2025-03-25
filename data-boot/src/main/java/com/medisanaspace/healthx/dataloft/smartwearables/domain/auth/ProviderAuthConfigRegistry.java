package com.medisanaspace.healthx.dataloft.smartwearables.domain.auth;

import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.oauth.OAuthProperties;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProviders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
@Slf4j
public class ProviderAuthConfigRegistry {

    private static final Map<ActivityProviders, OAuthProperties> PROVIDER_AUTH_CONFIGS = new EnumMap<>(ActivityProviders.class);
    private static final Map<ActivityProviders, DeregistrationStrategy> PROVIDER_DEREGISTRATION_STRATEGIES = new EnumMap<>(ActivityProviders.class);

    public void register(ActivityProviders provider, OAuthProperties config) {
        if(PROVIDER_AUTH_CONFIGS.containsKey(provider)) {
            log.warn("A configuration has already been registered for provider {} and cannot be overriden", provider);
            return;
        }
        PROVIDER_AUTH_CONFIGS.put(provider, config);
    }

    public void register(ActivityProviders provider, DeregistrationStrategy strategy) {
        if(PROVIDER_DEREGISTRATION_STRATEGIES.containsKey(provider)) {
            log.warn("A deregistration strategy has already been registered for provider {} and cannot be overriden", provider);
            return;
        }
        PROVIDER_DEREGISTRATION_STRATEGIES.put(provider, strategy);
    }

    public OAuthProperties configurationFor(ActivityProviders provider) {
        return PROVIDER_AUTH_CONFIGS.get(provider);
    }

    public DeregistrationStrategy deregistrationStrategyFor(ActivityProviders provider) {
        return PROVIDER_DEREGISTRATION_STRATEGIES.get(provider);
    }

}
