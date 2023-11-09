package com.example.vege.service.file;

import com.example.vege.response.FileResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {
    FileResponse saveAttachment(MultipartFile multipartFile,String email) throws IOException;
    boolean deleteAttachment(Long attachmentId,String email);
    List<FileResponse> find(String email, Long page);
    FileResponse findFile(Long attachmentId,String email);
}
