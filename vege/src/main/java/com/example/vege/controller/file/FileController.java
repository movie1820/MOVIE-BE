package com.example.vege.controller.file;

import com.example.vege.jwt.oauth.OAuth2UserPrincipal;
import com.example.vege.request.FileCreate;
import com.example.vege.response.FileResponse;
import com.example.vege.response.ResponseDto;
import com.example.vege.service.file.FileServiceImpl;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileServiceImpl fileService;

    @GetMapping("/file")
    public ResponseEntity<List<FileResponse>> fileList(@PathParam(value = "page")Long page, @AuthenticationPrincipal OAuth2UserPrincipal userPrincipal){
        return ResponseEntity.ok(fileService.find(userPrincipal.getUsername(),page));
    }

    @GetMapping("/file/{attachmentId}")
    public ResponseEntity<FileResponse> fileFind(@PathVariable Long attachmentId, @AuthenticationPrincipal OAuth2UserPrincipal userPrincipal){
        return ResponseEntity.ok(fileService.findFile(attachmentId));
    }

    @PostMapping("/file")
    public ResponseEntity<ResponseDto> saveFile(@RequestBody FileCreate fileCreate, @AuthenticationPrincipal OAuth2UserPrincipal userPrincipal) throws IOException {
        fileService.saveAttachment((MultipartFile) fileCreate);
        return new ResponseEntity<>(new ResponseDto("파일을 저장했습니다."), HttpStatus.OK);
    }

    @DeleteMapping("/file/{attachmentId}")
    public ResponseEntity<ResponseDto> deleteFile(@PathVariable Long attachmentId, @AuthenticationPrincipal OAuth2UserPrincipal userPrincipal){
        fileService.deleteAttachment(attachmentId);
        return new ResponseEntity<>(new ResponseDto("파일을 삭제했습니다."), HttpStatus.OK);
    }
}
