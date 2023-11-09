package com.example.vege.controller.report;


import com.example.vege.entity.Report;
import com.example.vege.repository.report.ReportRepository;
import com.example.vege.request.ReportCreate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
class ErrorReportControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ReportRepository reportRepository;

    @AfterEach
    void clean(){ reportRepository.deleteAll();
    }


    @Test
    @DisplayName("신고 저장")
    void test1() throws Exception {

        ReportCreate reportCreate=ReportCreate.builder()
                .title("신고입니다.")
                .content("신고함")
                        .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/report")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reportCreate))
                        .with(SecurityMockMvcRequestPostProcessors.oauth2Login()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

        Assertions.assertEquals(1,reportRepository.count());

    }

    @Test
    @DisplayName("신고 조회")
    void test2() throws Exception {
        Report re1 = Report.builder()
                .title("신고입니다1")
                .content("신고함1")
                .build();

        reportRepository.save(re1);

        Report re2 = Report.builder()
                .title("신고입니다2")
                .content("신고함2")
                .build();

        reportRepository.save(re2);

        mockMvc.perform(MockMvcRequestBuilders.get("/report?page=0")
                        .contentType(MediaType.APPLICATION_JSON)
                .with(SecurityMockMvcRequestPostProcessors.oauth2Login()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("신고입니다2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].title").value("신고입니다1"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("신고 개별 조회")
    void test3() throws Exception {
        Report re1 = Report.builder()
                .title("신고입니다1")
                .content("신고함1")
                .build();

        reportRepository.save(re1);

        mockMvc.perform(MockMvcRequestBuilders.get("/report/{reportId}",re1.getReportId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .with(SecurityMockMvcRequestPostProcessors.oauth2Login()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("title").value("신고입니다1"))
                .andExpect(MockMvcResultMatchers.jsonPath("content").value("신고함1"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("글 삭제")
    void test4() throws Exception {

        Report re1 = Report.builder()
                .title("신고입니다1")
                .content("신고함1")
                .build();

        reportRepository.save(re1);

        mockMvc.perform(MockMvcRequestBuilders.delete("/report/{reportId}", re1.getReportId())
                        .contentType(MediaType.APPLICATION_JSON)
                .with(SecurityMockMvcRequestPostProcessors.oauth2Login()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

        Assertions.assertEquals(0,reportRepository.count());
    }
}