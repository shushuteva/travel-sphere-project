package com.travelsphere.travelsphere.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    private Integer member;
    private String bookingStatus;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Package packageDetails;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    public Integer getMember() {
        return member;
    }

    public Package getPackageDetails() {
        return packageDetails;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setPackageDetails(Package packageDetails) {
        this.packageDetails = packageDetails;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
