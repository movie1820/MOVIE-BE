package com.example.vege.oauth;

import java.util.Map;

public interface OAuth2UserInfo {

    String getAccessToken();

    Map<String, Object> getAttributes();

    String getId();

    String getEmail();

    String getName();

    String getFirstName();

    String getLastName();

    String getNickname();

    String getProfileImageUrl();

}
