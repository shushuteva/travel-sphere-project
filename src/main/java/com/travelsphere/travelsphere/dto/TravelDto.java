package com.travelsphere.travelsphere.dto;

public class TravelDto {

    private Integer travelId;
    private String travelName;
    private String description; // Add the missing description field

    public TravelDto() {
    }

    public TravelDto(Integer travelId, String travelName, String description) {
        this.travelId = travelId;
        this.travelName = travelName;
        this.description = description;
    }

    public Integer getTravelId() {
        return travelId;
    }

    public void setTravelId(Integer travelId) {
        this.travelId = travelId;
    }

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
}
