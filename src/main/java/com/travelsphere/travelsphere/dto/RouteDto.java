package com.travelsphere.travelsphere.dto;

public class RouteDto {

    private Integer routeId;
    private String routeFrom;
    private String routeTo;
    private String dateOfJourney;
    private String departureTime;
    private String arrivalTime;
    private String pickUpPoint;
    private String dropPoint;

    public RouteDto() {
    }

    public RouteDto(Integer routeId, String routeFrom, String routeTo,
                    String dateOfJourney, String departureTime, String arrivalTime,
                    String pickUpPoint, String dropPoint) {
        this.routeId = routeId;
        this.routeFrom = routeFrom;
        this.routeTo = routeTo;
        this.dateOfJourney = dateOfJourney;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.pickUpPoint = pickUpPoint;
        this.dropPoint = dropPoint;
    }

    public Integer getRouteId() { return routeId; }
    public void setRouteId(Integer routeId) { this.routeId = routeId; }

    public String getRouteFrom() { return routeFrom; }
    public void setRouteFrom(String routeFrom) { this.routeFrom = routeFrom; }

    public String getRouteTo() { return routeTo; }
    public void setRouteTo(String routeTo) { this.routeTo = routeTo; }

    public String getDateOfJourney() { return dateOfJourney; }
    public void setDateOfJourney(String dateOfJourney) { this.dateOfJourney = dateOfJourney; }

    public String getDepartureTime() { return departureTime; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }

    public String getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(String arrivalTime) { this.arrivalTime = arrivalTime; }

    public String getPickUpPoint() { return pickUpPoint; }
    public void setPickUpPoint(String pickUpPoint) { this.pickUpPoint = pickUpPoint; }

    public String getDropPoint() { return dropPoint; }
    public void setDropPoint(String dropPoint) { this.dropPoint = dropPoint; }
}
