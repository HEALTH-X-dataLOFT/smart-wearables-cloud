package com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository  extends JpaRepository<User, UUID> {

    boolean existsByKeycloakId(UUID keycloakId);

    Optional<User> findByKeycloakId(UUID keycloakId);
}
