package com.flab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * 중고거래 구매자 상태 및 행위를 나타내는 클래스
 *
 * @author 배영현
 * @version 1.0
 *
 * */
public class Buyer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 택배 배송지
     * */
    private String shippingAddress;

    /** 
     * 택배 배송시 요청사항 번호
     * */
    private int requestmentNo;
    
    /** 
     * 번개포인트
     * */
    private int point;
    
    /** 
     * 결제금액
     * */ 
    private int payMoney;
    
    /**
     * 구매일자
     * */
    private Date buydate;

    /**
     * 상품 번호가 <code>itemNo</code>인 상품의 상품 등록자 아이디를 통해 구매예정자와 판매자가 채팅할 수 있도록 채팅방을 오픈하는 메소드
     * <code>itemNo</code>가 <code>null</code>인 경우에는 NullPointException을 반환한다.
     * @param itemNo 상품 번호
     * */
    protected void sendMessage(Long itemNo) {
        System.out.println("연락하기 채팅방 미구현");
        logger.info("-------------------");
        logger.info("sendMessage method");
        logger.debug("parameter itemNo : " + itemNo);
        logger.info("-------------------");
    }

    /**
     * 구매자가 구매 확정버튼을 3일간 누르지 않으면 자동 구매 확정
     * <code>itemNo</code>가 <code>null</code>인 경우에는 NullPointException을 반환한다.
     * @param itemNo 상품번호
     * @return result  자동 구매확정 Y/N
     * */
    protected boolean autopurchaseConfirmation(Long itemNo) {
        boolean result=  true;
        logger.info("----------------------");
        logger.info("autopurchaseConfirmation method");
        logger.debug("parameter itemNo : " + itemNo);
        logger.info("----------------------");
        return true;
    }

    /**
     * selectDealType 구매자가 거래 방법을 선택하는 메소드로 <code>dealType</code>을 통해 직거래인지 택배배송인지 체크하여 반환한다.
     * <code>dealType</code>이 <code>null</code>인 경우에는 NullPointException을 반환한다.
     * */
    protected String selectDealType(String dealType) {
        logger.info("----------------------");
        logger.info("selectDealType method");
        logger.debug("parameter dealType : " + dealType);
        logger.info("----------------------");
        return dealType;
    }
}
