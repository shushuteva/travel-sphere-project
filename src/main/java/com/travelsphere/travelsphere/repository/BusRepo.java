package com.travelsphere.travelsphere.repository;

import com.travelsphere.travelsphere.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepo extends JpaRepository<Bus, Integer> {

    List<Bus> findByTravelNameAndCapacity(String travelName, Integer capacity); 
}
