package com.example.vege.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FileCreate {

    private String originFilename;

    @Builder
    public FileCreate(String originFilename) {
        this.originFilename = originFilename;
    }
}
