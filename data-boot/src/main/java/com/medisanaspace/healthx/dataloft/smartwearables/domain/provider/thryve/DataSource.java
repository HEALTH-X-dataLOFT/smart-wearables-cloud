package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.Arrays;

public enum DataSource implements Serializable {
    // Active Data Sources
    FITBIT(1, "Fitbit"),
    GARMIN(2, "Garmin"),
    POLAR(3, "Polar"),
    APPLE(5, "Apple"),
    SAMSUNG(6, "Samsung"),
    WITHINGS(8, "Withings"),
    STRAVA(11, "Strava"),
    GOOGLEFIT_REST(12, "GoogleFit REST"),
    OMRONCONNECT(16, "OmronConnect"),
    SUUNTO(17, "Suunto"),
    OURA(18, "Oura"),
    IHEALTH(21, "iHealth"),
    FREESTYLELIBRE(22, "FreeStyleLibre"),
    BEURER(27, "Beurer"),
    HUAWEIHEALTH(38, "HuaweiHealth"),
    GOOGLEFIT_NATIVE(40, "GoogleFit Native"),
    DEXCOM(41, "Dexcom"),
    WHOOP(42, "Whoop"),
    DECATHLON(43, "Decathlon"),
    HEALTHCONNECT(44, "HealthConnect"),

    // Experimental Data Sources
    MYFITNESSPAL(14, "MyFitnessPal"),
    RUNTASTIC(15, "Runtastic"),
    RUNKEEPER(19, "Runkeeper"),
    ENDOMONDO(20, "Endomondo"),
    ISENS(23, "i-Sens"),
    SLEEPASANDROID(24, "Sleep As Android"),
    CLUE(25, "Clue"),
    HEALTHFORYOU(26, "HealthForYou"),
    LYKON(30, "Lykon"),
    OVY(32, "Ovy"),
    MOTIV(33, "Motiv"),
    MEDISAFE(34, "Medisafe"),
    BBRAUN(35, "B.Braun"),
    ROCHEACCUCHEK(36, "Rocheaccuchek"),
    BIOMES(37, "Biomes");

    public static DataSource forId(int id) {
        return Arrays.stream(values())
                .filter(source -> source.id() == id)
                .findFirst()
                .orElse(null);
    }

    private final int id;

    @JsonValue
    private final String displayName;

    DataSource(int id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public int id() {
        return id;
    }

    public String displayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
