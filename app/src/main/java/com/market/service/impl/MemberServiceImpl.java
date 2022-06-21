package com.market.service.impl;

import com.market.dao.MemberDAO;
import com.market.dto.MemberDTO;
import com.market.repository.MemberRepository;
import com.market.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService, UserDetailsService {

    @Autowired
    private MemberDAO memberDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        MemberDTO member = memberDAO.findByMemberId(userId);
        if(member == null) {
            throw new UsernameNotFoundException(userId);
        }

        return User.builder()
                .username(member.getMemberId())
                .password(member.getMemberPassword())
                .roles(member.getMemberRole())
                .build();
    }

    @Override
    public MemberDTO findUserByUsername(String userId) {
        return memberDAO.findByMemberId(userId);
    }

    @Override
    public void registerMember(MemberDTO memberDTO) {
        memberDTO.encodePassword(passwordEncoder);
        memberDAO.registerMember(memberDTO);
    }

    @Override
    public List<MemberDTO> getMembers() {
        return memberDAO.getAllMember();
    }

    @Override
    public void updateMemberInfo(MemberDTO memberDTO) {
        Long memberNo = memberDTO.getMemberNo();
        memberDAO.updateMemberInfo(memberDTO);
    }

    @Override
    public MemberDTO getMemberSelectOne(Long memberNo) {
        return memberDAO.getMemberSelectOne(memberNo);
    }

    @Override
    public void deleteMember(Long memberNo) {
        memberDAO.deleteMember(memberNo);
    }
}
