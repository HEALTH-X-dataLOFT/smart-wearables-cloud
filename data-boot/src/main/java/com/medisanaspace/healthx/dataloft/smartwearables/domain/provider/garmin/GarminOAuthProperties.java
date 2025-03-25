package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.garmin;

import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.oauth.OAuthProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "swc.vendors.garmin.oauth1")
public class GarminOAuthProperties implements OAuthProperties {
    @Value("${requestTokenUrl:#{'https://connectapi.garmin.com/oauth-service/oauth/request_token'}}")
    public String requestTokenUrl;

    @Value("${authorizationCallbackUrl:#{'https://connect.garmin.com/oauthConfirm'}}")
    public String authorizationCallbackUrl;

    @Value("${successfulAuthorizationRedirectCallbackUrl:#{'http://localhost:7272/data/external-vendors'}}")
    public String successfulAuthorizationRedirectCallbackUrl;

    @Value("${accessTokenUrl:#{'https://connectapi.garmin.com/oauth-service/oauth/access_token'}}")
    public String accessTokenUrl;

    @Value("${deregistrationUrl:#{'https://apis.garmin.com/wellness-api/rest/user/registration'}}")
    public String deregistrationUrl;

    @Value("${consumerKey:#{''}}")
    public String consumerKey;

    @Value("${consumerSecret:#{''}}")
    public String consumerSecret;
}
