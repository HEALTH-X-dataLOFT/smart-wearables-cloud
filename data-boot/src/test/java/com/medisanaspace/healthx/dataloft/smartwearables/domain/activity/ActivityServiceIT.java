package com.medisanaspace.healthx.dataloft.smartwearables.domain.activity;

import com.medisanaspace.DataBootApplication;
import com.medisanaspace.healthx.dataloft.smartwearables.common.TimePeriod;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.User;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.UserService;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve.ThryveClient;
import com.medisanaspace.healthx.dataloft.smartwearables.keycloak.KeycloakClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

import static com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.ActivityModel.*;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.HOURS;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = DataBootApplication.class
)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ActivityServiceIT {

    public static final String EUROPE_BERLIN = "Europe/Berlin";
    public static final ZoneId GERMANY = ZoneId.of(EUROPE_BERLIN);

    @Autowired
    private ActivityService activityService;

    @Autowired
    private UserService userService;

    @MockitoBean
    private ClientRegistrationRepository clientRegistrationRepository;

    @MockitoBean
    private KeycloakClient keycloakClient;

    @MockitoBean
    private ThryveClient thryveClient;

    @Transactional
    @Test
    void findsExpectedActivitiesForAsset() {
        Instant queryFrom = LocalDate.of(2024, 2, 1)
                .atStartOfDay(GERMANY)
                .toInstant();
        Instant queryUntil = LocalDate.of(2024, 2, 29)
                .atStartOfDay(GERMANY)
                .plusDays(1)
                .toInstant();
        User queryUser = new User();
        queryUser.setKeycloakId(UUID.randomUUID());
        queryUser = userService.save(queryUser);

        List<Activity> typeAndPeriodMatches = List.of(
                createActivity(queryUser, ACTIVITY, queryFrom, queryUntil),
                createActivity(queryUser, ACTIVITY, queryFrom.plus(1, DAYS), queryUntil.minus(1, DAYS))
        );

        List<Activity> typeMatches = List.of(
                createActivity(queryUser, DAILY, queryFrom, queryUntil),
                createActivity(queryUser, DAILY, queryFrom.minusMillis(1), queryUntil),
                createActivity(queryUser, DAILY, queryFrom, queryUntil.plusMillis(1)),
                createActivity(queryUser, DAILY, queryFrom.minus(1, DAYS), queryFrom),
                createActivity(queryUser, DAILY, queryFrom.minus(2, HOURS), queryFrom.minus(1, HOURS)),
                createActivity(queryUser, DAILY, queryUntil.plus(1, HOURS), queryUntil.plus(2, HOURS))
        );

        Instant queryFrom2 = queryFrom.plus(100, DAYS);
        Instant queryUntil2 = queryUntil.plus(100, DAYS);
        List<Activity> periodMatches = List.of(
                createActivity(queryUser, EPOCH, queryFrom2, queryUntil2),
                createActivity(queryUser, EPOCH, queryFrom2.plus(1, DAYS), queryUntil2.minus(1, DAYS))
        );

        User nonMatchingUser = new User();
        nonMatchingUser.setKeycloakId(UUID.randomUUID());
        nonMatchingUser = userService.save(nonMatchingUser);

        List<Activity> userIdDoesNotMatch = List.of(
                createActivity(nonMatchingUser, ACTIVITY, queryFrom, queryUntil),
                createActivity(nonMatchingUser, DAILY, queryFrom, queryUntil),
                createActivity(nonMatchingUser, EPOCH, queryFrom2, queryUntil2)
        );

        activityService.saveAll(typeAndPeriodMatches);
        activityService.saveAll(typeMatches);
        activityService.saveAll(periodMatches);
        activityService.saveAll(userIdDoesNotMatch);

        TimePeriod queryPeriod = TimePeriod.of(queryFrom, queryUntil);
        TimePeriod queryPeriod2 = TimePeriod.of(queryFrom2, queryUntil2);

        Assertions.assertEquals(typeAndPeriodMatches, activityService.findByUserIdAndTypeAndTimePeriod(queryUser, ACTIVITY, queryPeriod));
        Assertions.assertEquals(typeMatches, activityService.findByUserIdAndTypeAndTimePeriod(queryUser, DAILY, null));
        Assertions.assertEquals(periodMatches, activityService.findByUserIdAndTypeAndTimePeriod(queryUser, null, queryPeriod2));
    }

    private Activity createActivity(User user, ActivityModel model, Instant startTime, Instant endTime) {
        Activity activity = new Activity();
        activity.setUser(user);
        activity.setActivityModel(model);
        activity.setActivityType(ActivityType.WALKING);
        activity.setStartTime(startTime);
        activity.setEndTime(endTime);
        return activity;
    }
}
