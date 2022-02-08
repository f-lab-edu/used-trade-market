package com.flab;

/**
 * 중개인 역할 클래스
 *
 * @author 배영현
 * @version 1.0
 * */
public class Company {
    /**
     * 구매확정 후 판매자에게 돈 지불하는 메소드
     * @param itemNo 상품 번호
     * @return result 정상 지급 Y/N
     * */
    protected boolean sendMoneyCompanyToSeller(String itemNo) {
        boolean result = false;
        return result;
    }

    /**
     * 구매취소 후 구매자에게 돈 환급
     * @param itemNo 상품 번호
     * @return result  정상 환급 Y/N
     * */
    protected boolean sendMoneyCompanyToBuyer(String itemNo) {
        boolean result = false;
        return result;
    }
}
