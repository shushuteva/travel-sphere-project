package com.travelsphere.travelsphere.repository;

import com.travelsphere.travelsphere.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepo extends JpaRepository<Route, Integer> {

    Route findByRouteFromAndRouteToAndDateOfJourney(String routeFrom, String routeTo, String dateOfJourney);
}
