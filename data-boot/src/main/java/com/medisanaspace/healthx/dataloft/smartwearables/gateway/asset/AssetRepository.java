package com.medisanaspace.healthx.dataloft.smartwearables.gateway.asset;

import com.medisanaspace.healthx.dataloft.smartwearables.common.TimePeriod;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.ActivityModel;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AssetRepository extends JpaRepository<Asset, UUID> {

    boolean existsByUserAndTypeAndPeriodAndAttributes(User user, ActivityModel type, TimePeriod period, List<String> attributes);

}
