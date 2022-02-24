package com.flab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 회원 일반 기능 정의 클래스
 *
 * @author 배영현
 * @version 1.0
 * */
public class Member {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 회원 번호
     * */
    private String memberId;

    /**
     * 회원 비밀번호
     * */
    private String memberPassword;

    /**
     * 회원 이름
     * */
    private String memberName;

    /**
     * 회원 유형
     * */
    private String memberType;

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", memberPassword='" + memberPassword + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberType='" + memberType + '\'' +
                '}';
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
