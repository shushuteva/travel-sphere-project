package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.exceptions.*;
import com.travelsphere.travelsphere.model.Hotel;

public interface HotelService {


    public Hotel createHotel(Hotel hotel, String key ) throws HotelException, LoginException;


}
