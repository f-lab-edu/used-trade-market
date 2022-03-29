package com.market.dto;

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
public class MemberDTO {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

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
     * 회원 유형
     * */
    private String memberType;

    /**
     * 포인트
     * */
    private int point;

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public Long getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Long memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberNo=" + memberNo +
                ", memberId='" + memberId + '\'' +
                ", memberPassword='" + memberPassword + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberType='" + memberType + '\'' +
                ", point=" + point +
                '}';
    }
}
