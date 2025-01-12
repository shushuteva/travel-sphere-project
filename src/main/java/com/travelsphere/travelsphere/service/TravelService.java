package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.dto.TravelDto;
import com.travelsphere.travelsphere.exceptions.*;

import java.util.List;

public interface TravelService {

    TravelDto createTravel(TravelDto travelDto, String key) throws TravelException, LoginException;

    List<TravelDto> viewAllTravels(String key) throws TravelException, LoginException;

    TravelDto updateTravel(TravelDto travelDto, String key) throws TravelException, LoginException;

    TravelDto getTravel(Integer id, String key) throws TravelException, LoginException;

}
