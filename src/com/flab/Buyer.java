package com.flab;

import java.util.Date;

/**
 * 중고거래 구매자 상태 및 행위를 나타내는 클래스
 *
 * @author 배영현
 * @version 1.0
 *
 * */
public class Buyer {
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
     * 회사(중개자)
     * */
    private Company company;
    
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
        return result;
    }

    /**
     * 상품 번호가 <code>itemNo</code>인 상품의 상품 등록자 아이디를 통해 구매예정자와 판매자가 채팅할 수 있도록 채팅방을 오픈하는 메소드
     * <code>itemNo</code>가 <code>null</code>인 경우에는 NullPointException을 반환한다.
     * @param itemNo 상품 번호
     * */
    protected void sendMessage(String itemNo) {
    }

    /**
     * 상품번호가 <code>itemNo</code>인 상품의 구매 방법을 선택하는 메소드로 return 값이 0일 때는 택배배송,
     * 1일 경우 직거래로 정의한다.
     * <code>itemNo</code>가 <code>null</code>인 경우에 NullPointException을 반환한다.
     * @param itemNo 상품번호
     * */
    protected int selectServiceType(String itemNo) {
        int result = 0;
        return result;
    }

    /**
     * 구매자가 상품 번호가 <code>itemNo</code>인 상품의 거래방법을 택배 배송을 선택했을 때 사용하는 메소드
     * <code>itemNo</code>가 <code>null</code>인 경우에는 NullPointException을 반환한다.
     * @param itemNo 상품번호
     * return result  구매가 정상적으로 일어났는지 boolean 타입으로 확인
     * */
    protected boolean courierServiceBuy(String itemNo) {
        boolean result = false;

        sendMoneyBuyerToCompany(itemNo);
        delivery(itemNo);

        if(this.purchaseConfirmation(itemNo)) {
            // 들여쓰기 수정
            company.sendMoneyCompanyToSeller(itemNo);
            addPoint(itemNo);
        } else {
            company.sendMoneyCompanyToBuyer(itemNo);
        }
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
        sendMoneyBuyerToCompany(itemNo);

        if(this.purchaseConfirmation(itemNo)) {
            company.sendMoneyCompanyToSeller(itemNo);
            addPoint(itemNo);
        } else {
            company.sendMoneyCompanyToBuyer(itemNo);
        }
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
        if(autopurchaseConfirmation(itemNo)) {
            result = true;
        }
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
        return true;
    }
}
