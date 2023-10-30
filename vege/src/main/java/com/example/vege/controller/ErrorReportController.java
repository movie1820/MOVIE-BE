package com.example.vege.controller;

import com.example.vege.request.ReportCreate;
import com.example.vege.service.ErrorReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ErrorReportController {

    private final ErrorReportService errorReportService;

    @GetMapping("/report") //게시글 목록 조회 -페이징 기능 추가해야한다.
    public void reportList(){
        errorReportService.getList();
    }

    @PostMapping("/report") // 게시글 저장
    public void reportSave(@RequestBody ReportCreate reportCreate){
        errorReportService.write(reportCreate);
    }

    @DeleteMapping("/report/{reportId}") // 게시글 삭제
    public void reportDelete(@PathVariable Long reportId){
        errorReportService.deleteReport(reportId);
    }

}
