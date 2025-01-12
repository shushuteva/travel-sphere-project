package com.travelsphere.travelsphere.repository;

import com.travelsphere.travelsphere.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {
    Ticket findByBooking_BookingId(Integer bookingId);
}
