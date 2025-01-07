package com.travelsphere.travelsphere.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Customer extends User {

    @NotBlank
    @NotEmpty
    @NotNull
    private String customerName;

    @NotBlank
    @NotEmpty
    @NotNull
    private String address;

    @Email
    private String email;

    @Pattern(regexp = "[6789]{1}[0-9]{9}",message = "Mobile Number start with 6,7,8,9 and must be 10 digit")
    private String mobile;

    @Pattern(regexp = "[A-Za-z0-9@]{6,15}")
    private String password;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Booking> bookinglist= new ArrayList<>();


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Booking> getBookinglist() {
        return bookinglist;
    }

    public void setBookinglist(List<Booking> bookinglist) {
        this.bookinglist = bookinglist;
    }
}
