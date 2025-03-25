package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider;

import com.medisanaspace.healthx.dataloft.smartwearables.crypto.AESConverter;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.User;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.base.entity.AbstractEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

/**
 * Represents the link between the Smart Wearables Cloud account and an account of an external activity provider.
 * <br />
 * This class is used to store auth tokens for activity provider accounts and assign them to the local Smart Wearables Cloud
 * user account so that activity data can be gathered from the provider's API and assigned to a Smart Wearables Cloud user.
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "healthx_swc_activity_provider_account_links", uniqueConstraints = @UniqueConstraint(name = "uq_acc_link_user_provider", columnNames = {"userid", "activity_provider_id"}))
public class ActivityProviderAccountLink extends AbstractEntity {

    /**
     * The associated {@link ActivityProvider}
     */
    @ManyToOne
    @JoinColumn(name = "activity_provider_id")
    private ActivityProvider provider;
    // There is no user entity in vitadock-data yet

    /**
     * The associated Smart Wearables Cloud user
     */
    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "id", columnDefinition = "BINARY(16)", foreignKey = @ForeignKey(name = "FK_activity_prov_acc_link_user_id"))
    private User user;

    /**
     * The access token's SHA256 hash
     */
    @Column(name = "access_token_sha256")
    private String accessTokenSHA256;

    /**
     * The access token for the associated external provider account
     */
    @Convert(converter = AESConverter.class)
    private String accessToken;

    /**
     * The access token secret for the associated external provider account
     */
    @Convert(converter = AESConverter.class)
    private String accessTokenSecret;

    /**
     * The token format used by {@code accessToken}
     */
    private String accessTokenFormat;

    /**
     * The refresh token for the associated external provider account
     */
    @Convert(converter = AESConverter.class)
    private String refreshToken;

    /**
     * The external id of the associated activity provider account
     */
    private String externalApiUserId;

    /**
     * The auth type that was used for creating the account linkage and therefore needs to be used for data retrieval
     */
    private AuthType authType;
}
