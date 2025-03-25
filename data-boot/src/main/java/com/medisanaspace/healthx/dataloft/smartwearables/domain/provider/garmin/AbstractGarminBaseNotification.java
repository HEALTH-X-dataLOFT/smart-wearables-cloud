package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.garmin;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class AbstractGarminBaseNotification {

    @JsonProperty("summaryType")
    public GarminSummaryType summaryType;
    public String userId;
    public String userAccessToken;

    public AbstractGarminBaseNotification() {
    }

}
