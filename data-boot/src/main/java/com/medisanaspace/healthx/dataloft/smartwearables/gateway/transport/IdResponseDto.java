package com.medisanaspace.healthx.dataloft.smartwearables.gateway.transport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties({"@type", "@context"})
public class IdResponseDto {
    @JsonProperty("@id")
    private String id;

    @JsonProperty("edc:createdAt")
    private Long createdAt;
}
