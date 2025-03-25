package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.garmin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GarminClientActivity extends AbstractGarminBaseSummaryDetails {

    private long activityId;
    private String activityName;
    private String activityDescription;
    private boolean isParent;
    private String parentSummaryId;
    private float averageBikeCadenceInRoundsPerMinute;
    private int averageHeartRateInBeatsPerMinute;
    private float averageRunCadenceInStepsPerMinute;
    private float averagePushCadenceInPushesPerMinute;
    private float averageSpeedInMetersPerSecond;
    private float averageSwimCadenceInStrokesPerMinute;
    private float averagePaceInMinutesPerKilometer;
    private String deviceName;
    private float maxBikeCadenceInRoundsPerMinute;
    private int maxHeartRateInBeatsPerMinute;
    private float maxPaceInMinutesPerKilometer;
    private float maxRunCadenceInStepsPerMinute;
    private float maxPushCadenceInPushesPerMinute;
    private float maxSpeedInMetersPerSecond;
    private int numberOfActiveLengths;
    private double startingLatitudeInDegree;
    private double startingLongitudeInDegree;
    private float totalElevationGainInMeters;
    private float totalElevationLossInMeters;
    private boolean manual;

}
