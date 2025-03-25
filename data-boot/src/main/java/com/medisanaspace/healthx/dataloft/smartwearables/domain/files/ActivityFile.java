package com.medisanaspace.healthx.dataloft.smartwearables.domain.files;

import com.medisanaspace.healthx.dataloft.smartwearables.domain.base.entity.AbstractEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Represents an TCX, GPX or FIT file containing activity data
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "healthx_swc_activity_files")
public class ActivityFile extends AbstractEntity {

    private ActivityFileType fileType;
    private byte[] content;
}
