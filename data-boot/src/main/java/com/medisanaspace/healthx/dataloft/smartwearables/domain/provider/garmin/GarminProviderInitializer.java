package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.garmin;

import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.ProviderAuthConfigRegistry;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProvider;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProviderRepository;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProviders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class GarminProviderInitializer {

    ActivityProviderRepository providerRepository;
    private final GarminOAuthProperties oAuthProperties;
    private final GarminDeregistrationStrategy deregistrationStrategy;
    private final ProviderAuthConfigRegistry authConfigRegistry;

    @Autowired
    public GarminProviderInitializer(ActivityProviderRepository providerRepository, GarminOAuthProperties garminOAuthProperties, GarminDeregistrationStrategy deregistrationStrategy, ProviderAuthConfigRegistry authConfigRegistry) {
        this.providerRepository = providerRepository;
        this.oAuthProperties = garminOAuthProperties;
        this.deregistrationStrategy = deregistrationStrategy;
        this.authConfigRegistry = authConfigRegistry;
    }

    @Transactional
    @EventListener(ContextRefreshedEvent.class)
    public synchronized void initialize() {
        // Register OAuth configuration for later use
        authConfigRegistry.register(ActivityProviders.GARMIN, oAuthProperties);
        authConfigRegistry.register(ActivityProviders.GARMIN, deregistrationStrategy);

        if (providerRepository.existsByProviderKey(ActivityProviders.GARMIN)) {
            log.info("Found existing ActivityProvider GARMIN, not creating a new one.");
            return;
        }

        log.info("Creating a new ActivityProvider GARMIN since no existing one could be found");

        // Create new Garmin provider entity
        ActivityProvider garmin = new ActivityProvider();
        garmin.setProviderKey(ActivityProviders.GARMIN);
        garmin.setPersistAccessToken(true);
        providerRepository.save(garmin);

        log.info("Created new ActivityProvider.");
    }

}
