package com.example.vege.service;

import com.example.vege.entity.Report;
import com.example.vege.repository.ReportRepository;
import com.example.vege.request.ReportCreate;
import com.example.vege.response.ReportResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ErrorReportService {

    private final ReportRepository reportRepository;

    public List<ReportResponse> getList(Long page) {

        return reportRepository.findList(page).stream()
                .map(ReportResponse::new)
                .collect(Collectors.toList());
    }


    public void write(ReportCreate reportCreate) {

        Report report = Report.builder()
                .title(reportCreate.getTitle())
                .content(reportCreate.getContent())
                .build();

        reportRepository.save(report);
    }


    public void deleteReport(Long reportId) {
        reportRepository.deleteById(reportId);
    }

    public ReportResponse findReport(Long reportId) {
        return reportRepository.findById(reportId).map(ReportResponse::new).orElseThrow(()->new IllegalArgumentException());
    }
}
