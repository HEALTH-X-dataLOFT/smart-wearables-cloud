package com.medisanaspace.healthx.dataloft.smartwearables.domain.epochs;

import java.io.Serializable;
import java.time.Instant;

public interface EpochValue<T extends Serializable> {
    T getValue();
    String getProvider();
    Instant getStart();
    Instant getEnd();
    Instant getCreatedAt();
    PhenomenonType getPhenomenonType();

    default boolean hasStart() {
        return getStart() != null;
    }

    default boolean hasEnd() {
        return getEnd() != null;
    }
}
