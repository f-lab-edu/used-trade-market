package com.flab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;

/**
 * 회원 관리 기능 구현 클래스
 *
 * @author 배영현
 * @version 1.0
 * */
public class MemberManager {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private MemberRepository memberRepository = new MemberRepository();

    /**
     * 회원 정보인 <code>member</code>를 통해 회원이 서비스를 이용할 수 있도록 가입을 할 수 있도록 한다.
     * 정상적으로 회원 가입이 된 경우 <code>true</code>를 반환한다.
     * @param member 회원 정보 입력
     * @return result 회원 가입 정상 Y/N
     * */
    public boolean registerMember(@Nullable Member member) {
        boolean result = false;
        if(memberRepository.registerMember(member)) {
            result = true;
        }

        logger.info("-------------------------");
        logger.info("Member join method");
        logger.debug("parameter : " + member);
        logger.info("-------------------------");

        return result;
    }

    /**
     * 회원만 사용할 수 있도록 체크하는 메서드
     * 회원 정보가 <code>member</code>인 객체를 확인하고 정보가 없으면 false를 반환하고 정보가 있으면 true를 반환한다.
     * @param member
     * @return result
     * */
    public boolean isRegistered(@Nullable Member member) {
        boolean result = true;
        logger.info("-------------------------");
        logger.info("isRegistered Method");
        logger.debug("parameter : " + member);
        logger.info("-------------------------");
        return result;
    }

    /**
     * 로그인 화면으로 보내는 메소드로 로그인 되어 있지 않은 경우에 호출되는 메소드
     * */
    public void goLogin() {
        logger.info("-------------------------");
        logger.info("Go login");
        logger.info("-------------------------");
    }

}
