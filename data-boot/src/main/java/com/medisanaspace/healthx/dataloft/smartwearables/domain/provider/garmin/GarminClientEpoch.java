package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.garmin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GarminClientEpoch extends AbstractGarminBaseSummaryDetails {

    private int activeTimeInSeconds;
    private float met;
    private String intensity;
    private double meanMotionIntensity;
    private double maxMotionIntensity;

}
