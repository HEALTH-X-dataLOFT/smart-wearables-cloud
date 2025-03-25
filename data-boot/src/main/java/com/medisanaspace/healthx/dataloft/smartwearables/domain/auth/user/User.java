package com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user;

import com.medisanaspace.healthx.dataloft.smartwearables.domain.base.entity.AbstractEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "healthx_swc_user")
public class User extends AbstractEntity {

    @CreationTimestamp
    Instant createdOn;

    @Column(columnDefinition = "BINARY(16)", unique = true, nullable = false)
    UUID keycloakId;

    String firstName;
    String lastName;
    String thryveToken;

}
