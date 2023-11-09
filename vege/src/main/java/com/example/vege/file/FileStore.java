package com.example.vege.file;

import com.example.vege.entity.Attachment;
import com.example.vege.entity.User;
import com.example.vege.repository.attachment.AttachmentRepository;
import com.example.vege.repository.user.UserRepository;
import com.example.vege.response.FileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
//import com.example.vege.response.FileResponse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class FileStore {

    @Value("${file.dir}")
    private String fileDirPath;

    private final AttachmentRepository attachmentRepository;
    private final UserRepository userRepository;

    public String getFullPath(String filename){
        return fileDirPath+filename;
    }

    private String extractExt(String originalFilename){
        int idx=originalFilename.lastIndexOf(".");
        return originalFilename.substring(idx);
    }

    private String createStoreFilename(String originalFilename){
        String uuid= UUID.randomUUID().toString();
        String ext=extractExt(originalFilename);
        String storeFilename=uuid+ext;

        return storeFilename;
    }

    public FileResponse storeFile(MultipartFile multipartFile,String email) throws IOException {
        if (multipartFile.isEmpty()) {
            return null;
        }

        User user = userRepository.findByEmail(email).orElseThrow();

        String originalFilename = multipartFile.getOriginalFilename();
        String storeFilename = createStoreFilename(originalFilename);

        multipartFile.transferTo(new File(getFullPath(storeFilename)));

        Attachment att = Attachment.builder()
                .storeFilename(storeFilename)
                .originFilename(originalFilename)
                .user(user)
                .build();

        attachmentRepository.save(att);

        return new FileResponse(originalFilename,storeFilename);
    }

}
