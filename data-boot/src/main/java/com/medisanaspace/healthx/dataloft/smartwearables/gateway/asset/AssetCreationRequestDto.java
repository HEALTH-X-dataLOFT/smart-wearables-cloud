package com.medisanaspace.healthx.dataloft.smartwearables.gateway.asset;

import com.medisanaspace.healthx.dataloft.smartwearables.gateway.transport.DataAddressDto;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldNamespace;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldResource;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@JsonldResource
@JsonldNamespace(name = "edc", uri = "https://w3id.org/edc/v0.0.1/ns/", applyToProperties = false)
@Data
public class AssetCreationRequestDto {
    public static final String ASSET_PROP_NAME = "asset:prop:name";
    public static final String ASSET_PROP_DESCRIPTION = "asset:prop:description";
    public static final String ASSET_PROP_CONTENTTYPE = "asset:prop:contenttype";
    public static final String BASE_URL = "baseUrl";
    public static final String METHOD = "method";
    public static final String PROXY_BODY = "proxyBody";
    public static final String PROXY_QUERY_PARAMS = "proxyQueryParams";
    public static final String CONTENT_TYPE = "contentType";
    public static final String TYPE = "edc:type";
    private final AssetDto asset;
    private final DataAddressDto dataAddress;

    public Object getAssetProperty(String key) {
        return this.asset.getProperty(key);
    }

    public Object getDataProperty(String key) {
        return this.dataAddress.getProperty(key);
    }

    public static AssetCreationRequestDto of(Asset asset) {
        return Builder
                .newInstance()
                .assetId("" + asset.getId())
                .assetName(asset.getName())
                .assetDescription(asset.getDescription())
                .dataBaseUrl(asset.getDataUrl())
                .build();
    }

    @NoArgsConstructor
    public static class Builder {

        String assetId;
        String assetName = "";
        String assetDescription = "";
        String assetContentType = "content/json";
        String dataBaseUrl = "";
        String dataMethod = "GET";
        String dataProxyBody = "false";
        String dataProxyQueryParams = "false";
        String dataContentType = "content/json";
        String dataType = "HttpData";

        public static Builder newInstance() {
            return new Builder();
        }

        public final Builder assetId(String id) {
            this.assetId = id;
            return this;
        }
        public final Builder assetName(String assetName) {
            this.assetName = assetName;
            return this;
        }
        public final Builder assetDescription(String assetDescription) {
            this.assetDescription = assetDescription;
            return this;
        }
        public final Builder assetContentType(String assetContentType) {
            this.assetContentType = assetContentType;
            return this;
        }
        public final Builder dataBaseUrl(String dataBaseUrl) {
            this.dataBaseUrl = dataBaseUrl;
            return this;
        }
        public final Builder dataMethod(String dataMethod) {
            this.dataMethod = dataMethod;
            return this;
        }
        public final Builder dataProxyBody(String dataProxyBody) {
            this.dataProxyBody = dataProxyBody;
            return this;
        }
        public final Builder dataProxyQueryParams(String dataProxyQueryParams) {
            this.dataProxyQueryParams = dataProxyQueryParams;
            return this;
        }
        public final Builder dataContentType(String dataContentType) {
            this.dataContentType = dataContentType;
            return this;
        }
        public final Builder dataType(String dataType) {
            this.dataType = dataType;
            return this;
        }

        public final AssetCreationRequestDto build() {
            Map<String, Object> assetProperties = new HashMap<>();
            assetProperties.put(ASSET_PROP_NAME, assetName);
            assetProperties.put(ASSET_PROP_DESCRIPTION, assetDescription);
            assetProperties.put(ASSET_PROP_CONTENTTYPE, assetContentType);

            Map<String, Object> dataProperties = new HashMap<>();
            dataProperties.put(METHOD, dataMethod);
            dataProperties.put(PROXY_BODY, dataProxyBody);
            dataProperties.put(PROXY_QUERY_PARAMS, dataProxyQueryParams);
            dataProperties.put(CONTENT_TYPE, dataContentType);

            AssetDto assetDto = new AssetDto(this.assetId, assetProperties);
            DataAddressDto dataAddressDto = new DataAddressDto(dataType, dataBaseUrl, dataProperties);
            return new AssetCreationRequestDto(assetDto, dataAddressDto);
        }

    }
}
