package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.garmin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GarminDeregistration implements GarminPayload {
    String userId;
    String userAccessToken;
}
