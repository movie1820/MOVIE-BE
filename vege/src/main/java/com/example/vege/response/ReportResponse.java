package com.example.vege.response;

import com.example.vege.entity.Report;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
public class ReportResponse {
    private Long reportId;
    private String title;
    private String content;
    private String createdAt;

    @Builder
    public ReportResponse(Report report) {
        this.reportId = report.getReportId();
        this.title = report.getTitle();
        this.content = report.getContent();
        this.createdAt = String.valueOf(report.getCreatedAt());
    }
}
