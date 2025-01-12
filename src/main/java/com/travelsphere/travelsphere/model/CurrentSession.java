package com.travelsphere.travelsphere.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class CurrentSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;
    private String userType;
    private String uuid;
    private LocalDateTime localDateTime;

    public String getUserType() {
        return userType;
    }

    public Integer getUserId() {
        return userId;
    }
}

