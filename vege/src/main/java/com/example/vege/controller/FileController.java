package com.example.vege.controller;

import com.example.vege.jwt.OAuth2UserPrincipal;
import com.example.vege.request.FileCreate;
import com.example.vege.service.FileService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("/file")
    public void saveFile(@RequestBody FileCreate fileCreate, @AuthenticationPrincipal OAuth2UserPrincipal userPrincipal) throws IOException {
        fileService.saveAttachment((MultipartFile) fileCreate);
    }

    @GetMapping("/file")
    public void fileList(@PathParam(value = "page")Long page,@AuthenticationPrincipal OAuth2UserPrincipal userPrincipal){
        fileService.find(userPrincipal.getUsername(),page);

    }

    @DeleteMapping("/file/{attachmentId}")
    public void deleteFile(@PathVariable Long attachmentId,@AuthenticationPrincipal OAuth2UserPrincipal userPrincipal){
        fileService.deleteAttachment(attachmentId);
    }

}
