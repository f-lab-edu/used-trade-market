package com.market.service;

import com.market.dto.MemberDTO;

import java.util.Map;

public interface MemberService {

    // 회원가입
    public void registerMember(MemberDTO memberDTO);

    // 모든 회원 정보 조회
    public Map<Long, MemberDTO> getMembers();

    // 회원 정보 수정
    public void updateMemberInfo(MemberDTO memberDTO);

    // 회원 한명 정보 반환
    public MemberDTO getMemberSelectOne(Long memberNo);
}
