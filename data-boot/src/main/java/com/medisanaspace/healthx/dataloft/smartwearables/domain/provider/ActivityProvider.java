package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.base.entity.AbstractEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

/**
 * An activity provider i.e. the manufacturer of a smart wearable device which is used to collect activity data
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "healthx_swc_activity_providers")
public class ActivityProvider extends AbstractEntity {

    /**
     * A company logo which may be displayed to the user in the UI
     */
    @JsonIgnore
    public byte[] logo;

    boolean persistAccessToken;

    /**
     * A unique provider-specific key which identifies the provider within the Smart Wearables Cloud
     */
    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private ActivityProviders providerKey;

    /**
     * A List of associated {@link ActivityProviderAccountLink} entities
     */
    @JsonIgnore
    @OneToMany(mappedBy = "provider")
    private List<ActivityProviderAccountLink> accountLink;

}
