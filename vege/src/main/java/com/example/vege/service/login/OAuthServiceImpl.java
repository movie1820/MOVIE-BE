package com.example.vege.service.login;

import com.example.vege.entity.User;
import com.example.vege.jwt.oauth.OAuthTokens;
import com.example.vege.jwt.oauth.OAuthTokensGenerator;
import com.example.vege.oauth.OAuthInfoResponse;
import com.example.vege.oauth.OAuthLoginParams;
import com.example.vege.oauth.RequestOAuthInfoService;
import com.example.vege.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuthServiceImpl implements OAuthService{

    private final UserRepository userRepository;
    private final OAuthTokensGenerator oAuthTokensGenerator;
    private final RequestOAuthInfoService requestOAuthInfoService;

    @Override
    public OAuthTokens login(OAuthLoginParams params) {
        OAuthInfoResponse oAuthInfoResponse = requestOAuthInfoService.request(params);
        Long memberId = findOrCreateMember(oAuthInfoResponse);
        return oAuthTokensGenerator.generate(memberId);
    }

    private Long findOrCreateMember(OAuthInfoResponse oAuthInfoResponse) {
        return userRepository.findByEmail(oAuthInfoResponse.getEmail())
                .map(User::getUserId)
                .orElseGet(() -> newMember(oAuthInfoResponse));
    }

    private Long newMember(OAuthInfoResponse oAuthInfoResponse) {
        User user = User.builder()
                .email(oAuthInfoResponse.getEmail())
                .name(oAuthInfoResponse.getName())
                .oAuthProvider(oAuthInfoResponse.getOAuthProvider())
                .build();

        return userRepository.save(user).getUserId();
    }
}
