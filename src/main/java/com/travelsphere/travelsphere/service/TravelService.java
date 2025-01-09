package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.exceptions.*;
import com.travelsphere.travelsphere.model.Travel;

import java.util.List;

public interface TravelService {

    public Travel createTravel(Travel travel, String key) throws TravelException, LoginException;

    public List<Travel> ViewTravel(String key)throws TravelException, LoginException;

    public Travel updateTravel(Travel travel,String key)throws TravelException, LoginException;

    public Travel getTravel(Integer Id,String key)throws TravelException, LoginException;
}

