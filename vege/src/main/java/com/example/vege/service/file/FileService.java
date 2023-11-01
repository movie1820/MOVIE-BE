package com.example.vege.service.file;

import com.example.vege.response.FileResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {
    void saveAttachment(MultipartFile multipartFile) throws IOException;
    void deleteAttachment(Long attachmentId);
    List<FileResponse> find(String email, Long page);
    FileResponse findFile(Long attachmentId);
}
