package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.dto.RouteDto;
import com.travelsphere.travelsphere.exceptions.*;

import java.util.List;

public interface RouteService {

    RouteDto createRoute(RouteDto routeDto, String key) throws RouteException, LoginException;

    RouteDto searchRoute(Integer routeId, String key) throws RouteException, LoginException;

    List<RouteDto> viewAllRoutes(String key) throws RouteException, LoginException;

}
