package com.example.vege.oauth.naver;


import com.example.vege.entity.status.OAuthProvider;
import com.example.vege.oauth.OAuthInfoResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class NaverInfoResponse implements OAuthInfoResponse {

    @JsonProperty("response")
    private Response response;

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Response{
        private String email;
        private String name;
    }


    @Override
    public String getEmail() {
        return response.email;
    }

    @Override
    public String getName() {
        return response.name;
    }

    @Override
    public OAuthProvider getOAuthProvider() {
        return OAuthProvider.NAVER;
    }

}
