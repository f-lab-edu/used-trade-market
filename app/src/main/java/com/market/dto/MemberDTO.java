package com.market.dto;

import lombok.Getter;
import lombok.Setter;
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
@Getter @Setter
public class MemberDTO {

    /**
     * 회원 번호
     * */
    private Long memberNo;

    /**
     * 회원 아이디
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
     * 포인트
     * */
    private int point;


    @Override
    public String toString() {
        return "Member{" +
                "memberNo=" + memberNo +
                ", memberId='" + memberId + '\'' +
                ", memberPassword='" + memberPassword + '\'' +
                ", memberName='" + memberName + '\'' +
                ", point=" + point +
                '}';
    }
}
