package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ActivityProviderRepository extends JpaRepository<ActivityProvider, UUID> {

    boolean existsByProviderKey(ActivityProviders providerKey);

    Optional<ActivityProvider> findByProviderKey(ActivityProviders providerKey);
}
