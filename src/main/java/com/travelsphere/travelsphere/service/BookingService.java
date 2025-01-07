package com.travelsphere.travelsphere.service;

import java.util.List;

import com.travelsphere.travelsphere.exceptions.BookingException;
import com.travelsphere.travelsphere.exceptions.LoginException;
import com.travelsphere.travelsphere.exceptions.PackageException;
import com.travelsphere.travelsphere.model.Booking;
import com.travelsphere.travelsphere.model.Ticket;

public interface BookingService {

    public Ticket createBooking(Booking boooking, Integer packageId,String key) throws PackageException, LoginException;

    public Booking viewBooking(Integer bookingId,String key)throws BookingException, LoginException;

    public List<Booking> viewAllBooking(String key)throws BookingException, LoginException;

    public String cancelBooking(Integer bookingId,String key) throws LoginException, BookingException;


}

