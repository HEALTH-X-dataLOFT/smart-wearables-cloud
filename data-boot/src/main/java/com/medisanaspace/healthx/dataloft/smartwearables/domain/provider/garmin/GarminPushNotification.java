package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.garmin;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GarminPushNotification<T> extends AbstractGarminBaseNotification {

    private List<T> summaryData;

}
