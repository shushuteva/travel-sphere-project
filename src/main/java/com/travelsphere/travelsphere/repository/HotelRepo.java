package com.travelsphere.travelsphere.repository;

import com.travelsphere.travelsphere.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Integer> {
    Hotel findByHotelName(String hotelName);

    Hotel findByHotelAddress(String hotelAddress);
}
