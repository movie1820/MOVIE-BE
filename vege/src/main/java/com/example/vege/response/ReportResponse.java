package com.example.vege.response;

import com.example.vege.entity.Report;
import lombok.Getter;

@Getter
public class ReportResponse {
    private Long reportId;
    private String title;
    private String content;
    private String createdAt;

    public ReportResponse(Report report) {
        this.reportId = report.getReportId();
        this.title = report.getTitle();
        this.content = report.getContent();
        this.createdAt = String.valueOf(report.getCreatedAt());
    }
}
