package com.example.vege.file;

import com.example.vege.entity.Attachment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FileStore {

    @Value("${file.dir}")
    private String fileDirPath;

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

    public Attachment storeFile(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()) {
            return null;
        }
        String originalFilename = multipartFile.getOriginalFilename();
        String storeFilename = createStoreFilename(originalFilename);
        multipartFile.transferTo(new File(getFullPath(storeFilename)));

        return Attachment.builder()
                .originFilename(originalFilename)
                .storeFilename(storeFilename)
                .build();
    }

    public String storeName(MultipartFile multipartFile){
        String originalFilename = multipartFile.getOriginalFilename();
        String storeFilename = createStoreFilename(originalFilename);
        return getFullPath(storeFilename);
    }

    public List<Attachment> storeFiles(List<MultipartFile> multipartFiles) throws IOException {
        List<Attachment> attachments=new ArrayList<>();
        for(MultipartFile multipartFile:multipartFiles){
            if(!multipartFile.isEmpty()){
                attachments.add(storeFile(multipartFile));
            }
        }
        return attachments;
    }

}
