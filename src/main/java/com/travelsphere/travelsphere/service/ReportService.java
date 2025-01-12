package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.dto.ReportDto;
import com.travelsphere.travelsphere.exceptions.*;

import java.util.List;

public interface ReportService {

    ReportDto addReport(ReportDto reportDto, String key) throws ReportException, LoginException;

    ReportDto viewReport(Integer reportId, String key) throws ReportException, LoginException;

    List<ReportDto> viewAllReports(String key) throws ReportException, LoginException;

    ReportDto deleteReport(Integer reportId, String key) throws ReportException, LoginException;
}
