package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.dto.BusDto;
import com.travelsphere.travelsphere.exceptions.BusException;
import com.travelsphere.travelsphere.exceptions.LoginException;
import com.travelsphere.travelsphere.exceptions.TravelException;

public interface BusService {

    BusDto createBus(BusDto busDto, Integer travelId, String key) throws BusException, TravelException, LoginException;
}
