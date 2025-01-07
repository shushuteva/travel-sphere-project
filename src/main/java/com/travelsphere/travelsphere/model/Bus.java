package com.travelsphere.travelsphere.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer busNumber;

    private Integer capacity;

    @NotBlank
    @NotEmpty
    @NotNull
    private String busFrom;

    @NotBlank
    @NotEmpty
    @NotNull
    private String busTo;

    @NotBlank
    @NotEmpty
    @NotNull
    private String journeyDate;


    private String travelName;


    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Travel travel;

    public Integer getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(Integer busNumber) {
        this.busNumber = busNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getBusFrom() {
        return busFrom;
    }

    public void setBusFrom(String busFrom) {
        this.busFrom = busFrom;
    }

    public String getBusTo() {
        return busTo;
    }

    public void setBusTo(String busTo) {
        this.busTo = busTo;
    }

    public String getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(String journeyDate) {
        this.journeyDate = journeyDate;
    }

    public String getTravelName() {
        return travelName;
    }

    public void setTravelName(String travelName) {
        this.travelName = travelName;
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }
}
