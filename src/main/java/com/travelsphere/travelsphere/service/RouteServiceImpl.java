package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.dto.RouteDto;
import com.travelsphere.travelsphere.exceptions.LoginException;
import com.travelsphere.travelsphere.exceptions.RouteException;
import com.travelsphere.travelsphere.mapper.RouteMapper;
import com.travelsphere.travelsphere.model.CurrentSession;
import com.travelsphere.travelsphere.model.Route;
import com.travelsphere.travelsphere.repository.BusRepo;
import com.travelsphere.travelsphere.repository.RouteRepo;
import com.travelsphere.travelsphere.repository.SessionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepo routeRepo;

    @Autowired
    private BusRepo busRepo;

    @Autowired
    private SessionRepo sessionRepo;

    @Autowired
    private RouteMapper routeMapper;

    @Override
    public RouteDto createRoute(RouteDto routeDto, String key) throws RouteException, LoginException {
        CurrentSession currentSession = sessionRepo.findByUuid(key).orElseThrow(() -> new LoginException("Invalid session key"));

        if (!"ADMIN".equals(currentSession.getUserType())) {
            throw new LoginException("Unauthorized access");
        }

        Route existingRoute = routeRepo.findByRouteFromAndRouteToAndDateOfJourney(routeDto.getRouteFrom(), routeDto.getRouteTo(), routeDto.getDateOfJourney());
        if (existingRoute != null) {
            throw new RouteException("Route already exists for this date");
        }

        Route route = routeMapper.toEntity(routeDto);

        route.setBuses(busRepo.findByTravelNameAndCapacity(route.getRouteFrom(), 50)); 

        if (route.getBuses().isEmpty()) {
            throw new RouteException("Route not created because buses are not available");
        }

        Route savedRoute = routeRepo.save(route);
        return routeMapper.toDto(savedRoute);
    }

    @Override
    public RouteDto searchRoute(Integer routeId, String key) throws RouteException, LoginException {
        validateAdminSession(key);

        Route route = routeRepo.findById(routeId).orElseThrow(() -> new RouteException("Route not found with ID: " + routeId));
        return routeMapper.toDto(route);
    }

    @Override
    public List<RouteDto> viewAllRoutes(String key) throws RouteException, LoginException {
        validateAdminSession(key);

        List<Route> routes = routeRepo.findAll();
        if (routes.isEmpty()) {
            throw new RouteException("No routes found");
        }

        return routes.stream().map(routeMapper::toDto).collect(Collectors.toList());
    }

    private void validateAdminSession(String key) throws LoginException {
        CurrentSession currentSession = sessionRepo.findByUuid(key).orElseThrow(() -> new LoginException("Invalid session key"));

        if (!"ADMIN".equals(currentSession.getUserType())) {
            throw new LoginException("Unauthorized access");
        }
    }
}
