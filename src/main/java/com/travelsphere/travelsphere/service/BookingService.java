package com.travelsphere.travelsphere.service;

import java.util.List;

import com.travelsphere.travelsphere.dto.BookingDto;
import com.travelsphere.travelsphere.dto.TicketDto;
import com.travelsphere.travelsphere.exceptions.BookingException;
import com.travelsphere.travelsphere.exceptions.LoginException;
import com.travelsphere.travelsphere.exceptions.PackageException;

public interface BookingService {

    TicketDto createBooking(BookingDto bookingDto, Integer packageId, String key) throws PackageException, LoginException;

    BookingDto viewBooking(Integer bookingId, String key) throws BookingException, LoginException;

    List<BookingDto> viewAllBookings(String key) throws BookingException, LoginException;

    String cancelBooking(Integer bookingId, String key) throws LoginException, BookingException;
}
