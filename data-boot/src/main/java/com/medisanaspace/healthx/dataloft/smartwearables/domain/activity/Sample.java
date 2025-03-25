package com.medisanaspace.healthx.dataloft.smartwearables.domain.activity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.base.entity.AbstractEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import java.time.Instant;

/**
 * Represents an individual measurement sample captured by a smart wearable device
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Table(name = "healthx_swc_activity_samples", uniqueConstraints = {
        @UniqueConstraint(name = "uq_act_smpls_act_id_start_time", columnNames = {"activity_id", "timestamp"})
}, indexes = @Index(columnList = "activity_id"))
public class Sample extends AbstractEntity {

    @CreationTimestamp
    private Instant createdOn;

    /**
     * The sample's UTC timestamp
     */
    private Instant timestamp;

    /**
     * The sample's geographical longitude in degrees (WGS84)
     */
    private double longitude;

    /**
     * The sample's geographical latitude in degrees (WGS84)
     */
    private double latitude;

    /**
     * The sample's elevation in meters above mean sea level (WGS84)
     */
    private double elevation;

    /**
     * The heart rate that was determined during the measurement period
     */
    private int heartRate;

    /**
     * The associated activity to which this sample refers (i.e. as part of which the sample was recorded)
     */
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "activity_id", referencedColumnName = "id", nullable = false)
    private Activity activity;

    public Sample(Instant timestamp, double longitude, double latitude, double elevation, int heartRate, Activity activity) {
        this.timestamp = timestamp;
        this.longitude = longitude;
        this.latitude = latitude;
        this.elevation = elevation;
        this.heartRate = heartRate;
        this.activity = activity;
    }
}
