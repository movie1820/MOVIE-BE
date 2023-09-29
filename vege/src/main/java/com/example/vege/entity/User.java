package com.example.vege.entity;

import com.example.vege.entity.status.MyRole;
import com.example.vege.entity.status.OAuthProvider;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Builder
    public User(String email, String name, MyRole role, OAuthProvider oAuthProvider) {
        this.email = email;
        this.name = name;
        this.role = role;
        this.oAuthProvider = oAuthProvider;
    }
}
