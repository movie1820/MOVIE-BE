package com.example.vege.service.file;

import com.example.vege.file.FileStore;
import com.example.vege.repository.attachment.AttachmentRepository;
import com.example.vege.response.FileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService{
    private final AttachmentRepository attachmentRepository;
    private final FileStore fileStore;

    @Override
    public void saveAttachment(MultipartFile multipartFile) throws IOException {
        fileStore.storeFile(multipartFile);
    }

    @Override
    public void deleteAttachment(Long attachmentId){
        attachmentRepository.deleteById(attachmentId);
    }

    @Override
    public List<FileResponse> find(String email, Long page) {
        return attachmentRepository.getList(email,page).stream()
                .map(FileResponse::new)
                .collect(Collectors.toList());
    }
    @Override
    public FileResponse findFile(Long attachmentId) {
        return attachmentRepository.findById(attachmentId).map(FileResponse::new).orElseThrow(()->new IllegalArgumentException());
    }
}
