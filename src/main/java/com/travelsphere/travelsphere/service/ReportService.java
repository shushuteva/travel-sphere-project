package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.exceptions.*;
import com.travelsphere.travelsphere.model.Report;

import java.util.List;

public interface ReportService {


    public Report addReport(Report report, String key)throws ReportException, LoginException;

    public Report viewReport(Integer ReportId,String key)throws ReportException, LoginException;

    public List<Report> ViewAllReport(String key) throws ReportException, LoginException;

    public Report DeleteReport(Integer ReportId,String key)throws ReportException, LoginException;
}
