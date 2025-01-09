package com.travelsphere.travelsphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelsphere.travelsphere.model.Booking;


@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {

    public Booking findByCustomerIdAndBookingId(Integer customerId,Integer bookingId);

}
