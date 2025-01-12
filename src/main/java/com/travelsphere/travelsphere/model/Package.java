package com.travelsphere.travelsphere.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer packageId;

    private String packageName;
    private Integer availableSeats;
    private String source;
    private String destination;
    private LocalDate journeyDate;

    @ManyToOne
    private Bus bus;

    public String getPackageName() {
        return packageName;
    }

    public Bus getBus() {
        return bus;
    }

    public LocalDate getJourneyDate() {
        return journeyDate;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public Route getRoute() {
        return bus != null ? bus.getRoute() : null;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }
}
