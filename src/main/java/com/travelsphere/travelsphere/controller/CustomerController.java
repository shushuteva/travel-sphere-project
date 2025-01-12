package com.travelsphere.travelsphere.controller;

import com.travelsphere.travelsphere.dto.*;
import com.travelsphere.travelsphere.exceptions.*;
import com.travelsphere.travelsphere.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BookingService bookingService;

    @PostMapping("/Customers")
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto customerDto) throws CustomerException {
        CustomerDto savedCustomer = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @PostMapping("/Bookings/{packageId}/{key}")
    public ResponseEntity<TicketDto> createBooking(@Valid @RequestBody BookingDto bookingDto, @PathVariable("packageId") Integer packageId, @PathVariable("key") String key) throws CustomerException, PackageException, LoginException {
        TicketDto savedBooking = bookingService.createBooking(bookingDto, packageId, key);
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }

    @GetMapping("/Bookings/{key}")
    public ResponseEntity<List<BookingDto>> viewAllBookings(@PathVariable("key") String key) throws BookingException, LoginException {
        List<BookingDto> bookings = bookingService.viewAllBookings(key);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }
}
