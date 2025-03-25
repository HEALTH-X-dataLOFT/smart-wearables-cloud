package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.garmin;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GarminClientActivityDetail implements GarminPayload {

    private String userId;
    private String summaryId;
    private String userAccessToken;
    private long activityId;
    private GarminClientActivity summary;
    private List<GarminSample> samples;
    private List<GarminClientLap> laps;
}
