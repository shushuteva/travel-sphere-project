package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.exceptions.BusException;
import com.travelsphere.travelsphere.exceptions.LoginException;
import com.travelsphere.travelsphere.exceptions.TravelException;
import com.travelsphere.travelsphere.model.Bus;

public interface BusService  {

    public Bus createBus(Bus bus, Integer travelid, String key)throws BusException, TravelException, LoginException;
}
