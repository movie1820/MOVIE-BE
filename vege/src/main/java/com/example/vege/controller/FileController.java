package com.example.vege.controller;

import com.example.vege.request.FileCreate;
import com.example.vege.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("/file")
    public void saveFile(@RequestBody FileCreate fileCreate) throws IOException {
        fileService.saveAttachment((MultipartFile) fileCreate);
    }

    @GetMapping("/file")//목록조회로 변형해야한다.
    public void fileList(){

    }

    @DeleteMapping("/file/{attachmentId}")
    public void deleteFile(@PathVariable Long attachmentId){
        fileService.deleteAttachment(attachmentId);
    }

}
