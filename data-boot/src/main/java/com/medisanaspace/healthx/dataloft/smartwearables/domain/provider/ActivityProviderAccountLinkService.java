package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider;

import com.medisanaspace.healthx.dataloft.smartwearables.crypto.HashUtils;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.AccountLinkPropertySetter;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.AccountLinkPropertySetterFactory;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.oauth.AccessTokenData;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.User;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.UserService;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.base.entity.AbstractEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class ActivityProviderAccountLinkService extends AbstractEntityService<ActivityProviderAccountLink, UUID, ActivityProviderAccountLinkRepository> {

    private final AccountLinkPropertySetterFactory propertySetterFactory;
    private final UserService userService;

    @Autowired
    public ActivityProviderAccountLinkService(ActivityProviderAccountLinkRepository repository, AccountLinkPropertySetterFactory propertySetterFactory, UserService userService) {
        super(repository);
        this.propertySetterFactory = propertySetterFactory;
        this.userService = userService;
    }

    @Transactional
    public ActivityProviderAccountLink createAccountLinkFor(User user, ActivityProvider provider, AccessTokenData accessTokenData) throws NoSuchAlgorithmException {
        ActivityProviderAccountLink link = new ActivityProviderAccountLink();
        link.setProvider(provider);
        link.setAccessTokenSHA256(HashUtils.createSHA256Hash(accessTokenData.getToken()));

        link.setUser(user);

        link.setAccessTokenFormat("OPAQUE");
        link.setAuthType(AuthType.OAUTH_1);

        if (provider.isPersistAccessToken()) {
            link.setAccessToken(accessTokenData.getToken());
            link.setAccessTokenSecret(accessTokenData.getTokenSecret());
        }

        log.info("Setting provider-specific account link properties");
        AccountLinkPropertySetter providerSpecificAccountLinkPropertySetter = propertySetterFactory.forProvider(provider.getProviderKey(), accessTokenData);
        providerSpecificAccountLinkPropertySetter.setProviderSpecificLinkProperties(link);

        return this.save(link);
    }

    public boolean existsByProviderAndUser(ActivityProviders provider, User user) {
        return repository.existsByProvider_ProviderKeyAndUser(provider, user);
    }

    @Transactional
    public void removeAccountLinkFor(ActivityProviders provider, User user) {
        repository.deleteByProvider_ProviderKeyAndUser(provider, user);
    }

    @Transactional
    public void removeAllAccountLinksFor(User user) {
        repository.deleteAllByUser(user);
    }

    public Optional<ActivityProviderAccountLink> findByUserAndProvider(String userId, ActivityProviders provider) {
        User user = userService.findByKeycloakId(UUID.fromString(userId));
        return repository.findByUserAndProvider_ProviderKey(user, provider);
    }

    public User getUserForToken(String token) {
        try {
            String tokenHash = HashUtils.createSHA256Hash(token);
            Optional<ActivityProviderAccountLink> accountLink = repository.findByAccessTokenSHA256(tokenHash);
            return accountLink
                    .map(ActivityProviderAccountLink::getUser)
                    .orElseThrow();
        } catch (Exception e) {
            log.error("Failed to fetch user ID for token {} due to an error: ", token, e);
            return null;
        }
    }

    @Transactional
    public void deregisterUserWithToken(String token) {
        try {
            String tokenHash = HashUtils.createSHA256Hash(token);
            repository.deleteByAccessTokenSHA256(tokenHash);
            log.info("Deregistered user with token {}", token);
        } catch (Exception e) {
            log.error("Failed to deregister user for token {} due to an error: ", token, e);
        }
    }
}
