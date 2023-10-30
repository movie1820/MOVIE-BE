package com.example.vege.repository;

import com.example.vege.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AttachmentRepository extends JpaRepository<Attachment,Long>,AttachmentRepositoryCustom {

}
