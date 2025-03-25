package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve;

import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.User;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.epochs.EpochValue;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve.event.NoConnectionEvent;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve.exception.RequestFailedException;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve.exception.ThryveAuthenticationException;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve.exception.TokenNotValidException;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve.model.DynamicEpochValueResponse;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve.model.QueryOptions;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.*;

@Component
@Slf4j
public class ThryveClient {

    private static final String DATA_SOURCE = "/dataSourceURL";
    private static final String USER_INFORMATION = "/userInformation";
    private static final String ACCESS_TOKEN = "/accessToken";
    private static final String DYNAMIC_EPOCH_VALUES_URL = "/dynamicEpochValues";

    private static final String THRYVE_CREDENTIALS_NOT_VALID = "Thryve credentials are not valid";
    private static final String THRYVE_TOKEN_NOT_VALID = "Thryve token is not valid";
    private static final String THRYVE_REQUEST_FAILED = "Thryve request failed";

    private static final String APP_AUTHORIZATION = "AppAuthorization";
    private static final String PARTNER_USER_ID = "partnerUserID";
    private static final String AUTHENTICATION_TOKEN = "authenticationToken";
    private static final String DATA_SOURCES = "dataSources";
    private static final String VALUE_TYPES = "valueTypes";
    private static final String CREATE_AFTER_UNIX = "createdAfterUnix";
    private static final String START_TIMESTAMP = "startTimestamp";
    private static final String END_TIMESTAMP = "endTimestamp";
    private static final String DETAILED = "detailed";
    private static final int MAX_IN_MEMORY_SIZE_IN_BYTES = 2 * 1024 * 1024; // 2 MB
    public static final String DISPLAY_TYPE_NAME = "displayTypeName";

    private final String baseUrl;
    private final String username;
    private final String password;
    private final String appId;
    private final String appSecret;
    private final WebClient.Builder webClientBuilder;
    private final ApplicationEventPublisher eventPublisher;

    public ThryveClient(WebClient.Builder webClientBuilder,
                        @Value("${thryve.base-url}") String baseUrl,
                        @Value("${thryve.username}") String username,
                        @Value("${thryve.password}") String password,
                        @Value("${thryve.app-id}") String appId,
                        @Value("${thryve.app-secret}") String appSecret,
                        ApplicationEventPublisher eventPublisher) {
        this.webClientBuilder = webClientBuilder;
        this.baseUrl = baseUrl;
        this.username = username;
        this.password = password;
        this.appId = appId;
        this.appSecret = appSecret;
        this.eventPublisher = eventPublisher;
    }

    public String getAccessTokenFor(User user) {
        var formData = new LinkedMultiValueMap<String, String>();
        formData.add(PARTNER_USER_ID, "" + user.getId());

        try {
            return post(ACCESS_TOKEN, formData, String.class);
        } catch (WebClientResponseException e) {
            if (e.getStatusCode().value() == HttpStatus.UNAUTHORIZED.value()) {
                throw new ThryveAuthenticationException(THRYVE_CREDENTIALS_NOT_VALID, e);
            }
            throw new RequestFailedException(THRYVE_REQUEST_FAILED + e.getMessage(), e);
        }
    }

    public String createDataSourceURLFor(User user) {
        var formData = new LinkedMultiValueMap<String, String>();
        formData.add(AUTHENTICATION_TOKEN, user.getThryveToken());

        try {
            return post(DATA_SOURCE, formData, String.class);
        } catch (WebClientResponseException e) {
            handleHttpErrors(e, user);
            throw new RequestFailedException(THRYVE_REQUEST_FAILED + e.getMessage(), e);
        }
    }

    public Optional<UserInfo> getUserInfoFor(User user) {
        var formData = new LinkedMultiValueMap<String, String>();
        formData.add(AUTHENTICATION_TOKEN, user.getThryveToken());

        try {
            var userInfoList = post(USER_INFORMATION, formData, UserInfo[].class);
            return Arrays.stream(userInfoList)
                    .filter(userInfo -> user.getThryveToken().equals(userInfo.getAuthenticationToken()))
                    .findFirst();
        } catch (WebClientResponseException e) {
            handleHttpErrors(e, user);
            throw new RequestFailedException(THRYVE_REQUEST_FAILED + e.getMessage(), e);
        }
    }

    public void deleteUser(User user) {
        var queryData = Map.of(AUTHENTICATION_TOKEN, user.getThryveToken());
        try {
            delete(USER_INFORMATION, queryData);
        } catch (WebClientResponseException e) {
            handleHttpErrors(e, user);
            throw new RequestFailedException(THRYVE_REQUEST_FAILED + e.getMessage(), e);
        }
    }

