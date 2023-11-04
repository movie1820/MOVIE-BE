package com.example.vege.response;

import com.example.vege.entity.Attachment;
import lombok.Getter;

@Getter
public class FileResponse {

    private Long attachmentId;
    private String originFilename;
    private String storeFilename;

    public FileResponse(Attachment attachment) {
        this.attachmentId = attachment.getAttachmentId();
        this.originFilename = attachment.getOriginFilename();
        this.storeFilename = attachment.getStoreFilename();
    }
}