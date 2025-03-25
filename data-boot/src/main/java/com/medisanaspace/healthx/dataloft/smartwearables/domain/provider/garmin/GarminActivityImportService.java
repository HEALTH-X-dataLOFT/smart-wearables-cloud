package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.garmin;

import com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.Activity;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class GarminActivityImportService {

    private final ActivityRepository activityRepository;
    private final GarminActivityImporter activityImporter;

    @Autowired
    public GarminActivityImportService(ActivityRepository activityRepository, GarminActivityImporter activityImporter) {
        this.activityRepository = activityRepository;
        this.activityImporter = activityImporter;
    }

    @Transactional
    public <T extends GarminPayload> List<Activity> importActivities(List<T> activityList) throws ActivityTypeNotSupportedException {
        List<Activity> activities = doImport(activityList);
        return activityRepository.saveAll(activities);
    }

    <T extends GarminPayload> List<Activity> doImport(List<T> activityList) throws ActivityTypeNotSupportedException {
        List<Activity> activities = new LinkedList<>();
        for (T entry : activityList) {
            Activity activity = doImport(entry);
            activities.add(activity);
        }
        return activities;
    }

    private <T extends GarminPayload> Activity doImport(T summary) throws ActivityTypeNotSupportedException {
        return activityImporter.importActivity(summary);
    }

}
