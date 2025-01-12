package com.travelsphere.travelsphere.dto;

public class BusDto {

    private Integer busNumber;
    private String busFrom;
    private String busTo;
    private Integer capacity;
    private String journeyDate;

    public BusDto() {
    }

    public BusDto(Integer busNumber, String busFrom, String busTo,
                  Integer capacity, String journeyDate) {
        this.busNumber = busNumber;
        this.busFrom = busFrom;
        this.busTo = busTo;
        this.capacity = capacity;
        this.journeyDate = journeyDate;
    }

    public Integer getBusNumber() { return busNumber; }
    public void setBusNumber(Integer busNumber) { this.busNumber = busNumber; }

    public String getBusFrom() { return busFrom; }
    public void setBusFrom(String busFrom) { this.busFrom = busFrom; }

    public String getBusTo() { return busTo; }
    public void setBusTo(String busTo) { this.busTo = busTo; }

    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }

    public String getJourneyDate() { return journeyDate; }
    public void setJourneyDate(String journeyDate) { this.journeyDate = journeyDate; }
}
