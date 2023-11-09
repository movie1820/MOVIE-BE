package com.example.vege.controller.file;

import com.example.vege.file.FileStore;
import com.example.vege.repository.attachment.AttachmentRepository;
import com.example.vege.request.FileCreate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class FileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FileStore fileStore;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private AttachmentRepository attachmentRepository;

    @AfterEach
    void clean(){
        attachmentRepository.deleteAll();
    }

    @Test
    @DisplayName("사진 파일 저장")
    void test1() throws Exception {

        MockMultipartFile multipartFile=new MockMultipartFile("file", "test.txt", MediaType.TEXT_PLAIN_VALUE , "test file".getBytes(StandardCharsets.UTF_8) );


        mockMvc.perform(MockMvcRequestBuilders.multipart("/file")
                        .file(multipartFile)
                        .with(SecurityMockMvcRequestPostProcessors.oauth2Login()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());


    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("사진 파일 목록 조회")
    void test2() throws Exception {
        MockMultipartFile multipartFile=new MockMultipartFile("file", "test.txt", MediaType.TEXT_PLAIN_VALUE , "test file".getBytes(StandardCharsets.UTF_8) );

//        fileStore.storeFile(multipartFile);

        MockMultipartFile multipartFile2=new MockMultipartFile("file", "test22.txt", MediaType.TEXT_PLAIN_VALUE , "test file".getBytes(StandardCharsets.UTF_8) );
//        fileStore.storeFile(multipartFile2);

        mockMvc.perform(MockMvcRequestBuilders.get("/file")
                        .contentType(MediaType.APPLICATION_JSON)
                        .with(SecurityMockMvcRequestPostProcessors.oauth2Login()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("사진 파일 단건 조회")
    void test3(){

    }

    @Test
    @DisplayName("사진 파일 삭제")
    void test4(){

    }
}