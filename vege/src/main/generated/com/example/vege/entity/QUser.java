package com.example.vege.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1206529606L;

    public static final QUser user = new QUser("user");

    public final ListPath<Attachment, QAttachment> attachments = this.<Attachment, QAttachment>createList("attachments", Attachment.class, QAttachment.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    public final StringPath name = createString("name");

    public final EnumPath<com.example.vege.entity.status.OAuthProvider> oAuthProvider = createEnum("oAuthProvider", com.example.vege.entity.status.OAuthProvider.class);

    public final EnumPath<com.example.vege.entity.status.MyRole> role = createEnum("role", com.example.vege.entity.status.MyRole.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

