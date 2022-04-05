package com.market.service.impl;

import com.market.dto.MemberDTO;
import com.market.repository.MemberRepository;
import com.market.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void registerMember(MemberDTO memberDTO) {
        memberRepository.registerMember(memberDTO);
    }

    @Override
    public Map<Long, MemberDTO> getMembers() {
        return memberRepository.getAllMember();
    }

    @Override
    public void updateMemberInfo(MemberDTO memberDTO) {
        Long memberNo = memberDTO.getMemberNo();
        memberRepository.updateMemberInfo(memberNo, memberDTO);
    }

    @Override
    public MemberDTO getMemberSelectOne(Long memberNo) {
        return memberRepository.getMemberSelectOne(memberNo);
    }
}
