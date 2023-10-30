package com.example.vege.controller;


import com.example.vege.jwt.OAuthTokens;
import com.example.vege.oauth.naver.NaverLoginParams;
import com.example.vege.service.OAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OAuthController {

    private final OAuthService oAuthService;

    @PostMapping("/api/auth/naver")
    public ResponseEntity<OAuthTokens> loginNaver(@RequestBody NaverLoginParams params) {
        return ResponseEntity.ok(oAuthService.login(params));
    }

}
