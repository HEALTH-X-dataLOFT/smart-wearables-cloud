package com.medisanaspace.healthx.dataloft.smartwearables.domain.activity;

import com.medisanaspace.healthx.dataloft.smartwearables.common.TimePeriod;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.User;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.base.entity.AbstractEntityService;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.epochs.EpochValue;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.epochs.EpochValueProvider;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.epochs.PhenomenonType;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.Predicate;
import java.time.Instant;
import java.util.*;

import static com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.ActivityModel.DAILY;
import static com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.ActivityModel.EPOCH;
import static com.medisanaspace.healthx.dataloft.smartwearables.domain.epochs.PhenomenonType.*;
import static com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProviders.GARMIN;
import static org.springframework.data.jpa.domain.Specification.where;

@Service("garmin")
@Slf4j
public class ActivityService extends AbstractEntityService<Activity, UUID, ActivityRepository> implements EpochValueProvider<Integer> {
    public ActivityService(ActivityRepository repository) {
        super(repository);
    }

    public long deleteByExternalIdAndStartTime(String externalId, Instant startTime) {
        return repository.deleteByExternalIdAndStartTime(externalId, startTime);
    }

    public Optional<Activity> findByExternalIdAndStartTime(String externalId, Instant startTime) {
        return repository.findByExternalIdAndStartTime(externalId, startTime);
    }

    // NULLs are treated as wildcards
    public List<Activity> findByUserIdAndTypeAndTimePeriod(User user, ActivityModel model, TimePeriod timePeriod) {
        return repository.findAll(where(matchesUserAndModelAndPeriod(user, model, timePeriod)));
    }

    // NULLs are treated as wildcards
    public boolean existsByUserIdAndTypeAndTimePeriod(User user, ActivityModel model, TimePeriod timePeriod) {
        return repository.exists(where(matchesUserAndModelAndPeriod(user, model, timePeriod)));
    }

    static Specification<Activity> matchesUserAndModelAndPeriod(User user, ActivityModel type, TimePeriod period) {
        return (activity, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (user != null) {
                predicates.add(criteriaBuilder.equal(activity.get("user"), user));
            }
            if (type != null) {
                predicates.add(criteriaBuilder.equal(activity.get("activityModel"), type));
            }
            if (period != null) {
                Instant from = period.getFrom();
                Instant until = period.getTo();
                Predicate startTimeBetween = criteriaBuilder.between(activity.get("startTime"), from, until);
                Predicate endTimeBetween = criteriaBuilder.between(activity.get("endTime"), from, until);
                predicates.add(criteriaBuilder.and(startTimeBetween, endTimeBetween));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    public Optional<Activity> findByIdWithSamples(UUID id) {
        return repository.findByIdWithSamples(id);
    }

    @Override
    public Collection<EpochValue<Integer>> findEpochValuesFor(User user, TimePeriod timePeriod) {
        List<Activity> epochs = findByUserIdAndTypeAndTimePeriod(user, EPOCH, timePeriod);
        List<Activity> dailies = findByUserIdAndTypeAndTimePeriod(user, DAILY, timePeriod);

        List<EpochValue<Integer>> epochValues = epochs.stream()
                .map(ActivityService::mapToEpochValues)
                .flatMap(Collection::stream)
                .toList();
        Collection<ActivityEpochValue> heartRateSamples = dailies.stream()
                .flatMap(daily -> parseHeartRateSamplesFromDaily(daily).stream())
                .toList();

        ArrayList<EpochValue<Integer>> values = new ArrayList<>();
        values.addAll(epochValues);
        values.addAll(heartRateSamples);
        return values;
    }

    private static Collection<EpochValue<Integer>> mapToEpochValues(Activity activity) {
        ActivityEpochValue steps = mapToEpochValueOfType(activity, STEPS);
        ActivityEpochValue heartRate = mapToEpochValueOfType(activity, HEART_RATE);
        ActivityEpochValue kilocalories = mapToEpochValueOfType(activity, KILOCALORIES);
        return List.of(steps, heartRate, kilocalories);
    }

    private static Collection<ActivityEpochValue> parseHeartRateSamplesFromDaily(Activity activity) {
        if(!activity.hasSamples()) {
            log.warn("Cannot parse heart rates for timestamp {} from activity without samples of model {}", activity.getStartTime(), activity.getActivityModel());
            return Collections.emptyList();
        }
        return activity.getSamples()
                .stream()
                .map(ActivityService::mapHeartRateSampleToEpochValue)
                .toList();
    }

    private static ActivityEpochValue mapHeartRateSampleToEpochValue(Sample sample) {
        ActivityEpochValue epochValue = new ActivityEpochValue();
        epochValue.setValue(sample.getHeartRate());
        epochValue.setProvider(GARMIN.name());
        epochValue.setStart(sample.getTimestamp());
        epochValue.setCreatedAt(sample.getCreatedOn());
        epochValue.setPhenomenonType(HEART_RATE);
        return epochValue;
    }

    private static ActivityEpochValue mapToEpochValueOfType(Activity activity, PhenomenonType type) {
        ActivityEpochValue epochValue = new ActivityEpochValue();
        var value = switch (type) {
            case STEPS -> activity.getSteps();
            case HEART_RATE -> activity.getAvgHeartRage();
            case KILOCALORIES -> activity.getKilocalories();
            default -> null;
        };
        epochValue.setValue(value);
        epochValue.setProvider(GARMIN.name());
        epochValue.setStart(activity.getStartTime());
        epochValue.setEnd(activity.getEndTime());
        epochValue.setCreatedAt(activity.getCreatedOn());
        epochValue.setPhenomenonType(type);
        return epochValue;
    }

    @Data
    private static class ActivityEpochValue implements EpochValue<Integer> {
        Integer value;
        String provider;
        Instant start;
        Instant end;
        Instant createdAt;
        PhenomenonType phenomenonType;
    }
}
