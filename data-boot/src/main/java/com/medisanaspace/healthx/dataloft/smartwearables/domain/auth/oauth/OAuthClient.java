package com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.oauth;

import com.google.api.client.auth.oauth.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class OAuthClient {

    private final Map<String, String> tokenSecrets = new HashMap<>();

    public OAuthClient() {
    }

    /**
     * Obtains an Unauthorized Request Token (compare <a href="https://oauth.net/core/1.0a/#auth_step1">OAuth 1.0a documentation</a>)
     * @param oAuthProperties The set of properties to use when acquiring the Unauthorized Request Token
     * @return An {@link OAuthAuthorizeTemporaryTokenUrl} holding the tepmoryry Unauthorized Request Token and pointing to the authorization endpoint of the authorization server specified within {@link OAuthProperties}.
     * @throws OAuthException if no Request Token could be retrieved
     */
    @Transactional
    public OAuthAuthorizeTemporaryTokenUrl obtainTemporaryRequestToken(OAuthProperties oAuthProperties) throws OAuthException {
        // Create request for obtaining a RequestToken
        OAuthHmacSigner signer = new OAuthHmacSigner();
        signer.clientSharedSecret = oAuthProperties.getConsumerSecret();

        OAuthGetTemporaryToken getTemporaryToken = new SmartWearablesOAuthGetTemporaryToken(oAuthProperties.getRequestTokenUrl(), true);
        getTemporaryToken.callback = oAuthProperties.getSuccessfulAuthorizationRedirectCallbackUrl();
        getTemporaryToken.consumerKey = oAuthProperties.getConsumerKey();
        getTemporaryToken.signer = signer;
        getTemporaryToken.transport = new NetHttpTransport();

        // Execute request
        OAuthCredentialsResponse requestTokenResponse;

        try {
            log.info("Performing request token request: " + getTemporaryToken.toURL());
            requestTokenResponse = getTemporaryToken.execute();
        } catch (Exception e) {
            throw new OAuthException("Failed to obtain request token from authorization server due to an error: \n" + e.getMessage());
        }

        if (requestTokenResponse == null || requestTokenResponse.token == null || requestTokenResponse.tokenSecret == null) {
            throw new OAuthException("Failed to obtain request token from authorization server");
        }

        this.tokenSecrets.put(requestTokenResponse.token, requestTokenResponse.tokenSecret);

        OAuthAuthorizeTemporaryTokenUrl authorizeTemporaryTokenUrl = new OAuthAuthorizeTemporaryTokenUrl(oAuthProperties.getAuthorizationCallbackUrl());
        authorizeTemporaryTokenUrl.temporaryToken = requestTokenResponse.token;
        return authorizeTemporaryTokenUrl;
    }

    /**
     * Requests an OAuth Access Token from the authorization server specified by {@code oauthProperties}
     * @param oauthToken The (authorized) Request Token to exchange for the Access Token
     * @param oauthVerifier The verification code associated to the Request Token
     * @param oAuthProperties The set of properties to use when acquiring the Access Token
     * @return A pair of the Access Token and associated OAuth properties
     * @throws OAuthException if no Access Token could be retrieved
     */
    @Transactional
    public AccessTokenData obtainAccessToken(String oauthToken, String oauthVerifier, OAuthProperties oAuthProperties) throws OAuthException {
        OAuthGetAccessToken oAuthGetAccessToken = new OAuthGetAccessToken(oAuthProperties.getAccessTokenUrl());

        OAuthHmacSigner signer = new OAuthHmacSigner();
        signer.clientSharedSecret = oAuthProperties.getConsumerSecret();
        signer.tokenSharedSecret = this.tokenSecrets.get(oauthToken);

        oAuthGetAccessToken.temporaryToken = oauthToken;
        oAuthGetAccessToken.verifier = oauthVerifier;
        oAuthGetAccessToken.consumerKey = oAuthProperties.getConsumerKey();
        oAuthGetAccessToken.signer = signer;
        oAuthGetAccessToken.transport = new NetHttpTransport();

        OAuthCredentialsResponse accessTokenResponse;
        try {
            accessTokenResponse = oAuthGetAccessToken.execute();
        } catch (IOException e) {
            throw new OAuthException("Failed to obtain access token from authorization server due to an error: \n" + e.getMessage());
        }

        if (accessTokenResponse == null || accessTokenResponse.token == null || accessTokenResponse.tokenSecret == null) {
            throw new OAuthException("Failed to obtain access token from authorization server");
        }

        return AccessTokenData.of(accessTokenResponse.token, accessTokenResponse.tokenSecret, oAuthProperties.getConsumerKey(), oAuthProperties.getConsumerSecret());
    }

}
