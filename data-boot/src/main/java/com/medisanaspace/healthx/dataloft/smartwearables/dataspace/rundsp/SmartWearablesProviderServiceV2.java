package com.medisanaspace.healthx.dataloft.smartwearables.dataspace.rundsp;

import com.dsp.v1alpha2.*;
import com.google.protobuf.Timestamp;
import com.medisanaspace.healthx.dataloft.smartwearables.auth.SwcAuthToken;
import com.medisanaspace.healthx.dataloft.smartwearables.dataspace.publication.Publication;
import com.medisanaspace.healthx.dataloft.smartwearables.dataspace.publication.PublicationService;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.UserDataService;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.Activity;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.ActivityService;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.security.RolesAllowed;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@GrpcService
@Slf4j
public class SmartWearablesProviderServiceV2 extends ProviderServiceGrpc.ProviderServiceImplBase {

    private static final ZoneId APP_TIMEZONE = ZoneId.of("Europe/Berlin");
    private static final String JSON = "JSON";
    private static final String GET = "GET";
    private static final String PERSONAL = "Personal";
    private static final String APPLICATION_JSON = "application/json";
    private static final String KEYWORD_SWC = "SWC";
    private static final String KEYWORD_ACTIVITY_DATA = "Activity Data";
    private static final String KEYWORD_GARMIN = "Garmin";
    private static final String PROVIDER_DESCRIPTION = "Smart Wearables Cloud Description";
    private static final String SMART_WEARABLES_CLOUD = "Smart Wearables Cloud";
    private static final String DATASERVICE_URL = "smartwearables.health-x.org/data/health-x/asset_data/";

    private final UserDataService userDataService;
    private final ActivityService activityService;
    private final PublicationService publicationService;

    public SmartWearablesProviderServiceV2(UserDataService userDataService, ActivityService activityService, PublicationService publicationService) {
        this.userDataService = userDataService;
        this.activityService = activityService;
        this.publicationService = publicationService;
    }

