package com.market.controller;

import com.market.dto.MemberDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Collection;

@Controller
public class LogInOutController {

    @GetMapping("/login")
    public String loginForm() {
        return "/auth/oauth-login.html";
    }
    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }
}
