package com.medisanaspace.healthx.dataloft.smartwearables.gateway.transport;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HealthXRequestHeaders {
    X_API_KEY("x-api-key"),
    KVNR("kvnr"),
    FIRSTNAME("firstname"),
    LASTNAME("lastname"),
    BIRTHDATE("birthdate");

    private final String headerName;
}
