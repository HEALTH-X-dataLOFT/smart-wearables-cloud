package com.medisanaspace.healthx.dataloft.smartwearables.gateway.asset;

import com.medisanaspace.healthx.dataloft.smartwearables.common.TimePeriod;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.ActivityModel;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.base.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class AssetTemplate extends AbstractEntity {
    String name;
    ActivityModel type;
    List<String> attributes;
    TimePeriod period;
    String description;

    public static AssetTemplate of(String name, ActivityModel type, TimePeriod period, String description) {
        AssetTemplate template = new AssetTemplate();
        template.setName(name);
        template.setType(type);
        template.setPeriod(period);
        template.setDescription(description);
        return template;
    }
}