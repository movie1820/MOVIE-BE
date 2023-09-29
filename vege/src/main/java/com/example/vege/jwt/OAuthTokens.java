package com.example.vege.jwt;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OAuthTokens {
    private String accessToken;
    private String refreshToken;
    private String grantType;
    private Long expiresIn;

    public OAuthTokens(String accessToken, String refreshToken, String grantType, Long expiresIn) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.grantType = grantType;
        this.expiresIn = expiresIn;
    }

    public static OAuthTokens of(String accessToken, String refreshToken, String grantType, Long expiresIn) {
        return new OAuthTokens(accessToken, refreshToken, grantType, expiresIn);
    }
}
