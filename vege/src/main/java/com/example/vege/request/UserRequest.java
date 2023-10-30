package com.example.vege.request;


import com.example.vege.entity.status.MyRole;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRequest {

    private String email;
    private String name;
    private MyRole role;

    @Builder
    public UserRequest(String email, String name, String role) {
        this.email = email;
        this.name = name;
        this.role = MyRole.valueOf(role);
    }
}
