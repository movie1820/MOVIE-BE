package com.example.vege.service.login;

import com.example.vege.jwt.oauth.OAuthTokens;
import com.example.vege.oauth.OAuthLoginParams;

public interface OAuthService {
    OAuthTokens login(OAuthLoginParams params);
}
