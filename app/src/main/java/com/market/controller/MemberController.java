package com.market.controller;

import com.market.repository.MemberRepository;
import com.market.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * 회원 관리 기능 구현 클래스
 *
 * @author 배영현
 * @version 1.0
 * */
@Slf4j
public class MemberController {

    private MemberRepository memberRepository = new MemberRepository();

    /**
     * 회원 정보인 <code>member</code>를 통해 회원이 서비스를 이용할 수 있도록 가입을 할 수 있도록 한다.
     * @param member 회원 정보 입력
     * */
    public void registerMember(@Nonnull MemberDTO member) {
        if(member == null) {
            throw new NullPointerException();
        }
        memberRepository.registerMember(member);
        log.info("Member register method");
        log.debug("parameter : " , member);

        log.info("success register member");
    }

    /**
     * 회원만 사용할 수 있도록 체크하는 메서드
     * 회원 정보가 <code>member</code>인 객체를 확인하고 정보가 없으면 false를 반환하고 정보가 있으면 true를 반환한다.
     * @param member
     * @return result
     * */
    public boolean isRegistered(@Nullable MemberDTO member) {
        log.info("isRegistered Method");
        boolean result = true;

        if(member.getMemberNo() == null) {
            result = false;
        }

        return result;
    }

    /**
     * 로그인 화면으로 보내는 메소드로 로그인 되어 있지 않은 경우에 호출되는 메소드
     * */
    public void goLogin() {
        log.info("-------------------------");
        log.info("Go login");
        log.info("-------------------------");
    }

    /**
     * <code>memberNo</code>인 회원 정보를 갖는 회원을 회원 객체를 저장하는 <code>memberRepository</code>에서 갖고 오는 메소드
     * */
    public MemberDTO getMemberSelectOne(@Nonnull Long memberNo) {
        if(memberNo == null) {
            throw new NullPointerException();
        }
        return memberRepository.getMemberSelectOne(memberNo);
    }

    /**
     * <code>memberNo</code>의 회원번호와 <code>memberInfo</code>인 회원 정보를 갖는 회원의 정보를
     * <code>memberList</code>라는 회원 저장 map에 변경 내용을 저장하는 메소드
     * @param memberNo  회원번호
     * @param memberInfo    회원 정보
     * */
    public void updateMemberInfo(@Nonnull Long memberNo, @Nonnull MemberDTO memberInfo) {
        if(memberNo == null || memberInfo == null) {
            throw new NullPointerException();
        }
        memberRepository.updateMemberInfo(memberNo, memberInfo);
    }

}
