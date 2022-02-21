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
     * 상품 번호가 <code>itemNo</code>인 상품을 찜 리스트에 추가한다.
     * 정상적으로 찜리스트에 추가된 경우에는 <code>true</code>를 반환한다. 이미 찜리스트에 있는 경우에는 중복되어 추가되지 않고 <code>true</code>를 반환한다.
     * <code>itemNo</code>가 <code>null</code>인 경우에는 NullPointException을 반환한다.
     * @param itemNo 상품 번호
     * @return 찜이 정상적으로 됐는지 안됐는지 boolean 타입
     *
     * */
    protected boolean zzim(String itemNo) {
        boolean result = false;
        logger.info("----------------");
        logger.info("zzim method");
        logger.debug("parameter itemNo : " + itemNo);
        logger.info("----------------");
        return result;
    }

    /**
     * 상품 번호가 <code>itemNo</code>인 상품의 상품 등록자 아이디를 통해 구매예정자와 판매자가 채팅할 수 있도록 채팅방을 오픈하는 메소드
     * <code>itemNo</code>가 <code>null</code>인 경우에는 NullPointException을 반환한다.
     * @param itemNo 상품 번호
     * */
    protected void sendMessage(String itemNo) {
        logger.info("-------------------");
        logger.info("sendMessage method");
        logger.debug("parameter itemNo : " + itemNo);
        logger.info("-------------------");
    }

    /**
     * 구매자가 상품 번호가 <code>itemNo</code>인 상품의 거래방법을 택배 배송을 선택했을 때 사용하는 메소드
     * <code>itemNo</code>가 <code>null</code>인 경우에는 NullPointException을 반환한다.
     * @param itemNo 상품번호
     * return result  구매가 정상적으로 일어났는지 boolean 타입으로 확인
     * */
    protected boolean courierServiceBuy(String itemNo) {
        boolean result = false;
        logger.info("----------------------");

        Company company = new Company();
        sendMoneyBuyerToCompany(itemNo);
        delivery(itemNo);

        if(this.purchaseConfirmation(itemNo)) {
            company.sendMoneyCompanyToSeller(itemNo);
            addPoint(itemNo);
        } else {
            company.sendMoneyCompanyToBuyer(itemNo);
        }
        logger.info("----------------------");
        return result;

    }

    /**
     * 구매자가 상품 번호가 <code>itemNo</code>인 상품의 거래방법을 직거래를 선택했을 때 사용하는 메소드로 거래방법
     * <code>itemNo</code>가 <code>null</code>인 경우에는 NullPointException을 반환한다.
     * @param itemNo 상품번호
     * return result  구매가 정상적으로 일어났는지 boolean 타입으로 확인
     * */
    protected boolean directTransaction(String itemNo) {
        boolean result = false;
        logger.info("----------------------");
        logger.info("directTransaction method");
        logger.debug("parameter itemNo : " + itemNo);
        sendMoneyBuyerToCompany(itemNo);

        Company company = new Company();

        if(this.purchaseConfirmation(itemNo)) {
            company.sendMoneyCompanyToSeller(itemNo);
            addPoint(itemNo);
        } else {
            company.sendMoneyCompanyToBuyer(itemNo);
        }
        logger.info("----------------------");
        return result;
    }

    /**
     * 상품 번호가 <code>itemNo</code>인 상품에 대해 구매자가 상품 구매 후 문제가 없다면 구매를 확정하는지 확인하는 메소드로
     * 구매 확정 상태가 변경된다.
     * <code>itemNo</code>가 <code>null</code>인 경우에는 NullPointException을 반환한다.
     * @param itemNo 상품번호
     * @return result 구매확정 Y/N
     * */
    protected boolean purchaseConfirmation(String itemNo) {
        boolean result = false;
        logger.info("----------------------");
        logger.info("purchaseConfirmation method");
        logger.debug("parameter itemNo : " + itemNo);
        if(autopurchaseConfirmation(itemNo)) {
            result = true;
        }
        logger.info("----------------------");
        return result;
    }

    /**
     * 상품 번호가 <code>itemNo</code>인 상품을 구매자가 구입 후 구매 확정이 되기 전 구매자가 중계자에게 비용을 맡기는 기능을 하는 메소드
     * <code>itemNo</code>가 <code>null</code>인 경우에는 NullPointException을 반환한다.
     * @param itemNo 상품번호
     * @return result 비용 정상 지급 Y/N
     * */
    protected boolean sendMoneyBuyerToCompany(String itemNo) {
        boolean result = false;
        logger.info("----------------------");
        logger.info("sendMoneyBuyerToCompany method");
        logger.debug("parameter itemNo : " + itemNo);
        logger.info("----------------------");
        return result;
    }

    /**
     * 상품 번호가 <code>itemNo</code>인 상품에 대한 포인트를 구매자에게 지급하는 메소드
     * <code>itemNo</code>가 <code>null</code>인 경우에는 NullPointException을 반환한다.
     * @param itemNo 상품번호
     * @return 포인트 정상 지급 Y/N
     * */
    protected boolean addPoint(String itemNo) {
        boolean result = false;
        logger.info("----------------------");
        logger.info("addPoint Method");
        logger.debug("parameter itemNo : " + itemNo);
        logger.info("----------------------");
        return result;
    }

    /**
     * 상품 배송 메소드
     * <code>itemNo</code>가 <code>null</code>인 경우에는 NullPointException을 반환한다.
     * @param itemNo 상품번호
     * @return result 정상배송 Y/N
     * */
    protected boolean delivery(String itemNo) {
        boolean result = false;
        return result;
    }

    /**
     * 구매자가 구매 확정버튼을 3일간 누르지 않으면 자동 구매 확정
     * <code>itemNo</code>가 <code>null</code>인 경우에는 NullPointException을 반환한다.
     * @param itemNo 상품번호
     * @return result  자동 구매확정 Y/N
     * */
    protected boolean autopurchaseConfirmation(String itemNo) {
        boolean result=  true;
        logger.info("----------------------");
        logger.info("autopurchaseConfirmation method");
        logger.debug("parameter itemNo : " + itemNo);
        logger.info("----------------------");
        return true;
    }

    /**
     * 사용자가 선택한 상품의 정보를 갖고 오는 메소드로 <code>itemNo</code>인 상품 번호를 파라미터로 받아 상품 정보를 갖고오는 메소드
     * <code>itemNo</code>가 <code>null</code>인 경우에는 NullPointException을 반환한다.
     * @param itemNo 상품번호
     * */
    protected Item selectItem(String itemNo) {
        logger.info("-------------------");
        logger.info("selectItem method");
        logger.debug("parameter itemNo : " + itemNo);
        logger.info("-------------------");
        return new Item(itemNo);
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

    /**
     * <code>dealType</code>는 거래 방법을 의미하는 파라미터로 해당 파라미터를 통해 직거래이면 <code>true</code> 직거래가 아니라 택배거래이면
     * <code>false</code>를 반환한다.
     * <code>dealType</code>이 없으면 NullPointException을 반환한다.
     * @param dealType
     * return result
     * */
    protected boolean isDirectTransaction(String dealType) {
        boolean result = false;
        logger.info("----------------------");
        logger.info("isDirectTransaction method");
        logger.debug("parameter dealType : " + dealType);
        logger.info("----------------------");
        return result;
    }
}
