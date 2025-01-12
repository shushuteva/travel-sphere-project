package com.travelsphere.travelsphere.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer travelId;

    private String travelName;
    private String description;

    @OneToMany(mappedBy = "travel")
    private List<Bus> busList;

    public String getTravelName() {
        return travelName;
    }

    public void setTravelName(String travelName) {
        this.travelName = travelName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Bus> getBusList() {
        return busList;
    }
}
