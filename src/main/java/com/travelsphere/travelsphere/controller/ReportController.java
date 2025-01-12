package com.travelsphere.travelsphere.controller;

import com.travelsphere.travelsphere.dto.ReportDto;
import com.travelsphere.travelsphere.exceptions.*;
import com.travelsphere.travelsphere.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping("/Report/{key}")
    public ResponseEntity<ReportDto> createReport(@Valid @RequestBody ReportDto reportDto, @PathVariable("key") String key) throws ReportException, LoginException {
        ReportDto savedReport = reportService.addReport(reportDto, key);
        return new ResponseEntity<>(savedReport, HttpStatus.CREATED);
    }

    @GetMapping("/Report/{id}/{key}")
    public ResponseEntity<ReportDto> getReport(@PathVariable("id") Integer reportId, @PathVariable("key") String key) throws ReportException, LoginException {
        ReportDto report = reportService.viewReport(reportId, key);
        return new ResponseEntity<>(report, HttpStatus.OK);
    }

    @GetMapping("/Report/{key}")
    public ResponseEntity<List<ReportDto>> getAllReports(@PathVariable("key") String key) throws ReportException, LoginException {
        List<ReportDto> reports = reportService.viewAllReports(key);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }
}
