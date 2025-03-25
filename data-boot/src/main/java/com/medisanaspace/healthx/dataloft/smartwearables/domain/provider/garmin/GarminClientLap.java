package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.garmin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class GarminClientLap {

    private Instant startTimeInSeconds;

}
