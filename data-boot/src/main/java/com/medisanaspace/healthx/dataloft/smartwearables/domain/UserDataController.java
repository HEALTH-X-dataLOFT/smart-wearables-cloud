package com.medisanaspace.healthx.dataloft.smartwearables.domain;

import com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.Activity;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.User;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.UserService;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.epochs.EpochValue;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.epochs.PhenomenonType;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.helper.UserIdHelper;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProviderAccountLinkService;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProviders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.security.RolesAllowed;
import java.io.Serializable;
import java.security.Principal;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user-data")
@Slf4j
public class UserDataController<T extends Number> {

    private static final String DD_MM_UUUU = "dd.MM.uuuu";
    private static final String HH_MM_SS = "HH:mm:ss";
    private static final String DD_MM_UU_HH_MM_SS = "dd.MM.uu HH:mm:ss";
    private static final ZoneId APP_TIMEZONE = ZoneId.of("Europe/Berlin");

    private final UserDataService<T> userDataService;
    private final ActivityProviderAccountLinkService accountLinkService;
    private final UserService userService;
    private final UserDataAggregator<T> aggregator;

    @Autowired
    public UserDataController(UserDataService<T> userDataService, ActivityProviderAccountLinkService accountLinkService, UserService userService, UserDataAggregator<T> aggregator) {
        this.userDataService = userDataService;
        this.accountLinkService = accountLinkService;
        this.userService = userService;
        this.aggregator = aggregator;
    }

    @Transactional
    @GetMapping(path = "/summary")
    @RolesAllowed("swc-user")
    public String[][] createDataSummary(Principal userPrincipal, @RequestParam(name = "from", required = false) Instant from, @RequestParam(name = "provider", required = false, defaultValue = "GARMIN") ActivityProviders provider, @RequestParam(name="resolution", required = false, defaultValue = "HOURS") ChronoUnit resolution) {
        log.info("Creating data summary for user {}", userPrincipal.getName());
        UUID userUUID = UserIdHelper.parseUserIdFromPrincipal(userPrincipal);
        String providerName = provider.name().toLowerCase();
        List<EpochValue<T>> userActivities = userDataService.findEpochValuesForUserAfter(userUUID, from, providerName).stream().toList();
        List<EpochValue<Double>> aggregatedValues = aggregator.aggregateValues(userActivities, resolution);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DD_MM_UUUU).withZone(APP_TIMEZONE);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(HH_MM_SS).withZone(APP_TIMEZONE);
        DateTimeFormatter timestampFormatter = DateTimeFormatter.ofPattern(DD_MM_UU_HH_MM_SS).withZone(APP_TIMEZONE);

        List<String[]> summary = new ArrayList<>();
        for (int i = 0; i < aggregatedValues.size(); i++) {
            EpochValue<Double> epochValue = aggregatedValues.get(i);
            String[] columnValues = createValueArray(i + 1, dateFormatter, epochValue, timeFormatter, timestampFormatter);
            summary.add(columnValues);
        }

        log.info("Returning data summary for user {}", userPrincipal.getName());
        return summary.toArray(new String[][]{});
    }

    @DeleteMapping("/data")
    @RolesAllowed("swc-user")
    public void clearUserData(Principal userPrincipal) {
        UUID userUUID = UserIdHelper.parseUserIdFromPrincipal(userPrincipal);
        User user = userService.findByKeycloakId(userUUID);
        userDataService.removeActivitiesForUser(user);
    }

    @Transactional
    @DeleteMapping("/account")
    @RolesAllowed("swc-user")
    public void deleteUserAccount(Principal userPrincipal) {
        UUID userUUID = UserIdHelper.parseUserIdFromPrincipal(userPrincipal);
        User user = userService.findByKeycloakId(userUUID);

        userDataService.removeActivitiesForUser(user);
        log.info("Removed activities for user {}...", userUUID);

        accountLinkService.removeAllAccountLinksFor(user);
        log.info("Removed account links for user {}...", userUUID);

        userService.deleteUser(user);
        log.info("Removed keycloak user {}...", userUUID);

        log.info("Completed account removal for user {} successfully", userUUID);
    }

    private <V extends Serializable> String[] createValueArray(int index, DateTimeFormatter dateFormatter, EpochValue<V> epochValue, DateTimeFormatter timeFormatter, DateTimeFormatter timestampFormatter) {
        String date = epochValue.getStart() != null ? dateFormatter.format(epochValue.getStart()) : null;
        String start = epochValue.getStart() != null ? timeFormatter.format(epochValue.getStart()) : null;
        String end = epochValue.getEnd() != null ? timeFormatter.format(epochValue.getEnd()) : null;
        String imported = epochValue.getCreatedAt() != null ? timestampFormatter.format(epochValue.getCreatedAt()) : null;
        String modelType = epochValue instanceof Activity activity ? activity.getActivityModel().name() : "EPOCH";
        String kilocalories = epochValue.getPhenomenonType().equals(PhenomenonType.KILOCALORIES) || epochValue.getPhenomenonType().equals(PhenomenonType.ActiveBurnedCalories) ? "" + epochValue.getValue() : null;
        String steps = epochValue.getPhenomenonType().equals(PhenomenonType.STEPS) || epochValue.getPhenomenonType().equals(PhenomenonType.Steps) ? "" + epochValue.getValue() : null;
        String heartRate = epochValue.getPhenomenonType().equals(PhenomenonType.HEART_RATE) || epochValue.getPhenomenonType().equals(PhenomenonType.HeartRate) ? "" + epochValue.getValue() : null;
        ActivityProviders providerKey = epochValue.getProvider() != null ? ActivityProviders.valueOf(epochValue.getProvider()) : null;
        return new String[]{
                "" + index,
                imported,
                date,
                start,
                end,
                "" + providerKey,
                modelType,
                "" + epochValue.getPhenomenonType(),
                kilocalories,
                steps,
                heartRate
        };
    }

}
