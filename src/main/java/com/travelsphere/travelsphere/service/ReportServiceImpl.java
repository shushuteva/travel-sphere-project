package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.dto.ReportDto;
import com.travelsphere.travelsphere.exceptions.LoginException;
import com.travelsphere.travelsphere.exceptions.ReportException;
import com.travelsphere.travelsphere.mapper.ReportMapper;
import com.travelsphere.travelsphere.model.CurrentSession;
import com.travelsphere.travelsphere.model.Report;
import com.travelsphere.travelsphere.repository.ReportRepo;
import com.travelsphere.travelsphere.repository.SessionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepo reportRepo;

    @Autowired
    private SessionRepo sessionRepo;

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public ReportDto addReport(ReportDto reportDto, String key) throws ReportException, LoginException {
        validateAdminSession(key);

        Report report = reportMapper.toEntity(reportDto);
        Report savedReport = reportRepo.save(report);
        return reportMapper.toDto(savedReport);
    }

    @Override
    public ReportDto viewReport(Integer reportId, String key) throws ReportException, LoginException {
        validateAdminSession(key);

        Report report = reportRepo.findById(reportId).orElseThrow(() ->
                new ReportException("No report found with ID: " + reportId));
        return reportMapper.toDto(report);
    }

    @Override
    public List<ReportDto> viewAllReports(String key) throws ReportException, LoginException {
        validateAdminSession(key);

        List<Report> reports = reportRepo.findAll();
        if (reports.isEmpty()) {
            throw new ReportException("No reports registered");
        }

        return reports.stream().map(reportMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ReportDto deleteReport(Integer reportId, String key) throws ReportException, LoginException {
        validateAdminSession(key);

        Report report = reportRepo.findById(reportId).orElseThrow(() ->
                new ReportException("No report record found with this ID"));

        reportRepo.delete(report);

        return reportMapper.toDto(report);
    }

    private void validateAdminSession(String key) throws LoginException {
        CurrentSession currentSession = sessionRepo.findByUuid(key).orElseThrow(() ->
                new LoginException("Invalid session key"));

        if (!"ADMIN".equals(currentSession.getUserType())) {
            throw new LoginException("You are not authorized");
        }
    }
}
