package com.travelsphere.travelsphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelsphere.travelsphere.model.CurrentSession;
@Repository
public interface SessionRepo extends JpaRepository<CurrentSession, Integer>{



    public CurrentSession findByUuid(String uuid);

}
