package com.travelsphere.travelsphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.travelsphere.travelsphere.model.Travel;

@Repository
public interface TravelRepo extends JpaRepository<Travel, Integer> {
    Travel findByTravelName(String travelName);
}
