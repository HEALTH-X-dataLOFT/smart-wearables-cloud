package com.medisanaspace.healthx.dataloft.smartwearables;

import com.medisanaspace.healthx.dataloft.smartwearables.common.TimePeriod;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.Activity;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.ActivityModel;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.ActivityService;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.User;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.UserService;
import com.medisanaspace.healthx.dataloft.smartwearables.gateway.asset.Asset;
import com.medisanaspace.healthx.dataloft.smartwearables.gateway.asset.AssetService;
import com.medisanaspace.healthx.dataloft.smartwearables.gateway.asset.AssetTemplate;
import com.medisanaspace.healthx.dataloft.smartwearables.gateway.transport.AssetCatalogClient;
import com.medisanaspace.healthx.dataloft.smartwearables.gateway.transport.CatalogEntryCreationFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AssetManagementService {

    public static final TimePeriod DEFAULT_TIMEPERIOD = TimePeriod.of(Period.of(0, 6, 0));
    private static final List<AssetTemplate> DEFAULT_ASSET_TEMPLATES = List.of(
            AssetTemplate.of("Tageswerte der letzten 6 Monate", ActivityModel.DAILY, DEFAULT_TIMEPERIOD, "Tageswerte der letzten 6 Monate"),
            AssetTemplate.of("Aktivitäten der letzten 6 Monate", ActivityModel.ACTIVITY, DEFAULT_TIMEPERIOD, "Aktivitäten der letzten 6 Monate"),
            AssetTemplate.of("Aktivitäten (detailiert) der letzten 6 Monate", ActivityModel.ACTIVITY_DETAIL, DEFAULT_TIMEPERIOD, "Aktivitäten (detailiert) der letzten 6 Monate"),
            AssetTemplate.of("Einzelwerte der letzten 6 Monate", ActivityModel.EPOCH, DEFAULT_TIMEPERIOD, "Einzelwerte der letzten 6 Monate")
    );

    @Value("${datatransfer.url.template:#{''}}")
    private String DATA_TRANSFER_BINARY_URL_TEMPLATE;

    private final ActivityService activityService;
    private final AssetService assetService;
    private final AssetCatalogClient catalogClient;
    private final UserService userService;

    @Autowired
    public AssetManagementService(ActivityService activityService, AssetService assetService, AssetCatalogClient catalogClient, UserService userService) {
        this.activityService = activityService;
        this.assetService = assetService;
        this.catalogClient = catalogClient;
        this.userService = userService;
    }

    @Transactional
    public List<Activity> findActivitiesForAsset(String assetId) {
        Optional<Asset> asset = assetService.findById(UUID.fromString(assetId));
        return asset
                .map(this::findActivitiesForAsset)
                .orElseThrow(() -> new EntityNotFoundException("Could not find asset with id " + assetId));
    }

    public List<Activity> findActivitiesForAsset(Asset asset) {
        return activityService.findByUserIdAndTypeAndTimePeriod(asset.getUser(), asset.getType(), asset.getPeriod());
    }

    @Transactional(rollbackFor = CatalogEntryCreationFailedException.class)
    public List<Asset> createDefaultAssetsForUser(String userId) throws CatalogEntryCreationFailedException {
        return createAssetsForUser(userId, DEFAULT_ASSET_TEMPLATES);
    }

    @Transactional(rollbackFor = CatalogEntryCreationFailedException.class)
    public List<Asset> createAssetsForUser(String userId, List<AssetTemplate> templates) throws CatalogEntryCreationFailedException {
        List<Asset> assets = new ArrayList<>();
        User user = userService.findByKeycloakId(UUID.fromString(userId));
        for (AssetTemplate template : templates) {
            if (dataExistsFor(user, template) && !assetService.assetExistsFor(user, template)) {
                assets.add(constructAssetFrom(user, template));
            }
        }
        assets = assetService.saveAll(assets);
        assets.forEach(asset -> asset.setDataUrl(String.format(DATA_TRANSFER_BINARY_URL_TEMPLATE, asset.getId())));
        catalogClient.createCatalogEntriesFor(assets);
        return assets;
    }

    private boolean dataExistsFor(User user, AssetTemplate template) {
        return activityService.existsByUserIdAndTypeAndTimePeriod(user, template.getType(), template.getPeriod());
    }

    private Asset constructAssetFrom(User user, AssetTemplate template) {
        return Asset.builder()
                .name(template.getName())
                .user(user)
                .description(template.getDescription())
                .type(template.getType())
                .period(template.getPeriod())
                .attributes(template.getAttributes())
                .build();
    }
}
