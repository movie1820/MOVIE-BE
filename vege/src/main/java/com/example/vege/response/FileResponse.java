package com.example.vege.response;

import com.example.vege.entity.Attachment;
import lombok.Getter;

@Getter
public class FileResponse {

    private String originFilename;
    private String storeFilename;

    public FileResponse(Attachment attachment) {
        this.originFilename = attachment.getOriginFilename();
        this.storeFilename = attachment.getStoreFilename();
    }

    public FileResponse(String originFilename, String storeFilename) {
        this.originFilename = originFilename;
        this.storeFilename = storeFilename;
    }
}