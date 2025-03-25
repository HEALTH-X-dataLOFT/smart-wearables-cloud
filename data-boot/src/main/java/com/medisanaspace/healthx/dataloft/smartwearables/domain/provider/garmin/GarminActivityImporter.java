package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.garmin;

import com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.Activity;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.ActivityModel;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.ActivityType;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.Sample;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.ActivityService;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.User;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProvider;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProviderAccountLinkService;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProviderRepository;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProviders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.ActivityModel.DAILY;
import static com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.ActivityModel.EPOCH;

@Component
@Slf4j
public class GarminActivityImporter {

    private final ActivityService activityService;
    private final ActivityProviderRepository providerRepository;
    private final ActivityProviderAccountLinkService accountLinkService;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public GarminActivityImporter(ActivityService activityService,
                                  ActivityProviderRepository providerRepository,
                                  ActivityProviderAccountLinkService accountLinkService) {
        this.activityService = activityService;
        this.providerRepository = providerRepository;
        this.accountLinkService = accountLinkService;
    }

    @Transactional
    public <T extends GarminPayload> Activity importActivity(T garminActivity) throws ActivityTypeNotSupportedException {
        Class<?> clazz = garminActivity.getClass();
        Activity activity = null;

        if (GarminClientActivity.class.equals(clazz)) {
            activity = importActivity((GarminClientActivity) garminActivity);
        }

        if (GarminClientActivityDetail.class.equals(clazz)) {
            activity = importActivity((GarminClientActivityDetail) garminActivity);
        }

        if (GarminClientDaily.class.equals(clazz)) {
            activity = createOrReplaceActivity((GarminClientDaily) garminActivity, DAILY);
        }

        if (GarminClientEpoch.class.equals(clazz)) {
            activity = createOrReplaceActivity((GarminClientEpoch) garminActivity, EPOCH);
        }

        if (activity == null) {
            throw new ActivityTypeNotSupportedException("Activity type not supported: " + clazz);
        }

        User user = accountLinkService.getUserForToken(garminActivity.getUserAccessToken());
        activity.setUser(user);

        Optional<ActivityProvider> garmin = providerRepository.findByProviderKey(ActivityProviders.GARMIN);
        garmin.ifPresent(activity::setImportedFrom);

        log.info("Persisting activity with id: {}, external_id: {} and start_timestamp: {}", activity.getId(), activity.getExternalId(), activity.getStartTime());
        return activityService.save(activity);
    }

    /*
     * If an activity already exists, update its fields. Otherwise, create a new one.
     */
    private Activity createOrReplaceActivity(AbstractGarminBaseSummaryDetails garminData, ActivityModel model) {
        Instant startTime = Instant.ofEpochSecond(garminData.getStartTimeInSeconds());

        // Delete existing activity and flush changes immediately since JPA otherwise executes INSERTs before DELETEs on commit
        long deletionCount = activityService.deleteByExternalIdAndStartTime(garminData.getSummaryId(), startTime);
        entityManager.flush();
        log.info("Deleted {} activity record(s) for external ID {} and start timestamp {}", deletionCount, garminData.getSummaryId(), startTime);

        Activity activity = new Activity();
        activity.setActivityModel(model);
        return setActivityFieldValues(activity, garminData);
    }

    /*
     * If an activity already exists, update its fields and heart rate samples. Otherwise, create a new one.
     */
    private Activity createOrReplaceActivity(GarminClientDaily garminData, ActivityModel model) {
        Activity activity = createOrReplaceActivity((AbstractGarminBaseSummaryDetails) garminData, model);
        garminData.getTimeOffsetHeartRateSamples().forEach((offset, heartRate) -> {
            var timestamp = garminData.getStartTimeInSeconds() + Long.parseLong(offset);
            var sample = new Sample();
            sample.setActivity(activity);
            sample.setTimestamp(Instant.ofEpochSecond(timestamp));
            sample.setHeartRate(heartRate);
            activity.getSamples().add(sample);
        });
        return activity;
    }

    static Activity importActivity(GarminClientActivity garminClientActivity) {
        Activity activity = new Activity();
        Instant startTime = Instant.ofEpochSecond(garminClientActivity.getStartTimeInSeconds());
        Instant endTime = startTime.plus(garminClientActivity.getDurationInSeconds(), ChronoUnit.SECONDS);

        activity.setActivityModel(ActivityModel.ACTIVITY);
        activity.setExternalId(garminClientActivity.getSummaryId());
        activity.setStartTime(startTime);
        activity.setEndTime(endTime);
        activity.setKilocalories(garminClientActivity.getActiveKilocalories());
        activity.setSteps(garminClientActivity.getSteps());
        activity.setAvgHeartRage(garminClientActivity.getAverageHeartRateInBeatsPerMinute());
        activity.setMaxHeartRate(garminClientActivity.getMaxHeartRateInBeatsPerMinute());
        activity.setActivityType(activityTypeOf(garminClientActivity));

        activity.setFitFile(null);
        activity.setGpxFile(null);
        activity.setTcxFile(null);

        return activity;
    }

    static Activity importActivity(GarminClientActivityDetail garminClientActivityDetail) {
        Activity activity = importActivity(garminClientActivityDetail.getSummary());
        activity.setActivityModel(ActivityModel.ACTIVITY_DETAIL);
        List<Sample> samples = parseSamples(activity, garminClientActivityDetail.getSamples());
        activity.setSamples(samples);
        return activity;
    }

    private static List<Sample> parseSamples(Activity activity, List<GarminSample> garminSamples) {
        List<Sample> samples = new LinkedList<>();
        for (GarminSample garminSample : garminSamples) {
            Sample sample = new Sample();
            sample.setActivity(activity);
            sample.setElevation(garminSample.getElevationInMeters());
            sample.setLatitude(garminSample.getLatitudeInDegree());
            sample.setLongitude(garminSample.getLongitudeInDegree());
            sample.setTimestamp(Instant.ofEpochSecond(garminSample.getStartTimeInSeconds()));
            sample.setHeartRate(garminSample.getHeartRate());
            samples.add(sample);
        }
        return samples;
    }

    static Activity setActivityFieldValues(Activity activity, AbstractGarminBaseSummaryDetails garminData) {
        Instant startTime = Instant.ofEpochSecond(garminData.getStartTimeInSeconds());
        Instant endTime = startTime.plus(garminData.getDurationInSeconds(), ChronoUnit.SECONDS);

        activity.setStartTime(startTime);
        activity.setEndTime(endTime);

        activity.setExternalId(garminData.getSummaryId());
        activity.setKilocalories(garminData.getActiveKilocalories());
        activity.setSteps(garminData.getSteps());
        activity.setActivityType(activityTypeOf(garminData));

        activity.setFitFile(null);
        activity.setGpxFile(null);
        activity.setTcxFile(null);

        return activity;
    }

    static ActivityType activityTypeOf(AbstractGarminBaseSummaryDetails garminClientEpoch) {
        String garminActivityType = garminClientEpoch.getActivityType().toUpperCase();
        return ActivityType.valueOf(garminActivityType);
    }
}
