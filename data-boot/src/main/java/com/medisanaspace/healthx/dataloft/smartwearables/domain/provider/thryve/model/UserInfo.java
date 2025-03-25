package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve.model;

import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class UserInfo {

    private String authenticationToken;
    private String partnerUserID;
    private List<Object> devices;
    private List<ConnectedSourcesDto> connectedSources;

    public Optional<ConnectedSourcesDto> getDataSource(int dataSourceId) {
        return connectedSources.stream()
                .filter(source -> dataSourceId == source.getDataSource())
                .findFirst();
    }

}
