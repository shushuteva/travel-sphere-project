package com.travelsphere.travelsphere.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;

    private String adminName;
    private String email;
    private String password;

    public Admin() {
    }

    public Admin(String adminName, String email, String password) {
        this.adminName = adminName;
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
}
