package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.dto.HotelDto;
import com.travelsphere.travelsphere.exceptions.HotelException;
import com.travelsphere.travelsphere.exceptions.LoginException;

public interface HotelService {

    HotelDto createHotel(HotelDto hotelDto, String key) throws HotelException, LoginException;

}
