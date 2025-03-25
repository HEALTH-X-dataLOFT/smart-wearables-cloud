package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.garmin;

import com.google.api.client.auth.oauth.OAuthParameters;
import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.gson.GsonFactory;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.AccountLinkPropertySetter;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.oauth.AccessTokenData;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProviderAccountLink;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class GarminAccountLinkPropertySetter implements AccountLinkPropertySetter {

    public static final String USER_ID_API_URL = "https://apis.garmin.com/wellness-api/rest/user/id";
    private static final GsonFactory JSON_FACTORY = new GsonFactory();

    private final AccessTokenData accessTokenData;
    private final HttpTransport transport;

    public GarminAccountLinkPropertySetter(AccessTokenData accessTokenData) {
        this.accessTokenData = accessTokenData;
        this.transport = new NetHttpTransport();
    }

    public GarminAccountLinkPropertySetter(AccessTokenData accessTokenData, HttpTransport transport) {
        this.accessTokenData = accessTokenData;
        this.transport = transport;
    }

    /**
     * Fetches the API user id of the access token's user from the Garmin API so that the pushed data can be assigned to him later
     * @param link The link object to enhance with the user id
     */
    @Override
    public void setProviderSpecificLinkProperties(ActivityProviderAccountLink link) {
        try {
            HttpRequestFactory requestFactory = transport.createRequestFactory(createRequestInitializer());
            HttpRequest userIdRequest = requestFactory.buildGetRequest(new GenericUrl(USER_ID_API_URL));
            GarminGetUserIdApiResponse responseDto = userIdRequest.execute().parseAs(GarminGetUserIdApiResponse.class);
            link.setExternalApiUserId(responseDto.getUserId());
        } catch (IOException e) {
            OAuthParameters oAuthParameters = accessTokenData.getOAuthParameters();
            String authorization = oAuthParameters != null ? oAuthParameters.getAuthorizationHeader() : "<empty>";
            log.error("Failed to set user ID for Garmin account link due to an error: " + e.getMessage() +
                    "\n Authorization header was: " + authorization);
        }
    }

    /**
     * Creates a request initializer that creates and adds the OAuth authorization header and a JSON parser to the request object
     * @return the {@link HttpRequestInitializer} object
     */
    private HttpRequestInitializer createRequestInitializer() {
        return httpRequest -> {
            httpRequest.setParser(new JsonObjectParser(JSON_FACTORY));
            accessTokenData.getOAuthParameters().initialize(httpRequest);
        };
    }
}
