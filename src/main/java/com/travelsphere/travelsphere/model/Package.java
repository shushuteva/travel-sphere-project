package com.travelsphere.travelsphere.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer packageId;

    @NotBlank
    @NotEmpty
    @NotNull
    private String packageName;

    @NotBlank
    @NotEmpty
    @NotNull
    private String source;

    @NotBlank
    @NotEmpty
    @NotNull
    private String destination;

    @NotBlank
    @NotEmpty
    @NotNull
    private String packageType;

    private Integer availableSeats;

    private String journeyDate;


    private Double packageCost;



    @NotBlank
    @NotEmpty
    @NotNull
    private  String paymentMode="online";

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Hotel hotel;



    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Route route;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Bus bus;


    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(String journeyDate) {
        this.journeyDate = journeyDate;
    }

    public Double getPackageCost() {
        return packageCost;
    }

    public void setPackageCost(Double packageCost) {
        this.packageCost = packageCost;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
}
