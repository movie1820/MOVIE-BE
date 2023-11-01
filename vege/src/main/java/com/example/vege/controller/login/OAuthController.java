package com.example.vege.controller.login;


import com.example.vege.jwt.oauth.OAuthTokens;
import com.example.vege.oauth.naver.NaverLoginParams;
import com.example.vege.service.login.OAuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OAuthController {

    private final OAuthServiceImpl oAuthService;

    @PostMapping("/api/auth/naver")
    public ResponseEntity<OAuthTokens> loginNaver(@RequestBody NaverLoginParams params) {
        return ResponseEntity.ok(oAuthService.login(params));
    }

}
