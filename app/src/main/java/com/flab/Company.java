package com.flab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 중개인 역할 클래스
 *
 * @author 배영현
 * @version 1.0
 * */
public class Company {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 구매확정 후 판매자에게 돈 지불하는 메소드로 <code>itemNo</code>인 상품을 찾아 금액을 확인 한 후 판매자에게 돈을 지불한다.
     * @param itemNo 상품 번호
     * @return result 정상 지급 Y/N
     * */
    protected boolean sendMoneyCompanyToSeller(Long itemNo) {
        boolean result = false;
        logger.info("----------------------");
        logger.info("sendMoneyCompanyToSeller method");
        logger.debug("parameter itemNo : " + itemNo);
        logger.info("----------------------");
        return result;
    }

    /**
     * 구매취소 후 구매자에게 돈을 환급하는 메소드로 <code>itemNo</code>인 상품의 금액을 찾아고 구매자의 정보를 찾은 후 구매자에게 돈을 환급한다
     * <code>itemNo</code>가 <code>null</code>인 경우 NullPointException을 반환한다.
     * @param itemNo 상품 번호
     * @return result  정상 환급 Y/N
     * */
    protected boolean sendMoneyCompanyToBuyer(Long itemNo) {
        boolean result = false;
        logger.info("----------------------");
        logger.info("sendMoneyCompanyToBuyer method");
        logger.debug("parameter itemNo : " + itemNo);
        logger.info("----------------------");
        return result;
    }
}
