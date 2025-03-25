package com.medisanaspace.healthx.dataloft.smartwearables.gateway.transport;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medisanaspace.healthx.dataloft.smartwearables.gateway.asset.Asset;
import com.medisanaspace.healthx.dataloft.smartwearables.gateway.asset.AssetCreationRequestDto;
import ioinformarics.oss.jackson.module.jsonld.JsonldModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@Slf4j
public class AssetCatalogClient {

    public static final String CONTENT_TYPE = "Content-Type";
    public static final String APPLICATION_JSON = "application/json";

    @Value("${edc.api.key:#{''}}")
    private String apiKey;

    @Value("${connector.assetgeneration.endpoint.url:#{''}}")
    private String assetGenerationEndpointUrl;

    private final ObjectMapper mapper;

    public AssetCatalogClient() {
        this.mapper = createObjectMapper();
    }

    private ObjectMapper createObjectMapper() {
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.registerModule(new JsonldModule());
        return jsonMapper;
    }

    public void createCatalogEntriesFor(Collection<Asset> assets) throws CatalogEntryCreationFailedException {
        for (Asset asset : assets) {
            AssetCreationRequestDto requestDto = AssetCreationRequestDto.of(asset);

            Map<String, String> headers = createHttpHeadersFrom(asset);
            Optional<IdResponseDto> idResponseDto = performCatalogEntryCreationRequestFor(headers, requestDto);

            // Update assets for which entries were created, delete other ones to keep in sync with the asset catalogue
            idResponseDto.ifPresent(responseDto -> asset.setCatalogueAssetId(responseDto.getId()));
        }
    }

    private static Map<String, String> createHttpHeadersFrom(Asset asset) {
        Map<String, String> headers = new HashMap<>();
        headers.put("user-id", "" + asset.getUserId());
        headers.put(HealthXRequestHeaders.KVNR.getHeaderName(), "" + asset.getUserId());
        headers.put(HealthXRequestHeaders.FIRSTNAME.getHeaderName(), "NULL");
        headers.put(HealthXRequestHeaders.LASTNAME.getHeaderName(), "NULL");
        headers.put(HealthXRequestHeaders.BIRTHDATE.getHeaderName(), "NULL");
        return headers;
    }

    /**
     * Perform request to the configured connector {@code assetGenerationEndpointUrl} to create a new catalog entry in the connector
     */
    public Optional<IdResponseDto> performCatalogEntryCreationRequestFor(Map<String, String> headers, AssetCreationRequestDto assetCreationRequestDto) throws CatalogEntryCreationFailedException {
        HttpPost request = new HttpPost(assetGenerationEndpointUrl);
        request.setHeader(CONTENT_TYPE, APPLICATION_JSON);
        request.setHeader(HealthXRequestHeaders.X_API_KEY.getHeaderName(), apiKey);

        for (Map.Entry<String, String> entry : headers.entrySet()) {
            request.setHeader(entry.getKey(), entry.getValue());
        }

        try {
            String bodyJson = mapper.writeValueAsString(assetCreationRequestDto);
            request.setEntity(new StringEntity(bodyJson, StandardCharsets.UTF_8));
        } catch (Exception e) {
            throw new CatalogEntryCreationFailedException("Could not generate body JSON for catalog request item due to an error", e);
        }

        try (CloseableHttpClient client = HttpClients.createDefault(); CloseableHttpResponse response = client.execute(request)) {
            byte[] content = response.getEntity().getContent().readAllBytes();
            String responseBody = new String(content);
            IdResponseDto responseDto = mapper.readValue(responseBody, IdResponseDto.class);
            return Optional.of(responseDto);
        } catch (Exception e) {
            throw new CatalogEntryCreationFailedException("Failed to create catalog entry for asset", e);
        }
    }
}
