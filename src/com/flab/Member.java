package com.flab;
/**
 * 회원 일반 기능 정의 클래스
 *
 * @author 배영현
 * @version 1.0
 * */
public class Member {
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

    /**
     * 비로그인 시 로그인 화면으로 보내는 메소드
     * @param member 멤버 정보
     * */
    public void goLogin(Member member) {
    }

    /**
     * 회원가입 메소드
     * @param member 회원 정보 입력
     * @return result 회원 가입 정상 Y/N
     * */
    public boolean join(Member member) {
        boolean result = false;
        return result;
    }

    /**
     * 회원 추천 상품 목록 보기
     * @param member 회원 정보
     * */
    public void recommendList(Member member) {
    }

    /**
     * 상품 목록 보는 메소드
     * @param item 상품 카테고리 체크를 위해
     * */
    public void viewItemList(Item item) {
    }
}
