package com.market.util;

import com.market.dto.MemberDTO;

import javax.servlet.http.HttpSession;

public class SessionUtil {

    public static final String LOGIN_MEMBER = "loginMember";

    /**
     * 세션이 있으면 세션 반환, 없으면 신규 세션을 생성
     * */
    public static void createSession(HttpSession session, MemberDTO loginMember) {
        session.setAttribute(LOGIN_MEMBER, loginMember);
    }

    /** 
     * 세션 모두 제거
     * */
    public static void clearSession(HttpSession session) {
        session.invalidate();
    }

    /** 
     * 로그인 한 회원의 정보를 없앤다
     * */
    public static void deleteSession(HttpSession session) {
        session.removeAttribute(LOGIN_MEMBER);
    }

    /**
     * 세션에 담긴 회원 정보를 반환한다.
     * */
    public static MemberDTO getSession(HttpSession session) {
        return (MemberDTO)session.getAttribute(LOGIN_MEMBER);
    }
}
