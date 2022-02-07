package com.flab;

import java.util.Date;

/**
 * 구매자
 * */
public class Buyer {
    //  택배 배송지
    private String shippingAddress;
    // 택배 배송시 요청사항 번호
    private int requestmentNo;
    // 번개포인트
    private int point;
    //  결제금액
    private int payMoney;
    // 회사(중개자)
    private Company company;
    // 구매일자
    private Date buydate;

    // 찜하기
    protected void zzim(String itemNo) {

    }

    // 채팅방 오픈
    protected void sendMessage(String itemNo) {

    }

    // 택배배송
    protected void courierServiceBuy(String itemNo) {
        sendMoneyBuyerToCompany();
        delivery();

        if(this.purchaseConfirmation(itemNo)) {
               company.sendMoneyCompanyToSeller();
               addPoint();
        } else {
            company.sendMoneyCompanyToBuyer();
        }
    }

    // 직거래
    protected void directTransaction(String itemNo) {
        sendMoneyBuyerToCompany();

        if(this.purchaseConfirmation(itemNo)) {
            company.sendMoneyCompanyToSeller();
            addPoint();
        } else {
            company.sendMoneyCompanyToBuyer();
        }
    }

    // 구매확정
    protected boolean purchaseConfirmation(String itemNo) {
        boolean result = false;
        if(autopurchaseConfirmation()) {
            result = true;
        }
        return result;
    }

    // 구매자 -> 중개자에게 비용 지급
    protected void sendMoneyBuyerToCompany() {
    }

    // 포인트 지급
    protected void addPoint() {
    }

    // 배송
    protected void delivery() {
    }

    // 구매 후 3일 지나면 자동 구매확정 체크
    protected boolean autopurchaseConfirmation() {
        boolean result=  true;

        return true;
    }


}
