package com.example.vege.repository.attachment;

import com.example.vege.entity.Attachment;

import java.util.List;

public interface AttachmentRepositoryCustom {
    List<Attachment> getList(String email,Long page);
}
