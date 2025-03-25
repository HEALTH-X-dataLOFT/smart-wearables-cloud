package com.medisanaspace.healthx.dataloft.smartwearables.dataspace.publication;

import com.dsp.v1alpha1.AuthenticationType;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.Activity;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.base.entity.AbstractEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "healthx_swc_publications")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Publication extends AbstractEntity {

    @Column(columnDefinition = "BINARY(16)", unique = true, nullable = false)
    private UUID publicationId;

    @ManyToOne
    @JoinColumn(name = "activity_id", referencedColumnName = "id")
    private Activity activity;

    @Column(columnDefinition = "BINARY(16)")
    private UUID userId;

    @CreationTimestamp
    private Instant createdOn;

    /**
     * Username required for retrieving the publication's data
     */
    private String username;

    /**
     * Password required for retrieving the publication's data
     */
    private String password;

    private String url;

    @Enumerated(EnumType.STRING)
    private AuthenticationType authenticationType;

    boolean suspended = false;

    public static Publication of(UUID publicationId, UUID userId, Activity activity, String url, String username, String encryptedPassword) {
        Publication publication = new Publication();
        publication.setPublicationId(publicationId);
        publication.setUserId(userId);
        publication.setActivity(activity);
        publication.setUsername(username);
        publication.setPassword(encryptedPassword);
        publication.setUrl(url);
        publication.setAuthenticationType(AuthenticationType.AUTHENTICATION_TYPE_BEARER);
        return publication;
    }
}
