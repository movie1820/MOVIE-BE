package com.example.vege.oauth.naver;

import com.example.vege.oauth.OAuth2UserInfo;

import java.util.Map;

public class NaverOAuth2UserInfo implements OAuth2UserInfo {

    private final Map<String, Object> attributes;
    private final String accessToken;
    private final String id;
    private final String email;
    private final String name;
    private final String firstName;
    private final String lastName;
    private final String nickName;
    private final String profileImageUrl;

    public NaverOAuth2UserInfo(String accessToken, Map<String, Object> attributes) {
        this.accessToken = accessToken;
        // attributes 맵의 response 키의 값에 실제 attributes 맵이 할당되어 있음
        this.attributes = (Map<String, Object>) attributes.get("response");
        this.id = (String) this.attributes.get("id");
        this.email = (String) this.attributes.get("email");
        this.name = (String) this.attributes.get("name");
        this.firstName = null;
        this.lastName = null;
        this.nickName = (String) attributes.get("nickname");
        this.profileImageUrl = (String) attributes.get("profile_image");
    }

    @Override
    public String getAccessToken() {
        return null;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public String getNickname() {
        return null;
    }

    @Override
    public String getProfileImageUrl() {
        return null;
    }
}
