package com.travelsphere.travelsphere.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotelId;

    private Integer availableRooms; 
    private String hotelAddress;
    private String hotelDescription;
    private String hotelName;
    private String hotelType;
}
