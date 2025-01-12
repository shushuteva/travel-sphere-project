package com.travelsphere.travelsphere.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer routeId;

    private String routeFrom;
    private String routeTo;
    private String dateOfJourney;
    private String departureTime;
    private String arrivalTime;

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bus> buses = new ArrayList<>();

    public String getRouteFrom() {
        return routeFrom;
    }

    public String getRouteTo() {
        return routeTo;
    }

    public String getDateOfJourney() {
        return dateOfJourney;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void setBuses(List<Bus> buses) {
        this.buses = buses;
        for (Bus bus : buses) {
            bus.setRoute(this);
        }
    }
}
