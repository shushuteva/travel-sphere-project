package com.travelsphere.travelsphere.repository;

import com.travelsphere.travelsphere.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, Integer> {
    List<Booking> findByCustomer_CustomerId(Integer customerId);
}
