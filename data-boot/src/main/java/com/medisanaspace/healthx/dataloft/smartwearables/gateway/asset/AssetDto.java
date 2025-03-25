package com.medisanaspace.healthx.dataloft.smartwearables.gateway.asset;

import java.util.Map;

public record AssetDto(String id, Map<String, Object> properties) {
    public Object getProperty(String key) {
        return this.properties.get(key);
    }
}
