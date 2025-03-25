package com.medisanaspace.healthx.dataloft.smartwearables.domain;

import com.medisanaspace.healthx.dataloft.smartwearables.common.TimePeriod;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.Activity;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.ActivityRepository;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.User;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.UserService;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.epochs.EpochValue;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.epochs.EpochValueProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.criteria.Predicate;
import java.time.Instant;
import java.util.*;

import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class UserDataService<T extends Number> {

    private final ActivityRepository activityRepository;
    private final UserService userService;
    private final Map<String, EpochValueProvider<T>> epochProviders;

    @Autowired
    public UserDataService(ActivityRepository activityRepository, UserService userService, Map<String, EpochValueProvider<T>> epochProviders) {
        this.activityRepository = activityRepository;
        this.userService = userService;
        this.epochProviders = epochProviders;
    }

    public List<Activity> findActivitiesForUser(UUID userId) {
        User user = userService.findByKeycloakId(userId);
        return activityRepository.findAllByUserOrderByCreatedOnDescStartTimeDesc(user);
    }

    public Collection<EpochValue<T>> findEpochValuesForUserAfter(UUID userId, Instant start, String providerName) {
        User user = userService.findByKeycloakId(userId);
        EpochValueProvider<T> provider = this.epochProviders.get(providerName);
        TimePeriod period = TimePeriod.of(start, Instant.now());
        return provider.findEpochValuesFor(user, period);
    }

    @Transactional
    public void removeActivitiesForUser(User user) {
        activityRepository.deleteAllByUser(user);
    }

    static Specification<Activity> matchesUserIdAndStart(UUID userId, Instant start) {
        return (activity, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (userId != null) {
                predicates.add(criteriaBuilder.equal(activity.get("userId"), userId.toString()));
            }
            if (start != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(activity.get("startTime"), start));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
