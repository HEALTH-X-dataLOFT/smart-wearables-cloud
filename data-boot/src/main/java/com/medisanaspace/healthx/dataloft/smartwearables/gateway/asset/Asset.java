package com.medisanaspace.healthx.dataloft.smartwearables.gateway.asset;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medisanaspace.healthx.dataloft.smartwearables.common.StringListConverter;
import com.medisanaspace.healthx.dataloft.smartwearables.common.TimePeriod;
import com.medisanaspace.healthx.dataloft.smartwearables.common.TimeperiodConverter;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.ActivityModel;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.User;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.base.entity.AbstractEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "healthx_swc_assets", uniqueConstraints = {
        @UniqueConstraint(name = "uq_assets_name_user", columnNames = {"name", "userid"}),
        @UniqueConstraint(name = "uq_assets_user_filter", columnNames = {"userid", "type", "attributes", "period"})}
)
public class Asset extends AbstractEntity {

    @Column(nullable = false)
    String name;

    @Column(unique = true)
    String catalogueAssetId;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "id", nullable = false, columnDefinition = "BINARY(16)", foreignKey = @ForeignKey(name = "FK_asset_user_id"))
    User user;

    @CreationTimestamp
    @Column(updatable = false)
    Instant created;

    @Enumerated(EnumType.STRING)
    ActivityModel type;

    @Convert(converter = StringListConverter.class)
    List<String> attributes;

    @Convert(converter = TimeperiodConverter.class)
    TimePeriod period;

    @Column
    String description;

    @JsonIgnore
    @Transient
    String dataUrl;

    public UUID getUserId() {
        return user.getId();
    }
}
