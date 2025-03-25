package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.garmin;

import com.google.api.client.auth.oauth.OAuthHmacSigner;
import com.google.api.client.auth.oauth.OAuthParameters;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.oauth.AccessTokenData;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProvider;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProviderAccountLink;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.AuthType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;

import java.util.List;

public class GarminAccountLinkPropertySetterTest {

    @Test
    void createsSignedUserIdRequestAndUpdatesAccountLink() {
        String accessToken = "abc123";
        String accessTokenSecret = "abc123-secret";
        String requestTokenSecret = "request42-secret";
        String consumerKey = "consumerKey42";
        String consumerSecret = "consumerKey42-secret";
        String verifier = "verifier";
        String userId = "123";

        OAuthHmacSigner signer = new OAuthHmacSigner();
        signer.clientSharedSecret = consumerSecret;
        signer.tokenSharedSecret = requestTokenSecret;

        OAuthParameters parameters = new OAuthParameters();
        parameters.nonce = "nonce";
        parameters.verifier = verifier;
        parameters.consumerKey = consumerKey;
        parameters.signer = signer;
        parameters.signatureMethod = "HMAC-SHA1";
        parameters.timestamp = "4321";
        parameters.token = accessToken;

        ActivityProviderAccountLink link = new ActivityProviderAccountLink();
        link.setAccessToken(accessToken);
        link.setAccessTokenSecret(accessTokenSecret);
        link.setProvider(new ActivityProvider());
        link.setAccessTokenFormat("OPAQUE");
        link.setAuthType(AuthType.OAUTH_1);

        AccessTokenData accessTokenData = AccessTokenData.of(accessToken, accessTokenSecret, consumerKey, consumerSecret);

        MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
        response.setContent("{\"userId\":\"" + userId + "\"}");
        response.setContentType("application/json");

        MockHttpTransport.Builder builder = new MockHttpTransport.Builder();
        builder.setLowLevelHttpResponse(response);
        MockHttpTransport transport = new MockHttpTransport(builder) {
        };

        GarminAccountLinkPropertySetter propertySetter = new GarminAccountLinkPropertySetter(accessTokenData, transport);

        propertySetter.setProviderSpecificLinkProperties(link);

        MockLowLevelHttpRequest lowLevelHttpRequest = transport.getLowLevelHttpRequest();
        List<String> authorizationValues = lowLevelHttpRequest.getHeaders().get(HttpHeaders.AUTHORIZATION.toLowerCase());

        Assertions.assertNotNull(authorizationValues);
        Assertions.assertEquals(1, authorizationValues.size());

        String authorization = authorizationValues.get(0);

        Assertions.assertTrue(authorization.contains("oauth_consumer_key"));
        Assertions.assertTrue(authorization.contains("oauth_token"));
        Assertions.assertTrue(authorization.contains("oauth_signature_method"));
        Assertions.assertTrue(authorization.contains("oauth_signature"));
        Assertions.assertTrue(authorization.contains("oauth_timestamp"));
        Assertions.assertTrue(authorization.contains("oauth_nonce"));

        Assertions.assertEquals(userId, link.getExternalApiUserId());
    }

}
