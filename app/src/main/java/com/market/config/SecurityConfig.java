package com.market.config;

import com.market.controller.MemberController;
import com.market.dto.MemberDTO;
import com.market.dto.fix.Role;
import com.market.service.CustomOAuth2UserService;
import com.market.service.MemberService;
import com.market.util.SessionUtil;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

/**
 * @author 배영현
 * Spring Security 관련 설정
 * */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    private final MemberService memberService;

    public SecurityConfig(CustomOAuth2UserService customOAuth2UserService, MemberService memberService) {
        this.customOAuth2UserService = customOAuth2UserService;
        this.memberService = memberService;
    }

    public AccessDecisionManager accessDecisionManager() {
        // admin도 user 권한에 접근할 수 있도록 hierarchy 설정
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_USER");

        // express handler
        DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
        handler.setRoleHierarchy(roleHierarchy);

        // Voter 설정
        WebExpressionVoter webExpressionVoter = new WebExpressionVoter();

        webExpressionVoter.setExpressionHandler(handler);
        List<AccessDecisionVoter<? extends  Object>> voters = Arrays.asList(webExpressionVoter);

        return new AffirmativeBased(voters);
    }

    /**
     * 정적 리소스에는 적용 안되도록 설정
     * */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .mvcMatchers("/member/**").hasRole(Role.ADMIN.name())
                .anyRequest().authenticated().accessDecisionManager(accessDecisionManager())
                .and()
                .formLogin().loginPage("/login")
                .successHandler(
                        new AuthenticationSuccessHandler() {
                            @Override
                            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                                MemberDTO member = memberService.findUserByUsername(authentication.getName());
                                SessionUtil.createSession(request.getSession(), member);
                            }
                        }
                )
                .and()
                .oauth2Login().loginPage("/login")
                .and()
                .logout().logoutSuccessUrl("/")
                .and()
                .oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);

    }
}
