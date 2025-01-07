package com.travelsphere.travelsphere.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Report_Id;

    @NotNull
    @NotEmpty
    @NotBlank
    String Report_Name;


    @NotNull
    @NotEmpty
    @NotBlank
    String Report_Type;

    public Integer getReport_Id() {
        return Report_Id;
    }

    public void setReport_Id(Integer report_Id) {
        Report_Id = report_Id;
    }

    public String getReport_Name() {
        return Report_Name;
    }

    public void setReport_Name(String report_Name) {
        Report_Name = report_Name;
    }

    public String getReport_Type() {
        return Report_Type;
    }

    public void setReport_Type(String report_Type) {
        Report_Type = report_Type;
    }
}