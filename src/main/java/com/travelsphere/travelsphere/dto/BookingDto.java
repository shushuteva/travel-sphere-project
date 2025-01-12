package com.travelsphere.travelsphere.dto;

import java.time.LocalDateTime;

public class BookingDto {

    private Integer bookingId;
    private LocalDateTime bookingDate;
    private String bookingStatus;
    private String bookingType;
    private Integer member;
    private PackageDto packageDetails;

    public BookingDto() {
    }

    public BookingDto(Integer bookingId, LocalDateTime bookingDate,
                      String bookingStatus, String bookingType, Integer member, PackageDto packageDetails) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.bookingStatus = bookingStatus;
        this.bookingType = bookingType;
        this.member = member;
        this.packageDetails = packageDetails;
    }

    public Integer getBookingId() { return bookingId; }
    public void setBookingId(Integer bookingId) { this.bookingId = bookingId; }

    public LocalDateTime getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDateTime bookingDate) { this.bookingDate = bookingDate; }

    public String getBookingStatus() { return bookingStatus; }
    public void setBookingStatus(String bookingStatus) { this.bookingStatus = bookingStatus; }

    public String getBookingType() { return bookingType; }
    public void setBookingType(String bookingType) { this.bookingType = bookingType; }

    public Integer getMember() { return member; }
    public void setMember(Integer member) { this.member = member; }

    public PackageDto getPackageDetails() { return packageDetails; }
    public void setPackageDetails(PackageDto packageDetails) { this.packageDetails = packageDetails; }
}
