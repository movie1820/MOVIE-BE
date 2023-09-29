package com.example.vege.oauth.naver;


import com.example.vege.entity.status.OAuthProvider;
import com.example.vege.oauth.OAuthLoginParams;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class NaverLoginParams implements OAuthLoginParams {

    private String authorizationCode;
    private String state;

    @Override
    public OAuthProvider oAuthProvider() {
        return OAuthProvider.NAVER;
    }

    @Override
    public MultiValueMap<String, String> makeBody() {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("code", authorizationCode);
        body.add("state", state);
        return body;
    }
}
