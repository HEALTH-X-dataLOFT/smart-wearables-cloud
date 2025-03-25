package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.garmin;

import com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.Activity;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.ActivityType;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.ActivityService;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProvider;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProviderAccountLinkService;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProviderRepository;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProviders;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import jakarta.persistence.EntityManager;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;

class GarminActivityImporterTest {

    @Test
    void updatesExistingEpochActivityOrCreatesNewOne() throws ActivityTypeNotSupportedException {
        ActivityService activityService = Mockito.mock(ActivityService.class);
        ActivityProviderRepository providerRepository = Mockito.mock(ActivityProviderRepository.class);
        ActivityProviderAccountLinkService accountLinkService = Mockito.mock(ActivityProviderAccountLinkService.class);

        GarminActivityImporter importer = new GarminActivityImporter(activityService, providerRepository, accountLinkService);
        ReflectionTestUtils.setField(importer, "entityManager", Mockito.mock(EntityManager.class));

        String existingSummaryId = UUID.randomUUID().toString();
        Instant existingSummaryStartInstant = Instant.parse("2024-02-05T12:00:00.00Z");
        long existingSummaryStartSecs = existingSummaryStartInstant.getEpochSecond();
        Activity existingActivity = new Activity() {{
            setId(UUID.randomUUID());
            setExternalId(existingSummaryId);
        }};
        ActivityProvider garmin = new ActivityProvider();

        doReturn(Optional.of(existingActivity)).when(activityService).findByExternalIdAndStartTime(existingSummaryId, existingSummaryStartInstant);
        doReturn(Optional.of(garmin)).when(providerRepository).findByProviderKey(ActivityProviders.GARMIN);
        doAnswer(answer -> answer.getArgument(0)).when(activityService).save(any());

        // A new Activity entity should be created for new Garmin data
        GarminClientEpoch newEpoch = new GarminClientEpoch();
        newEpoch.setActivityType(ActivityType.GENERIC.name());
        newEpoch.setSummaryId(UUID.randomUUID().toString());
        newEpoch.setStartTimeInSeconds(existingSummaryStartSecs + 1);

        Activity newActivity = importer.importActivity(newEpoch);
        Assertions.assertNull(newActivity.getId());
        Assertions.assertEquals(ActivityType.GENERIC, newActivity.getActivityType());

        // If a previous state of the epoch activity already has been imported it should be deleted and replaced with a new one
        GarminClientEpoch existingEpoch = new GarminClientEpoch();
        existingEpoch.setActivityType(ActivityType.GENERIC.name());
        existingEpoch.setSummaryId(existingSummaryId);
        existingEpoch.setStartTimeInSeconds(existingSummaryStartSecs);

        Activity replacingActivity = importer.importActivity(existingEpoch);
        Assertions.assertNull(replacingActivity.getId());
        Assertions.assertEquals(ActivityType.GENERIC, replacingActivity.getActivityType());
        Assertions.assertEquals(existingActivity.getExternalId(), replacingActivity.getExternalId());

    }
}
