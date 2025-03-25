package com.medisanaspace.healthx.dataloft.smartwearables.gateway.transport;

import com.fasterxml.jackson.annotation.JsonProperty;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldResource;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldType;
import lombok.Data;

import java.util.Map;

@JsonldResource
@JsonldType("edc:dataAddress")
@Data
public class DataAddressDto {

    @JsonProperty("edc:type")
    private final String type;

    private final String baseUrl;

    private final Map<String, Object> properties;

    public Object getProperty(String key) {
        return this.properties.get(key);
    }
}
