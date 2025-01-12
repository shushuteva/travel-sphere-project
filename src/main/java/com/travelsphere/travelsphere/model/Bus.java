package com.travelsphere.travelsphere.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer busId;

    private String busNumber;
    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    private String travelName;

    @ManyToOne
    @JoinColumn(name = "travel_id")
    private Travel travel;

    public String getTravelName() {
        return travelName;
    }

    public void setTravelName(String travelName) {
        this.travelName = travelName;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }
}
