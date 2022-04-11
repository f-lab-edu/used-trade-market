package com.market.service.impl;

import com.market.dao.MemberDAO;
import com.market.dto.MemberDTO;
import com.market.repository.MemberRepository;
import com.market.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDAO memberDAO;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void registerMember(MemberDTO memberDTO) {
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
