package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.garmin;

import com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.Activity;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProviderAccountLinkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/garmin-api")
@Slf4j
public class GarminApiWebHookController {

    public static final String EPOCHS = "epochs";
    public static final String DAILIES = "dailies";
    public static final String ACTIVITY_DETAILS = "activityDetails";
    public static final String ACTIVITIES = "activities";
    public static final String DEREGISTRATIONS = "deregistrations";

    private final GarminActivityImportService activityImportService;
    private final ActivityProviderAccountLinkService accountLinkService;

    @Autowired
    public GarminApiWebHookController(GarminActivityImportService activityImportService, ActivityProviderAccountLinkService accountLinkService) {
        this.activityImportService = activityImportService;
        this.accountLinkService = accountLinkService;
    }

    @Transactional
    @PostMapping(path = "/ping")
    public String handlePingNotification(@RequestHeader Map<String, String> headers) {
        logHeaders(headers);
        return "Hello World!\n";
    }

    @Transactional
    @PostMapping(path = "/push/activities")
    public List<Activity> handleNewActivities(@RequestBody Map<String, List<GarminClientActivity>> notification, @RequestHeader Map<String, String> headers) throws ActivityTypeNotSupportedException {
        log.info("Received new push notification from Garmin: activities");
        logHeaders(headers);
        return activityImportService.importActivities(notification.get(ACTIVITIES));
    }

    @Transactional
    @PostMapping(path = "/push/activity-details")
    public List<Activity> handleNewActivityDetails(@RequestBody Map<String, List<GarminClientActivityDetail>> notification, @RequestHeader Map<String, String> headers) throws ActivityTypeNotSupportedException {
        log.info("Received new push notification from Garmin: activity-details");
        logHeaders(headers);
        return activityImportService.importActivities(notification.get(ACTIVITY_DETAILS));
    }

    @Transactional
    @PostMapping(path = "/push/dailies")
    public List<Activity> handleNewDailies(@RequestBody Map<String, List<GarminClientDaily>> notification, @RequestHeader Map<String, String> headers) throws ActivityTypeNotSupportedException {
        log.info("Received new push notification from Garmin: dailies");
        logHeaders(headers);
        return activityImportService.importActivities(notification.get(DAILIES));
    }

    @Transactional
    @PostMapping(path = "/push/epochs")
    public List<Activity> handleNewEpochs(@RequestBody Map<String, List<GarminClientEpoch>> notification, @RequestHeader Map<String, String> headers) throws ActivityTypeNotSupportedException {
        log.info("Received new push notification from Garmin: epochs");
        logHeaders(headers);
        return activityImportService.importActivities(notification.get(EPOCHS));
    }

    @Transactional
    @PostMapping(path = "/deregistration")
    public void deregisterUser(@RequestBody Map<String, List<GarminDeregistration>> notification, @RequestHeader Map<String, String> headers) {
        log.info("Received deregistration notification from Garmin");
        logHeaders(headers);
        List<GarminDeregistration> deregistrations = notification.get(DEREGISTRATIONS);
        deregistrations.stream()
                .map(GarminDeregistration::getUserAccessToken)
                .forEach(accountLinkService::deregisterUserWithToken);
    }

    void logHeaders(Map<String, String> headers) {
        headers.forEach((key, value) -> log.info(String.format("'%s': %s", key, value)));
    }
}