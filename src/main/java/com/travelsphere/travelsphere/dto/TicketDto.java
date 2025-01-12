package com.travelsphere.travelsphere.dto;

public class TicketDto {

    private Integer ticketId;
    private Integer bookingId;
    private Integer busNumber;
    private String source;
    private String destination;
    private Integer members;
    private String dateOfJourney;
    private String depatureTime;
    private String pickUpPoint;

    public TicketDto() {
    }

    public TicketDto(Integer ticketId, Integer bookingId, Integer busNumber,
                     String source, String destination, Integer members,
                     String dateOfJourney, String depatureTime, String pickUpPoint) {
        this.ticketId = ticketId;
        this.bookingId = bookingId;
        this.busNumber = busNumber;
        this.source = source;
        this.destination = destination;
        this.members = members;
        this.dateOfJourney = dateOfJourney;
        this.depatureTime = depatureTime;
        this.pickUpPoint = pickUpPoint;
    }

    public Integer getTicketId() { return ticketId; }
    public void setTicketId(Integer ticketId) { this.ticketId = ticketId; }

    public Integer getBookingId() { return bookingId; }
    public void setBookingId(Integer bookingId) { this.bookingId = bookingId; }

    public Integer getBusNumber() { return busNumber; }
    public void setBusNumber(Integer busNumber) { this.busNumber = busNumber; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public Integer getMembers() { return members; }
    public void setMembers(Integer members) { this.members = members; }

    public String getDateOfJourney() { return dateOfJourney; }
    public void setDateOfJourney(String dateOfJourney) { this.dateOfJourney = dateOfJourney; }

    public String getDepatureTime() { return depatureTime; }
    public void setDepatureTime(String depatureTime) { this.depatureTime = depatureTime; }

    public String getPickUpPoint() { return pickUpPoint; }
    public void setPickUpPoint(String pickUpPoint) { this.pickUpPoint = pickUpPoint; }
}
