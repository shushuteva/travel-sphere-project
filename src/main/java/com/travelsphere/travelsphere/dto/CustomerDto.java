package com.travelsphere.travelsphere.dto;

public class CustomerDto {

    private Integer userId;
    private String customerName;
    private String address;
    private String email;
    private String mobile;

    public CustomerDto() {
    }

    public CustomerDto(Integer userId, String customerName, String address,
                       String email, String mobile) {
        this.userId = userId;
        this.customerName = customerName;
        this.address = address;
        this.email = email;
        this.mobile = mobile;
    }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }
}
