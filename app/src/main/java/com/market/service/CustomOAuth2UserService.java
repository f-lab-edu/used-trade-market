package com.market.service;

import com.market.dto.OAuthAttributes;
import com.market.dao.MemberDAO;
import com.market.dto.MemberDTO;
import com.market.util.SessionUtil;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private final MemberDAO memberDAO;
    private final HttpSession httpSession;

    public CustomOAuth2UserService(MemberDAO memberDAO, HttpSession httpSession) {
        this.memberDAO = memberDAO;
        this.httpSession = httpSession;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        // 현재 로그인 진행 중 서비스 확인
        String registrationId = userRequest
                .getClientRegistration()
                .getRegistrationId();

        // OAuth2 로그인 진행 시 키 필드값값
       String userNameAttributeName = userRequest
                .getClientRegistration()
                .getProviderDetails()
                .getUserInfoEndpoint()
                .getUserNameAttributeName();

       // OAuth2User 객체 저장
        OAuthAttributes attributes = OAuthAttributes
                .of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

        MemberDTO user = memberDAO.findByMemberEmail(attributes.getEmail());
        SessionUtil.createSession(httpSession, user);
        return new DefaultOAuth2User(
                Collections.singleton(
                        new SimpleGrantedAuthority(user.getMemberRole())
                ),
                attributes.getAttributes(),
                attributes.getNameAttributeKey()
        );
    }

}
