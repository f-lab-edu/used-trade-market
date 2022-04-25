package com.market.dao.impl;

import com.market.dao.MemberDAO;
import com.market.dto.MemberDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberDAOImpl implements MemberDAO {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public void registerMember(MemberDTO memberDTO) {
        sqlSession.insert("registerMember", memberDTO);
    }

    @Override
    public List<MemberDTO> getAllMember() {
        return sqlSession.selectList("getAllMember");
    }

    @Override
    public MemberDTO getMemberSelectOne(Long memberNo) {
        return sqlSession.selectOne("getMemberSelectOne", memberNo);
    }

    @Override
    public void updateMemberInfo(MemberDTO memberDTO) {
        sqlSession.update("updateMemberInfo", memberDTO);
    }

    @Override
    public void deleteMember(Long memberNo) {
        sqlSession.delete("deleteMember", memberNo);
    }

    @Override
    public MemberDTO findByUserId(String userId) {
        return sqlSession.selectOne("findByUserId",userId);
    }
}
