package com.flab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 판매자 기능 나열 클래스
 *
 * @author 배영현
 * @version 1.0
 * */
public class Seller {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * <code>item</code>인 상품을 등록하는 메소드
     * <code>item</code>이 <code>null</code>인 경우 NullPointException을 반환한다.
     * @param item 상품정보
     * @return result  정상 등록 여부 Y/N
     * */
    public boolean register(Item item) {
        boolean result = false;

        logger.info("-----------------");
        logger.info("register method");
        logger.debug("parameter item" + item.toString());
        logger.info("-----------------");

        return result;
    }
}
