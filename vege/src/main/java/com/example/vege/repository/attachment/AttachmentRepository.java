package com.example.vege.repository.attachment;

import com.example.vege.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AttachmentRepository extends JpaRepository<Attachment,Long>, AttachmentRepositoryCustom {

}
