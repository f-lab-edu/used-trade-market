package com.market.dao;

import com.market.dto.MemberDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberDAO {

    void registerMember(MemberDTO memberDTO);

    List<MemberDTO> getAllMember();

    void updateMemberInfo(MemberDTO memberDTO);

    MemberDTO getMemberSelectOne(Long memberNo);

    void deleteMember(Long memberNo);

    MemberDTO findByUserId(String userId);
}
