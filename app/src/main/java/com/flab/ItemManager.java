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
     * <code>item</code>인 상품을 등록하는 메소드로 정상적으로 상품이 등록 되었을 경우 true를 반환한다.
     * @param item 상품정보
     * @return result  정상 등록 여부 Y/N
     * */
    protected boolean registerItem(@Nullable Item item, @Nullable Long memberNo) {
        logger.info("register method");

        boolean result = false;

        if(item == null || memberNo == null) {
            throw new NullPointerException();
        }

        itemRepository.registerItem(item, memberNo);

        result = true;

        logger.info("success item register");

        return result;
    }

    /**
     * 회원 정보가 <code>member</code>인 사용자를 통해 추천 상품 리스트를 나열해 보여준다.
     * @param member 회원 정보
     * */
    protected List<Item> showRecommendItemList(@Nonnull Member member) {
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
     * @param item 상품 카테고리 체크를 위해
     * @return ArrayList<Item>
     * */
    protected List<Item> showItemList(@Nonnull Item item) {

        logger.info("Item viewItemList");

        if(item == null) {
            throw new NullPointerException();
        }

        return itemRepository.showItemList(item);
    }

    /**
     * <code>itemNo</code>을 갖고 있는 Item 객체를 ItemRepository에서 가지고 오는 메소드
     * @param itemNo 상품 번호
     * @return <code>itemNo</code>인 상품 객체
     * */
    protected Item getItem(@Nonnull  Long itemNo) {
        logger.info("----- getItem -----");

        if(itemNo == null) {
            throw new NullPointerException();
        }

        return itemRepository.getItemSelectOne(itemNo);
    }

    /**
     * itemRepository에 있는 저장소 관련 상품정보 update 관련 메소드를 실행시킨다.
     * @param itemNo     상품 번호
     * @param item       업데이트 될 상품 정보
     * */
    protected void updateItemInfo(@Nonnull Long itemNo, @Nonnull Item item) {
        itemRepository.updateItemInfo(itemNo, item);
    }
}
