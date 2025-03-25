package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.garmin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class GarminClientDaily extends AbstractGarminBaseSummaryDetails {

    private String calendarDate;
    private int bmrKilocalories;
    private int activeTimeInSeconds;
    private int moderateIntensityDurationInSeconds;
    private int vigorousIntensityDurationInSeconds;
    private int floorsClimbed;
    private int minHeartRateInBeatsPerMinute;
    private int maxHeartRateInBeatsPerMinute;
    private int averageHeartRateInBeatsPerMinute;
    private int restingHeartRateInBeatsPerMinute;
    private Map<String, Integer> timeOffsetHeartRateSamples = new HashMap<>();
    private String source;
    private int stepsGoal;
    private int pushesGoal;
    private int intensityDurationGoalInSeconds;
    private int floorsClimbedGoal;
    private int averageStressLevel;
    private int maxStressLevel;
    private int stressDurationInSeconds;
    private int restStressDurationInSeconds;
    private int activityStressDurationInSeconds;
    private int lowStressDurationInSeconds;
    private int mediumStressDurationInSeconds;
    private int highStressDurationInSeconds;
    private String stressQualifier;

    public Map<String, Integer> getTimeOffsetHeartRateSamples() {
        if(timeOffsetHeartRateSamples == null) {
            timeOffsetHeartRateSamples = new HashMap<>();
        }
        return timeOffsetHeartRateSamples;
    }
}
