package com.medisanaspace.healthx.dataloft.smartwearables.domain.transport;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.gson.GsonFactory;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.oauth.AccessTokenData;
import lombok.Getter;

import java.io.IOException;

/**
 * Builds HTTP requests which are signed according to the OAuth 1 specification based on the specified access token data
 */
@Getter
public final class OAuthSignedRequestBuilder {

    private static final GsonFactory JSON_FACTORY = new GsonFactory();

    private final AccessTokenData accessTokenData;
    private final HttpTransport transport;
    private final HttpRequestFactory requestFactory;

    public OAuthSignedRequestBuilder(AccessTokenData accessTokenData) {
        this.accessTokenData = accessTokenData;
        this.transport = new NetHttpTransport();
        this.requestFactory = transport.createRequestFactory(createRequestInitializer(accessTokenData));
    }

    /**
     * Creates a request initializer that creates and adds the OAuth authorization header and a JSON parser to the request object
     * @return the {@link HttpRequestInitializer} object
     */
    private HttpRequestInitializer createRequestInitializer(AccessTokenData accessTokenData) {
        return httpRequest -> {
            httpRequest.setParser(new JsonObjectParser(JSON_FACTORY));
            accessTokenData.getOAuthParameters().initialize(httpRequest);
        };
    }

    /**
     * Proxy method for {@link HttpRequestFactory#buildDeleteRequest}
     */
    public HttpRequest buildDeleteRequest(GenericUrl url) throws IOException {
        return requestFactory.buildDeleteRequest(url);
    }

    /**
     * Proxy method for {@link HttpRequestFactory#buildGetRequest}
     */
    public HttpRequest buildGetRequest(GenericUrl url) throws IOException {
        return requestFactory.buildGetRequest(url);
    }

    /**
     * Proxy method for {@link HttpRequestFactory#buildPostRequest}
     */
    public HttpRequest buildPostRequest(GenericUrl url, HttpContent content) throws IOException {
        return requestFactory.buildPostRequest(url, content);
    }

    /**
     * Proxy method for {@link HttpRequestFactory#buildPutRequest}
     */
    public HttpRequest buildPutRequest(GenericUrl url, HttpContent content) throws IOException {
        return requestFactory.buildPutRequest(url, content);
    }

    /**
     * Proxy method for {@link HttpRequestFactory#buildPatchRequest}
     */
    public HttpRequest buildPatchRequest(GenericUrl url, HttpContent content) throws IOException {
        return requestFactory.buildPatchRequest(url, content);
    }

    /**
     * Proxy method for {@link HttpRequestFactory#buildHeadRequest}
     */
    public HttpRequest buildHeadRequest(GenericUrl url) throws IOException {
        return requestFactory.buildHeadRequest(url);
    }
}
