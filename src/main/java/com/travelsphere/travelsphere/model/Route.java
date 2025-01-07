package com.travelsphere.travelsphere.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Route {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer routeId;

    @NotBlank
    @NotEmpty
    @NotNull
    private String routeFrom;

    @NotBlank
    @NotEmpty
    @NotNull
    private String routeTo;

    @NotBlank
    @NotEmpty
    @NotNull
    private String dateOfJourney;


    @NotBlank
    @NotEmpty
    @NotNull
    private String departureTime;

    @NotBlank
    @NotEmpty
    @NotNull
    private String arrivalTime;




    @NotBlank
    @NotEmpty
    @NotNull
    private String pickUpPoint;

    @NotBlank
    @NotEmpty
    @NotNull
    private String dropPoint;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private List<Bus> bus= new ArrayList<>();

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public String getRouteFrom() {
        return routeFrom;
    }

    public void setRouteFrom(String routeFrom) {
        this.routeFrom = routeFrom;
    }

    public String getRouteTo() {
        return routeTo;
    }

    public void setRouteTo(String routeTo) {
        this.routeTo = routeTo;
    }

    public String getDateOfJourney() {
        return dateOfJourney;
    }

    public void setDateOfJourney(String dateOfJourney) {
        this.dateOfJourney = dateOfJourney;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getPickUpPoint() {
        return pickUpPoint;
    }

    public void setPickUpPoint(String pickUpPoint) {
        this.pickUpPoint = pickUpPoint;
    }

    public String getDropPoint() {
        return dropPoint;
    }

    public void setDropPoint(String dropPoint) {
        this.dropPoint = dropPoint;
    }

    public List<Bus> getBus() {
        return bus;
    }

    public void setBus(List<Bus> bus) {
        this.bus = bus;
    }
}

