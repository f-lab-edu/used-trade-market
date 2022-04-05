package com.market.repository;

import com.market.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 배영현
 * @version 1.0
 *
 * 회원 정보를 저장하는 클래스
 * */
@Slf4j
@Repository
public class MemberRepository {

    /**
     * 회원들을 저장할 HashMap
     * */
    private static Map<Long, MemberDTO> memberList = new HashMap<>();

    /**
     * 맵의 Key값 1씩 증가
     * */
    private static long key = 0L;

    /**
     * <code>member</code>인 회원을 회원 저장소 <code>memberList</code>에 저장한다.
     * <code>key</code>는 회원 번호를 나타내며 <code>key</code>는 1씩 증가해서 저장될 수 있도록 한다.
     * */
    public void registerMember(@Nullable MemberDTO member) {
        if(member == null) {
            throw new NullPointerException();
        }
        member.setMemberNo(++key);
        log.info("add Member : {}", key);
        memberList.put(key, member);
        log.info("add member info : {}", memberList.get(key));

    }

    /**
     * 입력한 <code>memberNo</code>를 토대로 회원 정보를 갖고 오는 메서드
     * */
    public MemberDTO getMemberSelectOne(@Nullable Long memberNo) {
        return memberList.get(memberNo);
    }

    /**
     * 모든 사용자 정보를 담고 있는  <code>memerList</code>에서 모든 정보를 반환한다.
     * */
    public Map<Long, MemberDTO> getAllMember() {
        return memberList;
    }

    /**
     * <code>memberNo</code>의 회원번호와 <code>memberInfo</code>인 회원 정보를 갖는 회원의 정보를
     * <code>memberList</code>라는 회원 저장 map에 변경 내용을 저장하는 메소드
     * @param memberNo  회원번호
     * @param memberInfo    회원 정보
     * */
    public void updateMemberInfo(@Nonnull Long memberNo, @Nonnull MemberDTO memberInfo) {
        memberList.put(memberNo, memberInfo);
    }

}
