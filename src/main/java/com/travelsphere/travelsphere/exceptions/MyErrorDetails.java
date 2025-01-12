package com.travelsphere.travelsphere.exceptions;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MyErrorDetails {

    private LocalDateTime timestamps;
    private String mgs;
    private String details;

    public LocalDateTime getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(LocalDateTime timestamps) {
        this.timestamps = timestamps;
    }

    public String getMgs() {
        return mgs;
    }

    public void setMgs(String mgs) {
        this.mgs = mgs;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}