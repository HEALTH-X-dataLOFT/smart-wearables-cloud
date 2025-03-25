package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.epochs.EpochValue;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.epochs.PhenomenonType;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProviders;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

@Data
@AllArgsConstructor(staticName = "of")
@Slf4j
@SuppressWarnings("java:S115")
public class WearableData implements EpochValue<Double> {

    // Naming conventions are ignored here intentionally to reflect original descriptors
    enum BiomarkerValueType {
        STRING,
        DOUBLE,
        LONG,
        BOOLEAN,
        JSON,
        DATE,
        Binary,
        FLOAT
    }

    private static final String HEART_RATE = "HeartRate";
    private static final String STEPS = "Steps";
    private static final String CONSUMED_CALORIES = "ConsumedCalories";

    private String dynamicValueTypeName;
    private Integer dynamicValueType;

    @JsonProperty("value")
    @Getter(AccessLevel.NONE)
    private String plainValue;

    private BiomarkerValueType valueType;

    @JsonProperty("createdAtUnix")
    private Instant createdAt;

    @JsonProperty("startTimestamp")
    private Instant startTimestamp;

    @JsonProperty("endTimestamp")
    private Instant endTimestamp;

    @JsonProperty(value = "startTimestampUnix")
    private Instant startTimestampUnix;

    @JsonProperty(value = "endTimestampUnix")
    private Instant endTimestampUnix;

    private Details details;

    public Double getValue() {
        if (plainValue == null) {
            return null;
        }
        return switch (valueType) {
            case LONG -> Long.valueOf(plainValue).doubleValue();
            case DOUBLE -> Double.valueOf(plainValue);
            case FLOAT -> Float.valueOf(plainValue).doubleValue();
            default -> throw new IllegalStateException("Unexpected Thryve value type: " + valueType);
        };
    }

    @Override
    public String getProvider() {
        return ActivityProviders.THRYVE.name();
    }

    public Instant getStart() {
        return startTimestamp != null ? startTimestamp : startTimestampUnix;
    }

    @Override
    public Instant getEnd() {
        return endTimestamp != null ? endTimestamp : endTimestampUnix;
    }

    @Override
    public PhenomenonType getPhenomenonType() {
        try {
            return switch (dynamicValueTypeName) {
                case HEART_RATE -> PhenomenonType.HEART_RATE;
                case STEPS -> PhenomenonType.STEPS;
                case CONSUMED_CALORIES -> PhenomenonType.KILOCALORIES;
                default -> PhenomenonType.valueOf(dynamicValueTypeName);
            };
        } catch (IllegalArgumentException e) {
            log.warn("Could not infer EpochValueType from dynamicValueType {}/{} (falling back to EpochValueType.UNKNOWN instead)", dynamicValueTypeName, dynamicValueType);
            return PhenomenonType.UNKNOWN;
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Details {
        boolean medicalGrade;
        long chronologicalExactness;
        long timezoneOffset;
        String generation;
    }

}