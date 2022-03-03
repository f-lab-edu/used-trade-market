package com.flab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/** 
 * 상품 관리 기능 클래스
 * 
 * @author 배영현
 * @version 1.0
 *
 * */
public class ItemManager {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 회원 정보가 <code>member</code>인 사용자를 통해 추천 상품 리스트를 나열해 보여준다.
     * <code>member</code>가 <code>null</code>인 경우에는 NullPointException을 반환한다.
     * @param member 회원 정보
     * */
    public List<Item> showRecommendItemList(Member member) {

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
    public List<Item> showItemList(Item item) {
        logger.info("-------------------------");
        logger.info("Item viewItemList");
        logger.debug("parameter Item(category) : " + item);
        logger.info("return List");
        logger.info("-------------------------");
        return new ArrayList<Item>();
    }
}
