package com.flab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/** 
 * 상품 관리 기능 클래스
 * 
 * @author 배영현
 * @version 1.0
 *
 * */
public class ItemManager {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private ItemRepository itemRepository = new ItemRepository();
    /**
     * 회원 정보가 <code>member</code>인 사용자를 통해 추천 상품 리스트를 나열해 보여준다.
     * <code>member</code>가 <code>null</code>인 경우에는 NullPointException을 반환한다.
     * @param member 회원 정보
     * */
    protected List<Item> showRecommendItemList(Member member) {

        if(member == null) {
            throw new NullPointerException();
        }

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
    protected List<Item> showItemList(Item item) {

        if(item == null) {
            throw new NullPointerException();
        }

        logger.info("-------------------------");
        logger.info("Item viewItemList");
        logger.debug("parameter Item(category) : " + item);
        logger.info("return List");
        logger.info("-------------------------");
        return new ArrayList<Item>();
    }

    /**
     * <code>item</code>인 상품을 등록하는 메소드
     * @param item 상품정보
     * @return result  정상 등록 여부 Y/N
     * */
    public boolean registerItem(@Nullable Item item, @Nullable Long memberId) {
        boolean result = false;

        if(item == null) {
            throw new NullPointerException();
        }

        if(memberId == null) {
            throw new NullPointerException();
        }

        itemRepository.registerItem(item, memberId);

        logger.info("-----------------");
        logger.info("register method");
        logger.debug("parameter item" + item.toString());
        logger.info("-----------------");

        return result;
    }


}
