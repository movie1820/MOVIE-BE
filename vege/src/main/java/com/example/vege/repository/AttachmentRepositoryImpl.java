package com.example.vege.repository;

import com.example.vege.entity.Attachment;
import com.example.vege.entity.QAttachment;
import com.example.vege.entity.QUser;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.vege.entity.QAttachment.*;
import static com.example.vege.entity.QUser.user;

@Repository
@RequiredArgsConstructor
public class AttachmentRepositoryImpl implements AttachmentRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Attachment> getList(String email,Long page) {
        return jpaQueryFactory.selectFrom(attachment)
                .leftJoin(attachment.user, user).fetchJoin()
                .where(user.email.eq(email))
                .limit(10)
                .offset(page)
                .orderBy(attachment.attachmentId.desc())
                .fetch();
    }
}
