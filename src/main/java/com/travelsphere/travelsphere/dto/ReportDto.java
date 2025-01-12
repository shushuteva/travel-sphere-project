package com.travelsphere.travelsphere.dto;

public class ReportDto {

    private Integer reportId;
    private String reportName;
    private String reportType;

    public ReportDto() {
    }

    public ReportDto(Integer reportId, String reportName, String reportType) {
        this.reportId = reportId;
        this.reportName = reportName;
        this.reportType = reportType;
    }

    public Integer getReportId() { return reportId; }
    public void setReportId(Integer reportId) { this.reportId = reportId; }

    public String getReportName() { return reportName; }
    public void setReportName(String reportName) { this.reportName = reportName; }

    public String getReportType() { return reportType; }
    public void setReportType(String reportType) { this.reportType = reportType; }
}
