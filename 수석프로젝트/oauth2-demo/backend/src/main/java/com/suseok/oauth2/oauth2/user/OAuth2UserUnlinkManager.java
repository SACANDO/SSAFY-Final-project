package com.suseok.oauth2.oauth2.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.suseok.oauth2.oauth2.exception.OAuth2AuthenticationProcessingException;

@RequiredArgsConstructor
@Component
public class OAuth2UserUnlinkManager {

    private GoogleOAuth2UserUnlink googleOAuth2UserUnlink;
    private KakaoOAuth2UserUnlink kakaoOAuth2UserUnlink;
    private NaverOAuth2UserUnlink naverOAuth2UserUnlink;

    public void unlink(OAuth2Provider provider, String accessToken) {
        if (OAuth2Provider.GOOGLE.equals(provider)) {
            googleOAuth2UserUnlink.unlink(accessToken);
        } else if (OAuth2Provider.NAVER.equals(provider)) {
            naverOAuth2UserUnlink.unlink(accessToken);
        } else if (OAuth2Provider.KAKAO.equals(provider)) {
            kakaoOAuth2UserUnlink.unlink(accessToken);
        } else {
            throw new OAuth2AuthenticationProcessingException(
                    "Unlink with " + provider.getRegistrationId() + " is not supported");
        }
    }
}
