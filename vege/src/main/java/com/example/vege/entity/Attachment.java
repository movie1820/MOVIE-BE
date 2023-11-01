package com.example.vege.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Attachment {
    @Id @GeneratedValue
    private Long id;
    private String originFilename;
    private String storeFilename;

    @Builder
    public Attachment(String originFilename, String storeFilename) {
        this.originFilename = originFilename;
        this.storeFilename = storeFilename;
    }
}
