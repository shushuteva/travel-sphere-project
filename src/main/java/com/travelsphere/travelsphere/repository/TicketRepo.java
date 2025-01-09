package com.travelsphere.travelsphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelsphere.travelsphere.model.Ticket;
@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {


    public Ticket findByBookingId(Integer bookingId);

}
