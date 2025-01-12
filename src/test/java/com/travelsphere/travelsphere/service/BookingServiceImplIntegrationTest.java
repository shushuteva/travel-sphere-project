package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.dto.BookingDto;
import com.travelsphere.travelsphere.dto.TicketDto;
import com.travelsphere.travelsphere.model.CurrentSession;
import com.travelsphere.travelsphere.model.Customer;
import com.travelsphere.travelsphere.model.Package;
import com.travelsphere.travelsphere.repository.BookingRepo;
import com.travelsphere.travelsphere.repository.CustomerRepo;
import com.travelsphere.travelsphere.repository.PackageRepo;
import com.travelsphere.travelsphere.repository.SessionRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.lang.reflect.Field;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
class BookingServiceImplIntegrationTest {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private PackageRepo packageRepo;

    @Autowired
    private SessionRepo sessionRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private BookingRepo bookingRepo;

    @Test
    void testCreateBookingIntegration() throws Exception {
        Customer customer = new Customer();
        Field customerIdField = Customer.class.getDeclaredField("customerId");
        customerIdField.setAccessible(true);
        customerIdField.set(customer, 1);

        customer.setCustomerName("Test Uni");
        customer.setEmail("testuni@tu-sofia.com");
        customer.setMobile("1234567890");

        Field passwordField = Customer.class.getDeclaredField("password");
        passwordField.setAccessible(true);
        passwordField.set(customer, "password");

        customerRepo.save(customer);

        Package travelPackage = new Package();
        Field availableSeatsField = Package.class.getDeclaredField("availableSeats");
        availableSeatsField.setAccessible(true);
        availableSeatsField.set(travelPackage, 5);

        Field sourceField = Package.class.getDeclaredField("source");
        sourceField.setAccessible(true);
        sourceField.set(travelPackage, "SourceCity");

        Field destinationField = Package.class.getDeclaredField("destination");
        destinationField.setAccessible(true);
        destinationField.set(travelPackage, "DestinationCity");

        Field journeyDateField = Package.class.getDeclaredField("journeyDate");
        journeyDateField.setAccessible(true);
        journeyDateField.set(travelPackage, LocalDate.now());

        travelPackage = packageRepo.save(travelPackage);

        CurrentSession session = new CurrentSession();
        Field userIdField = CurrentSession.class.getDeclaredField("userId");
        userIdField.setAccessible(true);
        userIdField.set(session, 1);

        Field userTypeField = CurrentSession.class.getDeclaredField("userType");
        userTypeField.setAccessible(true);
        userTypeField.set(session, "CUSTOMER");

        Field uuidField = CurrentSession.class.getDeclaredField("uuid");
        uuidField.setAccessible(true);
        uuidField.set(session, "test-uuid");

        sessionRepo.save(session);

        BookingDto bookingDto = new BookingDto();
        bookingDto.setMember(2);

        Field packageIdField = Package.class.getDeclaredField("packageId");
        packageIdField.setAccessible(true);
        Integer packageId = (Integer) packageIdField.get(travelPackage);

        TicketDto result = bookingService.createBooking(bookingDto, packageId, "test-uuid");

        assertNotNull(result);
        assertEquals(1, bookingRepo.findAll().size());
    }
}
