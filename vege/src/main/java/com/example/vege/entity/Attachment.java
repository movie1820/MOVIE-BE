package com.example.vege.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Attachment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attachmentId;
    private String originFilename;
    private String storeFilename;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @Builder

    public Attachment(String originFilename, String storeFilename, User user) {
        this.originFilename = originFilename;
        this.storeFilename = storeFilename;
        this.user = user;
    }
}
