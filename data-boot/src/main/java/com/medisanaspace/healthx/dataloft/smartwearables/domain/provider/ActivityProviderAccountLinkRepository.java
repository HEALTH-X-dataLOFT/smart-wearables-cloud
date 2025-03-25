package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider;

import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ActivityProviderAccountLinkRepository extends JpaRepository<ActivityProviderAccountLink, UUID> {

    Optional<ActivityProviderAccountLink> findByAccessTokenSHA256(String accessTokenSha256Hash);

    void deleteByProvider_ProviderKeyAndUser(ActivityProviders provider, User user);

    boolean existsByProvider_ProviderKeyAndUser(ActivityProviders provider, User user);

    Optional<ActivityProviderAccountLink> findByUserAndProvider_ProviderKey(User user, ActivityProviders provider);

    void deleteByAccessTokenSHA256(String accessTokenSha256Hash);

    void deleteAllByUser(User user);
}
