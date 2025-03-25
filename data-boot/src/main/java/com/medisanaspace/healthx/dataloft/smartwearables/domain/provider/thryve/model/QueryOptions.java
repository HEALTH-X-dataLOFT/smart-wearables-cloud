package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.Instant;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import static com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve.model.ValueType.*;

@AllArgsConstructor
@Getter
@EqualsAndHashCode(exclude = {"createdAfterUnix"})
public class QueryOptions {

    private static final Set<ValueType> DEFAULT_QUERY_VALUE_TYPES = Set.of(STEPS,
            AVG_HEART_RATE,
            BURNED_CALORIES);

    private Long createdAfterUnix;
    private Instant startTimestamp;
    private Instant endTimestamp;
    private Set<Integer> dataSources;
    private Set<ValueType> valueTypes;
    private boolean detailed;
    private boolean displayTypeName;

    public static QueryOptions of(Instant startTimestamp, Instant endTimestamp, Set<Integer> dataSources, Set<ValueType> valueTypes, boolean detailed, boolean displayTypeName) {
        return new QueryOptions(null, startTimestamp, endTimestamp, dataSources, valueTypes, detailed, displayTypeName);
    }

    public static QueryOptions of(Instant startTimestamp, Instant endTimestamp) {
        return new QueryOptions(null, startTimestamp, endTimestamp, Collections.emptySet(), DEFAULT_QUERY_VALUE_TYPES, true, true);
    }

    public String getDataSourcesAsString() {
        return dataSources.stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));
    }

    public String getValueTypesAsString() {
        return valueTypes.stream()
                .map(ValueType::getId)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }

    public boolean hasDataSources() {
        return !dataSources.isEmpty();
    }

    public boolean hasValueTypes() {
        return !valueTypes.isEmpty();
    }

    public boolean hasCreatedAfterUnix() {
        return createdAfterUnix != null;
    }

    public boolean hasStartTimestamp() {
        return startTimestamp != null;
    }

    public boolean hasEndTimestamp() {
        return endTimestamp != null;
    }
}
