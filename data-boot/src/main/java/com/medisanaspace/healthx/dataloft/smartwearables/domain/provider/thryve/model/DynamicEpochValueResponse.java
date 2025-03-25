package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class DynamicEpochValueResponse {

    private String authenticationToken;
    private String partnerUserID;
    private List<DataSourceData> dataSources;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @JsonIgnoreProperties(ignoreUnknown=true)
    public static class DataSourceData {
        private Integer dataSource;
        private List<WearableData> data;
    }
}
