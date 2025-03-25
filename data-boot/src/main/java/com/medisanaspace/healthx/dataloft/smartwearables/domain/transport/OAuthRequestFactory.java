package com.medisanaspace.healthx.dataloft.smartwearables.domain.transport;

import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.ProviderAuthConfigRegistry;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.oauth.AccessTokenData;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.oauth.OAuthProperties;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProvider;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProviderAccountLink;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProviders;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProviderAccountLinkService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;

@Component
@Getter
public class OAuthRequestFactory {

    private final ActivityProviderAccountLinkService accountLinkService;
    private final ProviderAuthConfigRegistry authConfigRegistry;

    @Autowired
    public OAuthRequestFactory(ActivityProviderAccountLinkService accountLinkService, ProviderAuthConfigRegistry authConfigRegistry) {
        this.accountLinkService = accountLinkService;
        this.authConfigRegistry = authConfigRegistry;
    }

    public OAuthSignedRequestBuilder builderFor(String userId, ActivityProviders provider) {
        Optional<ActivityProviderAccountLink> linkOpt = accountLinkService.findByUserAndProvider(userId, provider);
        return linkOpt
                .map(this::createRequestBuilderFor)
                .orElseThrow(() -> new EntityNotFoundException("Could not find account link for deletion request for user " + userId + " and provider " + provider));
    }

    private OAuthSignedRequestBuilder createRequestBuilderFor(ActivityProviderAccountLink link) {
        AccessTokenData accessTokenData = createAccessTokenDataFrom(link);
        return new OAuthSignedRequestBuilder(accessTokenData);
    }

    private AccessTokenData createAccessTokenDataFrom(ActivityProviderAccountLink link) {
        ActivityProvider provider = link.getProvider();
        OAuthProperties oAuthProperties = authConfigRegistry.configurationFor(provider.getProviderKey());
        String accessToken = link.getAccessToken();
        String accessTokenSecret = link.getAccessTokenSecret();
        String consumerKey = oAuthProperties.getConsumerKey();
        String consumerSecret = oAuthProperties.getConsumerSecret();
        return AccessTokenData.of(accessToken, accessTokenSecret, consumerKey, consumerSecret);
    }

}
