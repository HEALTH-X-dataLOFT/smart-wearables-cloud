package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.garmin;

import com.google.api.client.util.Key;
import lombok.Getter;

@Getter
public class GarminGetUserIdApiResponse {

    @Key
    String userId;
}
