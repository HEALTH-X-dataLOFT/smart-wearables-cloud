package com.medisanaspace.healthx.dataloft.smartwearables.gateway;

import com.medisanaspace.healthx.dataloft.smartwearables.AssetManagementService;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.Activity;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.ActivityService;
import com.medisanaspace.healthx.dataloft.smartwearables.gateway.asset.Asset;
import com.medisanaspace.healthx.dataloft.smartwearables.gateway.transport.CatalogEntryCreationFailedException;
import com.medisanaspace.healthx.dataloft.smartwearables.gateway.transport.GatewayServiceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Legacy controller for former integration of EDC which was dropped in favor of RUN-DSP.
 * Only kept for reference for possible future EDC integration attempts.
 */
@RequestMapping("health-x")
@RestController
@Slf4j
public class GatewayController {

    private static final String USER_ID = "User-Id";
    private final AssetManagementService assetManagementService;
    private final ActivityService activityService;

    @Autowired
    public GatewayController(AssetManagementService assetManagementService, ActivityService activityService) {
        this.assetManagementService = assetManagementService;
        this.activityService = activityService;
    }

    @PostMapping(value = "/gateway_lookup", produces = {"application/json; charset=UTF-8"})
    public GatewayServiceResponse gatewayLookup(@RequestHeader(USER_ID) final String userId) throws CatalogEntryCreationFailedException {
        log.info("/gateway_lookup called. Looking up assets: Heart Rate, Blood Pressure, Steps, Calories, Sleep, Body Composition, Pulse-Ox");

        List<Asset> assets = assetManagementService.createDefaultAssetsForUser(userId);

        log.info("{} assets were created", assets.size());
        return createGatewayServiceResponseFrom(assets);
    }

    @GetMapping(value = "/asset_data/{assetId}")
    @Transactional
    public Activity assetData(@PathVariable String assetId) {
        UUID id = UUID.fromString(assetId);
        return activityService.findByIdWithSamples(id).orElse(null);
    }

    /**
     * Creates a response object containing information about the created connector catalog asset entries
     */
    private static GatewayServiceResponse createGatewayServiceResponseFrom(List<Asset> assets) {
        List<String> assetIds = new ArrayList<>();
        List<String> dataTypes = new ArrayList<>();

        for (Asset asset : assets) {
            assetIds.add(asset.getCatalogueAssetId());
            dataTypes.add(asset.getType().name());
        }
        return GatewayServiceResponse.of(!assetIds.isEmpty(), dataTypes, assetIds);
    }

}
