package com.example.vege.service;

import com.example.vege.entity.Report;
import com.example.vege.repository.ReportRepository;
import com.example.vege.request.ReportCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ErrorReportService {

    private final ReportRepository reportRepository;

    public List<Report> getList(Long page) {
        return reportRepository.findList(page);
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
}
