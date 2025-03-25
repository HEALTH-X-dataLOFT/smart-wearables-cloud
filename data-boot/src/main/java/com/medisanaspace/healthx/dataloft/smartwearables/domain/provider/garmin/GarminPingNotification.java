package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.garmin;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GarminPingNotification extends AbstractGarminBaseNotification {

    private long uploadStartTimeInSeconds;
    private long uploadEndTimeInSeconds;
    private String callbackURL;

}
