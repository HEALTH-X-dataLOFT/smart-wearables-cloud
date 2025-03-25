package com.medisanaspace.healthx.dataloft.smartwearables.domain.activity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.User;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.base.entity.AbstractEntity;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.files.ActivityFile;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProvider;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Represents an individual activity within a certain period captured by a smart wearable.
 * An activity may be a sports session manually recorded by the user but could also represent a user's common activities
 * captured by the device throughout the day.
 * <br />
 * Depending on the kind of activity the set of fields for which data were captured may differ. In particular, detailed sample
 * data will most probably only be recorded during sports sessions that are started manually by the user and are therefore
 * not available for normal daily activities.
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "healthx_swc_activities", uniqueConstraints = {
        @UniqueConstraint(name = "uq_acvts_ext_id_start_time", columnNames = {"external_id", "start_time"})})
public class Activity extends AbstractEntity {

    @Column(name = "external_id")
    private String externalId;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "id", columnDefinition = "BINARY(16)", foreignKey = @ForeignKey(name = "FK_activity_user_id"))
    private User user;

    @Enumerated(EnumType.STRING)
    ActivityModel activityModel;

    @CreationTimestamp
    private Instant createdOn;

    /**
     * The activity provider operating the device that recorded the data
     */
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activity_provider_id", referencedColumnName = "id")
    private ActivityProvider importedFrom;

    /**
     * The activity's FIT file
     */
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "fit_file_id", referencedColumnName = "id")
    private ActivityFile fitFile;

    /**
     * The activity's TCX file
     */
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "tcx_file_id", referencedColumnName = "id")
    private ActivityFile tcxFile;

    /**
     * The activity's GPX file
     */
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "gpx_file_id", referencedColumnName = "id")
    private ActivityFile gpxFile;

    /**
     * The UTC timestamp at which the activity started
     */
    @Column(name = "start_time")
    private Instant startTime;

    /**
     * The UTC timestamp at which the activity ended
     */
    private Instant endTime;

    /**
     * The total number of steps recorded during the activity
     */
    private int steps;

    /**
     * The total number of active kilocalories burned during the activity
     */
    private int kilocalories;

    /**
     * The total number of bmr kilocalories burned during the activity
     */
    private int bmrKilocalories;

    /**
     * The minimum heart rate during the activity in beats per minute
     */
    private int minHeartRate;

    /**
     * The maximum heart rate during the activity in beats per minute
     */
    private int maxHeartRate;

    /**
     * The avergae heart rate during the activity in beats per minute
     */
    private int avgHeartRage;

    /**
     * A set of {@link Sample} entities that provide detailed heart rate and location measurement data
     */
    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Sample> samples = new ArrayList<>();

    /**
     * The type of the activity
     */
    @Enumerated(EnumType.STRING)
    private ActivityType activityType;

    public UUID getUserId() {
        return user.getId();
    }

    public boolean hasSamples() {
        return this.samples != null && !this.samples.isEmpty();
    }

    public void resetSamples() {
        if (this.hasSamples()) {
            this.samples.clear();
        }
        this.samples = new ArrayList<>();
    }
}
