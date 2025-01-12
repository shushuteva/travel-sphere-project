package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.dto.BookingDto;
import com.travelsphere.travelsphere.dto.TicketDto;
import com.travelsphere.travelsphere.exceptions.LoginException;
import com.travelsphere.travelsphere.exceptions.PackageException;
import com.travelsphere.travelsphere.mapper.BookingMapper;
import com.travelsphere.travelsphere.mapper.TicketMapper;
import com.travelsphere.travelsphere.model.*;
import com.travelsphere.travelsphere.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Field;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookingServiceImplTest {

    @Mock
    private BookingRepo bookingRepo;

    @Mock
    private PackageRepo packageRepo;

    @Mock
    private SessionRepo sessionRepo;

    @Mock
    private CustomerRepo customerRepo;

    @Mock
    private TicketRepo ticketRepo;

    @Mock
    private BookingMapper bookingMapper;

    @Mock
    private TicketMapper ticketMapper;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateBooking_Success() throws Exception {
        BookingDto bookingDto = new BookingDto();
        bookingDto.setMember(2);

        CurrentSession currentSession = new CurrentSession();
        setFieldValue(currentSession, "userId", 1);
        setFieldValue(currentSession, "userType", "CUSTOMER");

        com.travelsphere.travelsphere.model.Package travelPackage = new com.travelsphere.travelsphere.model.Package();
        travelPackage.setAvailableSeats(5);

        Customer customer = new Customer();
        Booking booking = new Booking();
        Ticket ticket = new Ticket();
        TicketDto ticketDto = new TicketDto();

        when(sessionRepo.findByUuid(anyString())).thenReturn(Optional.of(currentSession));
        when(packageRepo.findById(anyInt())).thenReturn(Optional.of(travelPackage));
        when(customerRepo.findById(anyInt())).thenReturn(Optional.of(customer));
        when(bookingMapper.toEntity(any())).thenReturn(booking);
        when(ticketMapper.toDto(any())).thenReturn(ticketDto);

        TicketDto result = bookingService.createBooking(bookingDto, 1, "test-uuid");

        assertNotNull(result);
        verify(packageRepo, times(1)).save(travelPackage);
        verify(bookingRepo, times(1)).save(booking);
        verify(ticketRepo, times(1)).save(any(Ticket.class));
    }

    @Test
    void testCreateBooking_NotEnoughSeats() throws Exception {
        BookingDto bookingDto = new BookingDto();
        bookingDto.setMember(10);

        CurrentSession currentSession = new CurrentSession();
        setFieldValue(currentSession, "userId", 1);
        setFieldValue(currentSession, "userType", "CUSTOMER");

        com.travelsphere.travelsphere.model.Package travelPackage = new com.travelsphere.travelsphere.model.Package();
        travelPackage.setAvailableSeats(5);

        when(sessionRepo.findByUuid(anyString())).thenReturn(Optional.of(currentSession));
        when(packageRepo.findById(anyInt())).thenReturn(Optional.of(travelPackage));

        PackageException exception = assertThrows(PackageException.class, () -> {
            bookingService.createBooking(bookingDto, 1, "test-uuid");
        });

        assertEquals("Not enough available seats", exception.getMessage());
        verify(packageRepo, never()).save(travelPackage);
        verify(bookingRepo, never()).save(any());
    }

    @Test
    void testCreateBooking_InvalidSession() {
        when(sessionRepo.findByUuid(anyString())).thenReturn(Optional.empty());

        LoginException exception = assertThrows(LoginException.class, () -> {
            bookingService.createBooking(new BookingDto(), 1, "invalid-uuid");
        });

        assertEquals("Invalid session key", exception.getMessage());
        verify(bookingRepo, never()).save(any());
    }

    @Test
    void testCreateBooking_PackageNotFound() throws Exception {
        BookingDto bookingDto = new BookingDto();

        CurrentSession currentSession = new CurrentSession();
        setFieldValue(currentSession, "userId", 1);
        setFieldValue(currentSession, "userType", "CUSTOMER");

        when(sessionRepo.findByUuid(anyString())).thenReturn(Optional.of(currentSession));
        when(packageRepo.findById(anyInt())).thenReturn(Optional.empty());

        PackageException exception = assertThrows(PackageException.class, () -> {
            bookingService.createBooking(bookingDto, 1, "test-uuid");
        });

        assertEquals("Package not found", exception.getMessage());
        verify(bookingRepo, never()).save(any());
    }

    private void setFieldValue(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}
