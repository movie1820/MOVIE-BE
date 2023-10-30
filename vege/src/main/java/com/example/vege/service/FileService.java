package com.example.vege.service;

import com.example.vege.file.FileStore;
import com.example.vege.repository.AttachmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FileService {
    private final AttachmentRepository attachmentRepository;
    private final FileStore fileStore;

    public void saveAttachment(MultipartFile multipartFile) throws IOException {
        fileStore.storeFile(multipartFile);
    }


    public void deleteAttachment(Long attachmentId){
        attachmentRepository.deleteById(attachmentId);
    }

    public void find(String email, Long page) {
        attachmentRepository.getList(email,page);
    }
}
