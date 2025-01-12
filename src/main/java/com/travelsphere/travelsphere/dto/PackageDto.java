package com.travelsphere.travelsphere.dto;

public class PackageDto {

    private Integer packageId;
    private String packageName;
    private String packageType;
    private Double packageCost;
    private String paymentMode;
    private Integer availableSeats;
    private String source;
    private String destination;
    private String journeyDate;

    public PackageDto() {
    }

    public PackageDto(Integer packageId, String packageName, String packageType,
                      Double packageCost, String paymentMode, Integer availableSeats,
                      String source, String destination, String journeyDate) {
        this.packageId = packageId;
        this.packageName = packageName;
        this.packageType = packageType;
        this.packageCost = packageCost;
        this.paymentMode = paymentMode;
        this.availableSeats = availableSeats;
        this.source = source;
        this.destination = destination;
        this.journeyDate = journeyDate;
    }

    public Integer getPackageId() { return packageId; }
    public void setPackageId(Integer packageId) { this.packageId = packageId; }

    public String getPackageName() { return packageName; }
    public void setPackageName(String packageName) { this.packageName = packageName; }

    public String getPackageType() { return packageType; }
    public void setPackageType(String packageType) { this.packageType = packageType; }

    public Double getPackageCost() { return packageCost; }
    public void setPackageCost(Double packageCost) { this.packageCost = packageCost; }

    public String getPaymentMode() { return paymentMode; }
    public void setPaymentMode(String paymentMode) { this.paymentMode = paymentMode; }

    public Integer getAvailableSeats() { return availableSeats; }
    public void setAvailableSeats(Integer availableSeats) { this.availableSeats = availableSeats; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public String getJourneyDate() { return journeyDate; }
    public void setJourneyDate(String journeyDate) { this.journeyDate = journeyDate; }
}
