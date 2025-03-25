package com.medisanaspace.healthx.dataloft.smartwearables.gateway.asset;

import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.User;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.base.entity.AbstractEntityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class AssetService extends AbstractEntityService<Asset, UUID, AssetRepository> {

    public AssetService(AssetRepository repository) {
        super(repository);
    }

    @Transactional
    public boolean assetExistsFor(User user, AssetTemplate template) {
        return repository.existsByUserAndTypeAndPeriodAndAttributes(user, template.getType(), template.getPeriod(), template.getAttributes());
    }
}
