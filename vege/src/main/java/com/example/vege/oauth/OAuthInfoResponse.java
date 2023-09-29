package com.example.vege.oauth;


import com.example.vege.entity.status.OAuthProvider;

public interface OAuthInfoResponse {
    String getEmail();
    String getName();
    OAuthProvider getOAuthProvider();
}
