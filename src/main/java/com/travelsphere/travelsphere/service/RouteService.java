package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.exceptions.*;
import com.travelsphere.travelsphere.model.Route;

import java.util.List;

public interface RouteService {


    public Route createRoute(Route route, String key)throws RouteException, LoginException;

    public Route searchRoute(Integer routeId,String key) throws RouteException, LoginException;

    public List<Route> viewAllRoutes(String key) throws RouteException, LoginException;

}

