package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.garmin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GarminSample {

    private int startTimeInSeconds;
    private double latitudeInDegree;
    private double longitudeInDegree;
    private double elevationInMeters;
    private double airTemperatureCelcius;
    private int heartRate;
    private double speedMetersPerSecond;
    private double stepsPerMinute;
    private double totalDistanceInMeters;
    private double powerInWatts;
    private double bikeCadenceInRPM;
    private double swimCadenceInStrokesPerMinute;
    private double wheelChairCadenceInPushesPerMinute;
    private int timerDurationInSeconds;
    private int clockDurationInSeconds;
    private int movingDurationInSeconds;

}
