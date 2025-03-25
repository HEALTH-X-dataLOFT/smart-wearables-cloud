package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve.model;

import lombok.Data;

import java.time.Instant;
import java.util.Set;

@Data
public class ConnectedSourcesDto {
    private int dataSource;
    private Instant connectedAt;
    private Set<String> dataScopes;
}
