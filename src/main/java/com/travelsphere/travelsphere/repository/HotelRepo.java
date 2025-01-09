package com.travelsphere.travelsphere.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.travelsphere.travelsphere.model.Hotel;

@Repository
public interface  HotelRepo extends JpaRepository<Hotel, Integer> {

    public Hotel findByHotelName(String hotelName);

    public Hotel  findByHotelAddress(String hotelAddress);


}