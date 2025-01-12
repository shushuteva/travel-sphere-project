package com.travelsphere.travelsphere.dto;

public class AdminDto {

    private Integer userId;
    private String adminName;
    private String email;
    private String mobile;

    public AdminDto() {
    }

    public AdminDto(Integer userId, String adminName, String email, String mobile) {
        this.userId = userId;
        this.adminName = adminName;
        this.email = email;
        this.mobile = mobile;
    }
    
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
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
}
