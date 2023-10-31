package com.example.vege.service;

import com.example.vege.file.FileStore;
import com.example.vege.repository.AttachmentRepository;
import com.example.vege.response.FileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<FileResponse> find(String email, Long page) {
        return attachmentRepository.getList(email,page).stream()
                .map(FileResponse::new)
                .collect(Collectors.toList());
    }

    public FileResponse findFile(Long attachmentId) {
        return attachmentRepository.findById(attachmentId).map(FileResponse::new).orElseThrow(()->new IllegalArgumentException());
    }
}
