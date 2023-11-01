package com.example.vege.service.report;

import com.example.vege.entity.Report;
import com.example.vege.repository.report.ReportRepository;
import com.example.vege.request.ReportCreate;
import com.example.vege.response.ReportResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ErrorReportServiceImpl implements ReportService{

    private final ReportRepository reportRepository;

    @Override
    public List<ReportResponse> getList(Long page) {

        return reportRepository.findList(page).stream()
                .map(ReportResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public void write(ReportCreate reportCreate) {

        Report report = Report.builder()
                .title(reportCreate.getTitle())
                .content(reportCreate.getContent())
                .build();

        reportRepository.save(report);
    }

    @Override
    public void deleteReport(Long reportId) {
        reportRepository.deleteById(reportId);
    }

    @Override
    public ReportResponse findReport(Long reportId) {
        return reportRepository.findById(reportId).map(ReportResponse::new).orElseThrow(()->new IllegalArgumentException());
    }
}
