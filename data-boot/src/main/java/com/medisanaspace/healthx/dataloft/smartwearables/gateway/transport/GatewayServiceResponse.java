package com.medisanaspace.healthx.dataloft.smartwearables.gateway.transport;


import lombok.Getter;

import java.util.List;

@Getter
public class GatewayServiceResponse {
    private final boolean hasData;
    private final List<String> dataTypes;
    private final List<String> assetIds;

    private GatewayServiceResponse(boolean hasData, List<String> dataTypes, List<String> assetIds) {
        this.hasData = hasData;
        this.dataTypes = dataTypes;
        this.assetIds = assetIds;
    }

    public static GatewayServiceResponse of(boolean hasData, List<String> dataTypes, List<String> assetIds) {
        return new GatewayServiceResponse(hasData, dataTypes, assetIds);
    }

}
