package com.medisanaspace.healthx.dataloft.smartwearables.keycloak;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

@Service
@Slf4j
public class KeycloakClient {

    private static final String CLIENT_ID = "client_id";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String GRANT_TYPE = "grant_type";
    private static final String GRANT_TYPE_PASSWORD = "password";
    private static final String ACCESS_TOKEN_KEY = "access_token";

    private final String swcRealm;
    private final RestTemplate restTemplate;

    @Value("${keycloak-client.baseUrl}")
    String baseUrl;
    @Value("${keycloak-client.realm}")
    String realm;
    @Value("${keycloak-client.clientId}")
    String clientId;
    @Value("${keycloak-client.userName}")
    String userName;
    @Value("${keycloak-client.password}")
    String password;

    public KeycloakClient(@Value("${swc.keycloak-realm}") String swcRealm, RestTemplateBuilder restTemplateBuilder) {
        this.swcRealm = swcRealm;
        this.restTemplate = restTemplateBuilder
                .requestFactory(getClientHttpRequestFactory())
                .build();
    }

    private static Supplier<ClientHttpRequestFactory> getClientHttpRequestFactory() {
        return () -> new SimpleClientHttpRequestFactory() {
            protected void prepareConnection(HttpURLConnection connection,
                                             String httpMethod) throws IOException {
                super.prepareConnection(connection, httpMethod);
                // always follow redirect for any request method
                connection.setInstanceFollowRedirects(true);
            }
        };
    }

    private Optional<String> getAuthenticationToken() {
        String tokenUrl = baseUrl + "/realms/" + realm + "/protocol/openid-connect/token";

        try {
            HttpEntity<MultiValueMap<String, String>> tokenEntity = createAuthenticationRequestEntity();
            ResponseEntity<String> tokenResponse = restTemplate.exchange(tokenUrl, HttpMethod.POST, tokenEntity, String.class);

            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> value = mapper.readValue(tokenResponse.getBody(), Map.class);
            String accessToken = value.get(ACCESS_TOKEN_KEY);
            return Optional.of(accessToken);
        } catch (Exception e) {
            log.error("Failed to retrieve keycloak authentication token due to an error: ", e);
            return Optional.empty();
        }

    }

    public void deleteUser(User user) {
        UUID keycloakUserId = user.getKeycloakId();
        String deleteUrl = baseUrl + "/admin/realms/" + swcRealm + "/users/" + keycloakUserId;

        String authToken = getAuthenticationToken()
                .orElseThrow(() -> new FailedToRemoveKeycloakUserException("Failed to retrieve keycloak auth token"));

        HttpEntity<MultiValueMap<String, String>> deleteEntity = createDeletionRequestEntity(authToken);
        ResponseEntity<String> response = restTemplate.exchange(deleteUrl, HttpMethod.DELETE, deleteEntity, String.class);

        if (response.getStatusCodeValue() != HttpStatus.NO_CONTENT.value()) {
            String responseBody = response.getBody();
            String msg = "Failed to delete keycloak user %s with status %d due to an error: %s".formatted(keycloakUserId, response.getStatusCodeValue(), responseBody);
            throw new FailedToRemoveKeycloakUserException(msg);
        }
    }

    private MultiValueMap<String, String> getTokenFormValues() {
        MultiValueMap<String, String> tokenFormValues = new LinkedMultiValueMap<>();
        tokenFormValues.add(CLIENT_ID, clientId);
        tokenFormValues.add(USERNAME, userName);
        tokenFormValues.add(PASSWORD, password);
        tokenFormValues.add(GRANT_TYPE, GRANT_TYPE_PASSWORD);
        return tokenFormValues;
    }

    private HttpEntity<MultiValueMap<String, String>> createAuthenticationRequestEntity() {
        HttpHeaders tokenHeaders = new HttpHeaders();
        tokenHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> tokenFormValues = getTokenFormValues();
        return new HttpEntity<>(tokenFormValues, tokenHeaders);
    }

    private static HttpEntity<MultiValueMap<String, String>> createDeletionRequestEntity(String authToken) {
        HttpHeaders deleteHeaders = new HttpHeaders();
        deleteHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        deleteHeaders.setBearerAuth(authToken);

        return new HttpEntity<>(new LinkedMultiValueMap<>(), deleteHeaders);
    }
}
