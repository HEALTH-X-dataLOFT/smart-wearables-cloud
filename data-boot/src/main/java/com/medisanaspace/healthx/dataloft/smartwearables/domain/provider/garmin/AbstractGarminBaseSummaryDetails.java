package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.garmin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AbstractGarminBaseSummaryDetails extends AbstractGarminBaseSummary {

    private String activityType;
    private int activeKilocalories;
    private int steps;
    private int pushes;
    private float distanceInMeters;
    private float pushDistanceInMeters;
    private int durationInSeconds;
    private long startTimeInSeconds;
    private long startTimeOffsetInSeconds;

}
