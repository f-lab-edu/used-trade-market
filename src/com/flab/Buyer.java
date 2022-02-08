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
     * 원하는 물건을 찜하는 메소드
     * @param itemNo 상품 번호
     * @return 찜이 정상적으로 됐는지 안됐는지 boolean 타입
     *
     * */
    protected boolean zzim(String itemNo) {
        boolean result = false;
        return result;
    }

    /**
     * 구매예정자와 판매자가 채팅할 수 있도록 채팅방을 오픈하는 메소드
     * @param itemNo 상품 번호
     * */
    protected void sendMessage(String itemNo) {

    }

    /**
     * 구매자가 직거래가 아닌 택배 배송을 선택했을 때 사용하는 메소드
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
     * 구매자가 직거래를 선택했을 때 사용하는 메소드
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
     * 구매예정자가 상품 구매 후 구매를 확정하는지 확인하는 메소드
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
     * 구매자 -> 중계자에게 비용 지급하는 메소드
     * @param itemNo 상품번호
     * @return result 비용 정상 지급 Y/N
     * */
    protected boolean sendMoneyBuyerToCompany(String itemNo) {
        boolean result = false;
        return result;
    }

    /**
     * 구매자에게 포인트 지급
     * @param itemNo 상품번호
     * @return 포인트 정상 지급 Y/N
     * */
    protected boolean addPoint(String itemNo) {
        boolean result = false;
        return result;
    }

    /**
     * 상품 배송 메소드
     * @param itemNo 상품번호
     * @return result 정상배송 Y/N
     * */
    protected boolean delivery(String itemNo) {
        boolean result = false;
        return result;
    }

    /**
     * 구매자가 구매 확정버튼을 3일간 누르지 않으면 자동 구매 확정
     * @param itemNo 상품번호
     * @return result  자동 구매확정 Y/N
     * */
    protected boolean autopurchaseConfirmation(String itemNo) {
        boolean result=  true;
        return true;
    }
}
