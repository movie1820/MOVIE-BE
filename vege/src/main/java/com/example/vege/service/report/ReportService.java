package com.example.vege.service.report;

import com.example.vege.request.ReportCreate;
import com.example.vege.response.ReportResponse;

import java.util.List;

public interface ReportService {
    List<ReportResponse> getList(Long page);
    void write(ReportCreate reportCreate);
    void deleteReport(Long reportId);
    ReportResponse findReport(Long reportId);
}
