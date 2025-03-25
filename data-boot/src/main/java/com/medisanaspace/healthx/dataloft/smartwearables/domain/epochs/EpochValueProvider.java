package com.medisanaspace.healthx.dataloft.smartwearables.domain.epochs;

import com.medisanaspace.healthx.dataloft.smartwearables.common.TimePeriod;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.User;

import java.util.Collection;

public interface EpochValueProvider<T extends Number> {
    Collection<EpochValue<T>> findEpochValuesFor(User user, TimePeriod timePeriod);
}
