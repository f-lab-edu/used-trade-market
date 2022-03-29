package com.market.dto.fix;
/**
 * 거래 방법 종류 enum 클래스
 *
 * @author 배영현
 * @version 1.0
 * */
public enum DealType {
    /**
     * <code>directTransaction</code>은 직거래를 나타내며 코드 1을 반환한다.
     * <code>courierServiceBuy</code>는 택배거래를 나타내며 코드 2를 반환한다.
     * */
    directTransaction(1), courierServiceBuy(2);

    private final int dealTypeCode;

    DealType(int dealTypeCode) {
        this.dealTypeCode = dealTypeCode;
    }
    public int getDealTypeCode() {
        return dealTypeCode;
    }
}