    @Override
    public void ping(PingRequest request, StreamObserver<PingResponse> responseObserver) {
        log.info("Received gRPC call -> ping");
        var fields = request.getAllFields();
        fields.forEach((desc, val) -> log.info("{}: {}", desc.getName(), val));
        var response = PingResponse.newBuilder()
                .setDataserviceId("" + UUID.randomUUID())
                .setProviderDescription(PROVIDER_DESCRIPTION)
                .setProviderName(SMART_WEARABLES_CLOUD)
                .setDataserviceUrl(DATASERVICE_URL)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Transactional
    @RolesAllowed("swc-user")
    @Override
    public void getCatalogue(GetCatalogueRequest request, StreamObserver<GetCatalogueResponse> responseObserver) {
        log.info("Received gRPC call -> getCatalogue");
        var userId = getCurrentUserId();
        var userActivities = userDataService.findActivitiesForUser(userId);
        var datasets = createDatasetsFrom(userActivities);
        var response = GetCatalogueResponse.newBuilder()
                .addAllDatasets(datasets)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Transactional
    @Override
    public void getDataset(GetDatasetRequest request, StreamObserver<GetDatasetResponse> responseObserver) {
        log.info("Received gRPC call -> getDataset");
        var datasetId = request.getDatasetId();
        var activity = activityService.findById(UUID.fromString(datasetId)).orElseThrow();
        var dataset = createDatasetFrom(activity);
        var response = GetDatasetResponse.newBuilder()
                .setDataset(dataset)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void publishDataset(PublishDatasetRequest request, StreamObserver<PublishDatasetResponse> responseObserver) {
        log.info("Received gRPC call -> publishDataset");

        var userId = getCurrentUserId();
        final UUID activityId  = UUID.fromString(request.getDatasetId());
        final UUID publicationId = UUID.fromString(request.getPublishId());

        if(publicationService.publicationExistsFor(publicationId, userId)) {
            responseObserver.onError(new StatusException(Status.ALREADY_EXISTS));
            return;
        }

        var activity = activityService.findById(activityId).orElseThrow();

        if (!userId.toString().equals("" + activity.getUserId())) {
            throw new IllegalArgumentException("Cannot publish activity data of another user");
        }

        var publication = publicationService.publish(publicationId, userId, activity);
        var publishInfo = createPublishInfoFor(publication);

        var response = PublishDatasetResponse.newBuilder()
                .setPublishInfo(publishInfo)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void unpublishDataset(UnpublishDatasetRequest request, StreamObserver<UnpublishDatasetResponse> responseObserver) {
        log.info("Received gRPC call -> unpublishDataset");
        var userId = getCurrentUserId();
        var publicationId = UUID.fromString(request.getPublishId());

        if (!publicationService.publicationExistsFor(publicationId, userId)) {
            responseObserver.onError(new StatusException(Status.NOT_FOUND));
            return;
        }

        publicationService.unpublish(publicationId, userId);

        var response = UnpublishDatasetResponse.newBuilder()
                .setSuccess(true)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void suspendPublishedDataset(SuspendPublishedDatasetRequest request, StreamObserver<SuspendPublishedDatasetResponse> responseObserver) {
        log.info("Received gRPC call -> suspendPublishedDataset");
        var userId = getCurrentUserId();
        var publicationId = UUID.fromString(request.getPublishId());

        if (!publicationService.publicationExistsFor(publicationId, userId)) {
            responseObserver.onError(new StatusException(Status.NOT_FOUND));
            return;
        }

        publicationService.suspend(publicationId, userId);

        var response = SuspendPublishedDatasetResponse.newBuilder()
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void unsuspendPublishedDataset(UnsuspendPublishedDatasetRequest request, StreamObserver<UnsuspendPublishedDatasetResponse> responseObserver) {
        log.info("Received gRPC call -> unsuspendPublishedDataset");
        var userId = getCurrentUserId();
        var publicationId = UUID.fromString(request.getPublishId());

        if (!publicationService.publicationExistsFor(publicationId, userId)) {
            responseObserver.onError(new StatusException(Status.NOT_FOUND));
            return;
        }

        publicationService.unsuspend(publicationId, userId);

        var response = UnsuspendPublishedDatasetResponse.newBuilder()
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private static List<Dataset> createDatasetsFrom(List<Activity> activitiesForUser) {
        var datasets = new ArrayList<Dataset>();
        for (var activity : activitiesForUser) {
            var dataset = createDatasetFrom(activity);
            datasets.add(dataset);
        }
        return datasets;
    }

    private static Dataset createDatasetFrom(Activity activity) {
        var formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
        var zonedStart = ZonedDateTime.ofInstant(activity.getStartTime(), APP_TIMEZONE);
        var zonedEnd = ZonedDateTime.ofInstant(activity.getEndTime(), APP_TIMEZONE);
        var formattedStart = formatter.format(zonedStart);
        var formattedEnd = formatter.format(zonedEnd);
        var activityType = activity.getActivityType().name();
        var title = "%s - %s %s".formatted(formattedStart, formattedEnd, activityType);
        return createDataset(activity, title, activityType);
    }

    private static Dataset createDataset(Activity activity, String title, String name) {
        var epochSecond = Instant.now().getEpochSecond();

        var now = Timestamp
                .newBuilder()
                .setSeconds(epochSecond);

        var description = Multilingual.newBuilder()
                .setLanguage("DE")
                .setValue(name)
                .build();

        return Dataset.newBuilder()
                .setTitle(title)
                .setFormat(JSON)
                .setId(activity.getId().toString())
                .setAccessMethods(GET)
                .setLicense(PERSONAL)
                .setMediaType(APPLICATION_JSON)
                .setIssued(now)
                .addDescription(description)
                .addKeywords(KEYWORD_SWC)
                .addKeywords(KEYWORD_ACTIVITY_DATA)
                .addKeywords(KEYWORD_GARMIN)
                .addKeywords(activity.getActivityModel().name())
                .addKeywords(name)
                .build();
    }

    private static PublishInfo createPublishInfoFor(Publication publication) {
        com.dsp.v1alpha1.AuthenticationType authenticationTypeV1 = publication.getAuthenticationType();
        AuthenticationType authenticationType = AuthenticationType.forNumber(authenticationTypeV1.getNumber());
        return PublishInfo.newBuilder()
                .setAuthenticationType(authenticationType)
                .setUsername(publication.getUsername())
                .setPassword(publication.getPassword())
                .setUrl(publication.getUrl())
                .build();
    }

    private static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    private static UUID getCurrentUserId() {
        return ((SwcAuthToken) getAuthentication()).getId();
    }
}
