package com.example.vege.service.file;

import com.example.vege.entity.User;
import com.example.vege.file.FileStore;
import com.example.vege.repository.attachment.AttachmentRepository;
import com.example.vege.repository.user.UserRepository;
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
    private final UserRepository userRepository;
    private final FileStore fileStore;

    @Override
    public FileResponse saveAttachment(MultipartFile multipartFile,String email) throws IOException {
        return fileStore.storeFile(multipartFile,email);
    }

    @Override
    public boolean deleteAttachment(Long attachmentId,String email){
        User user = attachmentRepository.findById(attachmentId).get().getUser();
        if(userRepository.findByEmail(email).equals(user)) {
            attachmentRepository.deleteById(attachmentId);
            return true;
        }
        return false;
    }

    @Override
    public List<FileResponse> find(String email, Long page) {
        return attachmentRepository.getList(email,page).stream()
                .map(FileResponse::new)
                .collect(Collectors.toList());
    }
    @Override
    public FileResponse findFile(Long attachmentId,String email) {
        User user = attachmentRepository.findById(attachmentId).get().getUser();
        if(userRepository.findByEmail(email).equals(user)) {
            attachmentRepository.deleteById(attachmentId);
            return attachmentRepository.findById(attachmentId).map(FileResponse::new).orElseThrow(()->new IllegalArgumentException());
        }
        return null;
    }
}
