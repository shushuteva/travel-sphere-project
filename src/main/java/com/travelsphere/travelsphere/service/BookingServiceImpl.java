package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.dto.BookingDto;
import com.travelsphere.travelsphere.dto.TicketDto;
import com.travelsphere.travelsphere.exceptions.BookingException;
import com.travelsphere.travelsphere.exceptions.LoginException;
import com.travelsphere.travelsphere.model.Package;
import com.travelsphere.travelsphere.exceptions.PackageException;
import com.travelsphere.travelsphere.mapper.BookingMapper;
import com.travelsphere.travelsphere.mapper.TicketMapper;
import com.travelsphere.travelsphere.model.*;
import com.travelsphere.travelsphere.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private PackageRepo packageRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private SessionRepo sessionRepo;

    @Autowired
    private BookingMapper bookingMapper;

    @Autowired
    private TicketMapper ticketMapper;

    @Override
    public TicketDto createBooking(BookingDto bookingDto, Integer packageId, String key) throws PackageException, LoginException {
        CurrentSession currentSession = sessionRepo.findByUuid(key).orElseThrow(() -> new LoginException("Invalid session key"));

        if (!"CUSTOMER".equals(currentSession.getUserType())) {
            throw new LoginException("Unauthorized access");
        }

        Package existingPackage = packageRepo.findById(packageId).orElseThrow(() -> new PackageException("Package not found"));

        if (existingPackage.getAvailableSeats() < bookingDto.getMember()) {
            throw new PackageException("Not enough available seats");
        }

        existingPackage.setAvailableSeats(existingPackage.getAvailableSeats() - bookingDto.getMember());
        packageRepo.save(existingPackage);

        Booking booking = bookingMapper.toEntity(bookingDto);
        Customer customer = customerRepo.findById(currentSession.getUserId()).orElseThrow(() -> new LoginException("Customer not found"));

        booking.setCustomer(customer);
        booking.setPackageDetails(existingPackage);
        booking.setBookingStatus("Confirmed");

        Booking savedBooking = bookingRepo.save(booking);

        Ticket ticket = new Ticket();
        ticket.setDateOfJourney(existingPackage.getJourneyDate());
        ticket.setSource(existingPackage.getSource());
        ticket.setDestination(existingPackage.getDestination());

        return ticketMapper.toDto(ticketRepo.save(ticket));
    }

    @Override
    public BookingDto viewBooking(Integer bookingId, String key) throws BookingException, LoginException {
        CurrentSession currentSession = sessionRepo.findByUuid(key).orElseThrow(() -> new LoginException("Invalid session key"));

        Booking booking = bookingRepo.findById(bookingId).orElseThrow(() -> new BookingException("Booking not found"));
        return bookingMapper.toDto(booking);
    }

    @Override
    public List<BookingDto> viewAllBookings(String key) throws BookingException, LoginException {
        CurrentSession currentSession = sessionRepo.findByUuid(key).orElseThrow(() -> new LoginException("Invalid session key"));
        
        List<Booking> bookings = bookingRepo.findByCustomer_CustomerId(currentSession.getUserId());
        if (bookings.isEmpty()) throw new BookingException("No bookings found");
        return bookings.stream().map(bookingMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public String cancelBooking(Integer bookingId, String key) throws LoginException, BookingException {
        CurrentSession currentSession = sessionRepo.findByUuid(key).orElseThrow(() -> new LoginException("Invalid session key"));

        Booking booking = bookingRepo.findById(bookingId).orElseThrow(() -> new BookingException("Booking not found"));
        Package bookingPackage = booking.getPackageDetails();

        bookingPackage.setAvailableSeats(bookingPackage.getAvailableSeats() + booking.getMember());
        booking.setBookingStatus("Cancelled");

        bookingRepo.save(booking);

        Ticket ticket = ticketRepo.findByBooking_BookingId(bookingId);
        if (ticket != null) {
            ticketRepo.delete(ticket);
        }

        return "Booking canceled successfully";
    }
}
