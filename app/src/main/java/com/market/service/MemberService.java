package com.market.service;

import com.market.dto.MemberDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {

    // 회원가입
    public void registerMember(MemberDTO memberDTO);

    // 모든 회원 정보 조회
    public List<MemberDTO> getMembers();

    // 회원 정보 수정
    public void updateMemberInfo(MemberDTO memberDTO);

    // 회원 한명 정보 반환
    public MemberDTO getMemberSelectOne(Long memberNo);

    // 회원 삭제
    public void deleteMember(Long memberNo);

}
