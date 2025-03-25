package com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.oauth;

import com.google.api.client.auth.oauth.OAuthGetTemporaryToken;

@SuppressWarnings("java:S110")
public class SmartWearablesOAuthGetTemporaryToken extends OAuthGetTemporaryToken {
    public SmartWearablesOAuthGetTemporaryToken(String authorizationServerUrl, boolean usePost) {
        super(authorizationServerUrl);
        this.usePost = usePost;
    }
}
