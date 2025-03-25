package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve.model;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ValueType {
    // activity
    STEPS(1000),
    AVG_HEART_RATE(3000),
    SPO2(3009),
    BURNED_CALORIES(1010),

    // sleep
    SLEEP_STATE(2000),
    SLEEP_LIGHT(2005),
    SLEEP_DEEP(2003),
    SLEEP_REM(2002),
    SLEEP_AWAKE(2006),
    SLEEP_LATENCY(2007),
    SLEEP_AWAKE_AFTER_WAKE_UP(2008),
    SLEEP_IN_BED(2001);

    private final int id;

    ValueType(int id) {
        this.id = id;
    }

    public boolean matchesId(String id) {
        return ("" + this.id).equals(id);
    }

    public boolean matchesId(int id) {
        return this.id == id;
    }

    public static ValueType fromId(int id) {
        return Arrays.stream(values())
                .filter(t -> t.id == id)
                .findFirst()
                .orElse(null);
    }
}
