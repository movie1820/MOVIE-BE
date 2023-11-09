package com.example.vege.controller.report;

import com.example.vege.jwt.oauth.OAuth2UserPrincipal;
import com.example.vege.request.ReportCreate;
import com.example.vege.response.ReportResponse;
import com.example.vege.response.ResponseDto;
import com.example.vege.service.report.ErrorReportServiceImpl;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ErrorReportController {

    private final ErrorReportServiceImpl errorReportService;

    @GetMapping("/report")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<List<ReportResponse>> reportList(@PathParam(value = "page")Long page){
        return ResponseEntity.ok(errorReportService.getList(page));
    }

    @GetMapping("/report/{reportId}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<ReportResponse> reportFind(@PathVariable Long reportId,@AuthenticationPrincipal OAuth2UserPrincipal userPrincipal){
        return ResponseEntity.ok(errorReportService.findReport(reportId));
    }

    @PostMapping("/report")
    public ResponseEntity<ResponseDto> reportSave(@RequestBody ReportCreate reportCreate, @AuthenticationPrincipal OAuth2UserPrincipal userPrincipal){
        errorReportService.write(reportCreate);
        return new ResponseEntity<>(new ResponseDto("신고 했습니다."), HttpStatus.OK);
    }


    @DeleteMapping("/report/{reportId}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<ResponseDto> reportDelete(@PathVariable Long reportId){
        errorReportService.deleteReport(reportId);
        return new ResponseEntity<>(new ResponseDto ("파일를 삭제했습니다."), HttpStatus.OK);
    }

}
