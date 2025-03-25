package com.medisanaspace.healthx.dataloft.smartwearables.domain;

import com.medisanaspace.healthx.dataloft.smartwearables.common.TimePeriod;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.epochs.EpochValue;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.epochs.PhenomenonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Component
@Slf4j
public class UserDataAggregator <T extends Number> {

    private static final ZoneId APP_TIMEZONE = ZoneId.of("Europe/Berlin");

    public List<EpochValue<Double>> aggregateValues(List<EpochValue<T>> inputValues, ChronoUnit chronoUnit) {
        log.info("Aggregating values for {} values", inputValues.size());
        Instant start = Instant.now();
        Map<PhenomenonType, Map<TimePeriod, List<T>>> aggregationsByType = new EnumMap<>(PhenomenonType.class);

        // Create aggregation map for each phenomenon type
        inputValues.stream()
                .map(EpochValue::getPhenomenonType)
                .distinct()
                .forEach(type -> aggregationsByType.put(type, createAggregationMap(inputValues, chronoUnit)));

        // Add input values to appropriate collection of aggregation map
        for (EpochValue<T> value : inputValues) {
            var aggregations = aggregationsByType.get(value.getPhenomenonType());
            for (Map.Entry<TimePeriod, List<T>> entry : aggregations.entrySet()) {
                if (entry.getKey().contains(value.getStart())) {
                    entry.getValue().add(value.getValue());
                    break;
                }
            }
        }

        // Compute aggregated values for each individual combination of phenomenon type and time period
        List<EpochValue<Double>> aggregatedValues = aggregationsByType.entrySet()
                .stream()
                .flatMap(phenTypPeriodMapEntry -> phenTypPeriodMapEntry.getValue()
                        .entrySet()
                        .stream()
                        .map(entry -> performAggregationForPeriodValuesMapEntry(phenTypPeriodMapEntry.getKey(), entry)))
                .toList();

        Duration duration = Duration.between(start, Instant.now());
        log.info("Completed aggregation of {} input values to {} aggregated values in total within {}", inputValues.size(), aggregatedValues.size(), duration);
        return aggregatedValues;
    }

    private EpochValue<Double> performAggregationForPeriodValuesMapEntry(PhenomenonType type, Map.Entry<TimePeriod, List<T>> periodValsEntry) {
        List<T> individualValues = periodValsEntry.getValue()
                .stream()
                .filter(val -> val != null && val.doubleValue() > 0)
                .toList();

        var sum = individualValues
                .stream()
                .reduce(0.0, (a, b) -> a + b.doubleValue(), Double::sum);
        Double value = switch (type) {
            case STEPS -> sum;
            case HEART_RATE -> !individualValues.isEmpty() ? Math.round(sum / individualValues.size()) * 1.0d : null;
            case HeartRate -> !individualValues.isEmpty() ? Math.round(sum / individualValues.size()) * 1.0d : null;
            case SPO2 -> !individualValues.isEmpty() ? Math.round(sum / individualValues.size()) * 1.0d : null;
            default -> sum;
        };

        TimePeriod period = periodValsEntry.getKey();
        return AggregationValue.of(value, null, period.getStart(), period.getEnd(), Instant.now(), type);
    }

    private Map<TimePeriod, List<T>> createAggregationMap(List<EpochValue<T>> inputValues, ChronoUnit chronoUnit) {
        Map<TimePeriod, List<T>> aggregations = new HashMap<>();
        var start = inputValues.stream()
                .filter(EpochValue::hasStart)
                .min(Comparator.comparing(EpochValue::getStart))
                .orElseThrow()
                .getStart()
                .atZone(APP_TIMEZONE)
                .truncatedTo(ChronoUnit.DAYS)
                .toInstant();
        var end = inputValues.stream()
                .filter(EpochValue::hasEnd)
                .max(Comparator.comparing(EpochValue::getEnd))
                .orElseThrow()
                .getEnd()
                .atZone(APP_TIMEZONE)
                .plusDays(1)
                .truncatedTo(ChronoUnit.DAYS)
                .toInstant();
        TimePeriod coveredPeriodInWholeDays = TimePeriod.of(start, end);
        List<TimePeriod> aggregationPeriods = coveredPeriodInWholeDays.splitInto(chronoUnit);

        aggregationPeriods.forEach(period -> aggregations.put(period, new LinkedList<>()));
        return aggregations;
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    public static class AggregationValue implements EpochValue<Double> {
        Double value;
        String provider;
        Instant start;
        Instant end;
        Instant createdAt;
        PhenomenonType phenomenonType;
    }
}
