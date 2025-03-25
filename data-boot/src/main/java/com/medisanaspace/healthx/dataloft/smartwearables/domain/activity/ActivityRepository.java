package com.medisanaspace.healthx.dataloft.smartwearables.domain.activity;

import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, UUID>, JpaSpecificationExecutor<Activity> {

    List<Activity> findAllByUserOrderByCreatedOnDescStartTimeDesc(User user);

    Optional<Activity> findByExternalIdAndStartTime(String externalId, Instant startTime);

    long deleteByExternalIdAndStartTime(String externalId, Instant startTime);

    @Override
    @NonNull
    @EntityGraph(attributePaths = {"samples"})
    List<Activity> findAll(Specification<Activity> spec);

    void deleteAllByUser(User user);

    @Query("select a FROM Activity a left join fetch a.samples where a.id = ?1")
    Optional<Activity> findByIdWithSamples(UUID id);
}
