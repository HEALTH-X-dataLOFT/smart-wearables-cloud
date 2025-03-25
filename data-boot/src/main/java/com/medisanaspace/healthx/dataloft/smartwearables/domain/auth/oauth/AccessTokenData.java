package com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.oauth;

import com.google.api.client.auth.oauth.OAuthHmacSigner;
import com.google.api.client.auth.oauth.OAuthParameters;
import lombok.Data;

@Data
public class AccessTokenData {
    private String token;
    private String tokenSecret;
    private OAuthParameters oAuthParameters;

    private AccessTokenData() {

    }

    public static AccessTokenData of(String token, String tokenSecret, String consumerKey, String consumerSecret) {
        AccessTokenData data = new AccessTokenData();
        data.setToken(token);
        data.setTokenSecret(tokenSecret);
        data.setOAuthParameters(createParameters(token, tokenSecret, consumerKey, consumerSecret));
        return data;
    }

    private static OAuthParameters createParameters(String token, String tokenSecret, String consumerKey, String consumerSecret) {
        OAuthHmacSigner signer = new OAuthHmacSigner();
        signer.clientSharedSecret = consumerSecret;
        signer.tokenSharedSecret = tokenSecret;

        OAuthParameters params = new OAuthParameters();
        params.token = token;
        params.consumerKey = consumerKey;
        params.signer = signer;

        return params;
    }
}
