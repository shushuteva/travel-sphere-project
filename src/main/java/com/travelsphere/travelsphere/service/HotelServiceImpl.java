package com.travelsphere.travelsphere.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelsphere.travelsphere.exceptions.*;

import com.travelsphere.travelsphere.model.*;

import com.travelsphere.travelsphere.repository.*;


@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private SessionRepo sessionRepo;



    @Override
    public Hotel createHotel(Hotel hotel,String key) throws HotelException, LoginException {



        CurrentSession currentSession=	sessionRepo.findByUuid(key);
        if(currentSession==null) throw new LoginException("Please enter valid key ");

        if(!currentSession.getUserType().equals("ADMIN")) throw new LoginException("You are not authorized");




        Hotel existinghotel= hotelRepo.findByHotelName(hotel.getHotelName());

        if(existinghotel!=null) throw new HotelException("Hotel already Exists With this Name");

        Hotel saveHotel=hotelRepo.save(hotel);


        return saveHotel;


    }

}





