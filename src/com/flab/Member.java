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

    /**
     * 로그인 화면으로 보내는 메소드로 로그인 되어 있지 않은 경우에 호출되는 메소드
     * */
    public void goLogin() {
        logger.info("-------------------------");
        logger.info("Go login");
        logger.info("-------------------------");
    }

    /**
     * 회원 정보인 <code>member</code>를 통해 회원이 서비스를 이용할 수 있도록 가입을 할 수 있도록 한다.
     * <code>member</code>가 <code>null</code>인 경우에는 NullPointException을 반환한다.
     * 정상적으로 회원 가입이 된 경우 <code>true</code>를 반환한다.
     * @param member 회원 정보 입력
     * @return result 회원 가입 정상 Y/N
     * */
    public boolean join(Member member) {
        boolean result = false;

        logger.info("-------------------------");
        logger.info("Member join method");
        logger.debug("parameter : " + member);
        logger.info("-------------------------");

        return result;
    }

    /**
     * 회원 정보가 <code>member</code>인 사용자를 통해 추천 상품 리스트를 나열해 보여준다.
     * <code>member</code>가 <code>null</code>인 경우에는 NullPointException을 반환한다.
     * @param member 회원 정보
     * */
    public List<Item> recommendList(Member member) {

        logger.info("-------------------------");
        logger.info("Item recommendList");
        logger.debug("parameter member : " + member);
        logger.info("return List");
        logger.info("-------------------------");

        return new ArrayList<Item>();
    }

    /**
     * 상품 목록을 보여주는 메서드로 <code>item</code>을 받아 item의 카테고리 정보를 통해 상품을 보여준다.
     * ArrayList로 상품 정보를 담아 반환한다.
     * <code>item</code>이 <code>null</code>인 경우에는 NullPointException을 반환한다.
     * @param item 상품 카테고리 체크를 위해
     * @return ArrayList<Item>
     * */
    public List<Item> viewItemList(Item item) {
        logger.info("-------------------------");
        logger.info("Item viewItemList");
        logger.debug("parameter Item(category) : " + item);
        logger.info("return List");
        logger.info("-------------------------");
        return new ArrayList<Item>();
    }

    /**
     * 회원 정보가 <code>member</code>인 객체를 확인하고 정보가 없으면 false를 반환하고 정보가 있으면 true를 반환한다.
     * 회원만 사용할 수 있도록 체크하는 메서드
     * @param member
     * @return result
     * */
    public boolean isRegistered(Member member) {
        boolean result = true;
        logger.info("-------------------------");
        logger.info("isRegistered Method");
        logger.debug("parameter : " + member);
        logger.info("-------------------------");
        return result;
    }
}
