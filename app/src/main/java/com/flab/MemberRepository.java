package com.flab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 배영현
 * @version 1.0
 *
 * 회원 정보를 저장하는 클래스
 * */
public class MemberRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 회원들을 저장할 HashMap
     * */
    private static Map<Long, Member> memberList = new HashMap<>();

    /**
     * 맵의 Key값 1씩 증가
     * */
    private static long key = 0L;

    /**
     * <code>member</code>인 회원을 회원 저장소 <code>memberList</code>에 저장한다.
     * <code>key</code>는 회원 번호를 나타내며 <code>key</code>는 1씩 증가해서 저장될 수 있도록 한다.
     * */
    protected boolean addMember(@Nullable Member member) {
        boolean result = false;

        member.setMemberNo(++key);
        logger.info(key + "add Member");
        memberList.put(key, member);
        logger.info("add member info");
        logger.info(memberList.get(key).toString());
        result = true;

        return result;
    }

    /**
     * 입력한 <code>memberId</code>를 토대로 회원 정보를 갖고 오는 메서드
     * */
    protected Member searchMember(Long key) {
        return memberList.get(key);
    }

    protected Map<Long, Member> getMember() {
        return memberList;
    }


}
