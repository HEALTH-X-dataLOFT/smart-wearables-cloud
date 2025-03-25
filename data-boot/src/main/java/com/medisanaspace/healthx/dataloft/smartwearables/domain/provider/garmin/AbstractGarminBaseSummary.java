package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.garmin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AbstractGarminBaseSummary implements GarminPayload {

    private String userId;
    private String summaryId;
    private String userAccessToken;

}
