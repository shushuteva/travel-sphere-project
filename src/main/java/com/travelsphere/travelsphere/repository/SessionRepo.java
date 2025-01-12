package com.travelsphere.travelsphere.repository;

import com.travelsphere.travelsphere.model.CurrentSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionRepo extends JpaRepository<CurrentSession, Integer> {
    Optional<CurrentSession> findByUuid(String uuid);
}
