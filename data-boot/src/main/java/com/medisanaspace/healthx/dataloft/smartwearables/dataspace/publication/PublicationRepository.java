package com.medisanaspace.healthx.dataloft.smartwearables.dataspace.publication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, UUID>, JpaSpecificationExecutor<Publication> {

    @Modifying
    @Query("update Publication p set p.suspended = :suspend where p.publicationId = :publicationId and p.userId = :userId")
    void setSuspended(UUID publicationId, UUID userId, boolean suspend);

    void deleteByPublicationIdAndUserId(UUID publicationId, UUID userId);

    boolean existsByPublicationIdAndUserId(UUID publicationId, UUID userId);
}
