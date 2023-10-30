package com.example.vege.controller;

import com.example.vege.jwt.OAuth2UserPrincipal;
import com.example.vege.request.ReportCreate;
import com.example.vege.service.ErrorReportService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class ErrorReportController {

    private final ErrorReportService errorReportService;

    @GetMapping("/report")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void reportList(@PathParam(value = "page")Long page){
        errorReportService.getList(page);
    }

    @PostMapping("/report")
    public void reportSave(@RequestBody ReportCreate reportCreate,@AuthenticationPrincipal OAuth2UserPrincipal userPrincipal){
        errorReportService.write(reportCreate);
    }

    @DeleteMapping("/report/{reportId}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void reportDelete(@PathVariable Long reportId){
        errorReportService.deleteReport(reportId);
    }

}
