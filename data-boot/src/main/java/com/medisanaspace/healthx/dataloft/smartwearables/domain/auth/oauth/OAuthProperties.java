package com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.oauth;

import java.net.URLEncoder;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Represents a set of properties used for performing OAuth1 authorization attempts
 */
public interface OAuthProperties {

    /**
     * A URL pointing to an auth servers endpoint from which an unauthorized request token may be obtained
     * @return The request token URL
     */
    String getRequestTokenUrl();

    /**
     * A URL pointing to a login form for authorizing an unauthorized request token
     * @return The login form URL
     */
    String getAuthorizationCallbackUrl();

    /**
     * A URL of a consumer page to which users should be redirected after completing the login form
     * @return The redirect callback URL
     */
    String getSuccessfulAuthorizationRedirectCallbackUrl();

    /**
     * A URL allowing to deregister the user from data synchronization/invalidating the user's OAuth User Access Token
     * @return The redirect callback URL
     */
    String getDeregistrationUrl();

    /**
     * A URL pointing to an auth server endpoint from which an access token may be obtained
     * @return The access token URL
     */
    String getAccessTokenUrl();

    /**
     * The consumer application's key for accessing the auth server's OAuth API endpoints
     * @return The consumer key
     */
    String getConsumerKey();

    /**
     * The consumer application's secret for accessing the auth server's OAuth API endpoints
     * @return The consumer secret
     */
    String getConsumerSecret();

    default String getEncodedSuccessfulAuthorizationRedirectCallbackUrl() {
        return URLEncoder.encode(getSuccessfulAuthorizationRedirectCallbackUrl(), UTF_8);
    }

}
