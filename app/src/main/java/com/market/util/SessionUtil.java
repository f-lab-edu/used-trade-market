package com.market.util;

import com.market.dto.MemberDTO;

import javax.servlet.http.HttpSession;

public class SessionUtil {

    public static void createSession(HttpSession session, MemberDTO member) {
        session.setAttribute("member", member);
    }

    public static MemberDTO getSession(HttpSession session) {
        return (MemberDTO)session.getAttribute("member");
    }
}
