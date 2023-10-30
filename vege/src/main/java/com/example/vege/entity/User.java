package com.example.vege.entity;

import com.example.vege.entity.status.MyRole;
import com.example.vege.entity.status.OAuthProvider;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String email;
    private String name;
    private MyRole role;
    private OAuthProvider oAuthProvider;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Attachment> attachments=new ArrayList<>();

    @Builder
    public User(String email, String name, MyRole role, OAuthProvider oAuthProvider) {
        this.email = email;
        this.name = name;
        this.role = role;
        this.oAuthProvider = oAuthProvider;
    }
}