    public List<EpochValue<Double>> fetchDynamicEpochValues(User user, QueryOptions queryOptions) {
        var formData = createFormDataFrom(user, queryOptions);
        try {
            var data = post(DYNAMIC_EPOCH_VALUES_URL, formData, DynamicEpochValueResponse[].class);
            return Arrays.stream(data)
                    .findFirst()
                    .flatMap(response -> response.getDataSources().stream().findFirst())
                    .map(DynamicEpochValueResponse.DataSourceData::getData)
                    .map(wearableData -> new ArrayList<EpochValue<Double>>(wearableData))
                    .orElseGet(ArrayList::new);
        } catch (WebClientResponseException e) {
            handleHttpErrors(e, user);
            throw new RequestFailedException(THRYVE_REQUEST_FAILED + e.getMessage(), e);
        }
    }

    private static LinkedMultiValueMap<String, String> createFormDataFrom(User user, QueryOptions queryOptions) {
        var formData = new LinkedMultiValueMap<String, String>();
        formData.add(AUTHENTICATION_TOKEN, user.getThryveToken());
        formData.add(DETAILED, "" + queryOptions.isDetailed());
        formData.add(DISPLAY_TYPE_NAME, "" + queryOptions.isDisplayTypeName());

        if (queryOptions.hasDataSources()) {
            formData.add(DATA_SOURCES, queryOptions.getDataSourcesAsString());
        }

        if (queryOptions.hasValueTypes()) {
            formData.add(VALUE_TYPES, queryOptions.getValueTypesAsString());
        }

        if (queryOptions.hasCreatedAfterUnix()) {
            formData.add(CREATE_AFTER_UNIX, "" + queryOptions.getCreatedAfterUnix());
        }

        if (queryOptions.hasStartTimestamp()) {
            formData.add(START_TIMESTAMP, queryOptions.getStartTimestamp().truncatedTo(SECONDS).toString());
        }

        if (queryOptions.hasEndTimestamp()) {
            formData.add(END_TIMESTAMP, queryOptions.getEndTimestamp().truncatedTo(SECONDS).toString());
        }

        return formData;
    }

    private <T> T post(String url, LinkedMultiValueMap<String, String> formData, Class<T> responseClass) {
        var client = getClient();
        return client.post()
                .uri(url)
                .body(BodyInserters.fromFormData(formData))
                .retrieve()
                .bodyToMono(responseClass)
                .doOnError(ThryveClient::logErrorResponse)
                .blockOptional()
                .orElseThrow();
    }

    private void delete(String url, Map<String, String> queryParams) {
        var client = getClient();
        var query = createUrlQuery(queryParams);
        client.delete()
                .uri(url + query)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    private WebClient getClient() {
        return webClientBuilder
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(MAX_IN_MEMORY_SIZE_IN_BYTES))
                .defaultHeaders(header -> header.setBasicAuth(username, password))
                .defaultHeaders(header -> header.set(APP_AUTHORIZATION, createAuthString()))
                .defaultHeaders(header -> header.setContentType(MediaType.APPLICATION_FORM_URLENCODED))
                .baseUrl(baseUrl)
                .build();
    }

    private String createAuthString() {
        var authString = appId + ":" + appSecret;
        var encodedBytes = Base64
                .getEncoder()
                .encode(authString.getBytes(StandardCharsets.UTF_8));
        var encodedAuthString = new String(encodedBytes, StandardCharsets.UTF_8);
        return "Basic " + encodedAuthString;
    }

    static String createUrlQuery(Map<String, String> queryParams) {
        return "?" + queryParams.entrySet().stream()
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining("&"));
    }

    private void handleHttpErrors(WebClientResponseException e, User user) {
        if (e.getStatusCode().value() == HttpStatus.UNAUTHORIZED.value()) {
            throw new ThryveAuthenticationException(THRYVE_CREDENTIALS_NOT_VALID, e);
        }
        if (e.getStatusCode().value() == HttpStatus.FORBIDDEN.value()) {
            eventPublisher.publishEvent(NoConnectionEvent.of(user.getId()));
            throw new TokenNotValidException(THRYVE_TOKEN_NOT_VALID, e);
        }
    }

    private static void logErrorResponse(Throwable throwable) {
        if(throwable instanceof WebClientResponseException errorResponse) {
            log.error("""
                POST request to Thryve API failed due to an error:
                Message: {}
                Response Body: {}""", errorResponse.getMessage(), errorResponse.getResponseBodyAsString(), errorResponse);
            return;
        }
        log.error("Exception while trying to perform Thryve request: {}", throwable.getMessage(), throwable);
    }
}

