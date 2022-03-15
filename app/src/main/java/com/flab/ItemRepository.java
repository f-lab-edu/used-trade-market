package com.flab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.util.*;

/**
 * @author 배영현
 * @version 1.0
 *
 * 상품 정보를 저장하는 클래스
 * */
public class ItemRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 상품을 저장할 HashMap
     * */
    private static Map<Long, Item> itemList = new HashMap<>();

    /**
     * 맵의 Key값 1씩 증가
     * */
    private static Long key = 0L;

    /**
     * <code>item</code>인 상품정보를 상품 저장소 <code>itemList</code>에 저장한다.
     * <code>key</code>는 상품 번호를 나타내며 <code>key</code>는 1씩 증가해서 저장될 수 있도록 한다.
     * */
    protected void registerItem(Item item, Long memberNo) {
        item.setItemNo(++key);
        item.setMemberNo(memberNo);
        item.setTransactionYN(true);
        itemList.put(key, item);

        logger.info(key + "register item");

        logger.info("register Item info");
        logger.info(itemList.get(key).toString());
    }

    /**
     * <code>itemList</code>에서 상품 번호가 <code>itemNo</code>을 key 값으로 갖는 상품 객체를 반환한다.
     * */
    protected Item getItemSelectOne(Long itemNo) {
        logger.debug(itemList.get(itemNo).toString());
        return  itemList.get(itemNo);
    }

    /**
     * <code>itemList</code>에 저장되있는 모든 상품의 객체를 갖고온다.
     * */
    protected Map<Long, Item> getAllItem() {
        return itemList;
    }

    /**
     * 추천 상품 목록 미구현..
     * */
    protected List<Item> showRecommendItemList(Member member) {
        return new ArrayList<Item>();
    }

    /**
     * <code>item</code>인 상품 객체의 <code>bigCategory</code> 대분류, <code>middleCategory</code> 중분류, <code>smallCaterogy</code> 소분류를
     * 통해 기존 <code>itemList</code>에서 각각의 카테고리에 해당 하는 상품 객체만 List인 <code>categoryItemList</code>에 저장하여 반환한다.
     * */
    protected List<Item> showItemList(Item item) {
        logger.info("----- ItemRepository showItemList -----");

        List<Item> categoryItemList = new ArrayList<>();
        int bigCategory = item.getBigCategoryNo();
        int middleCategory = item.getMiddleCategoryNo();
        int smallCategory = item.getSmallCategoryNo();

        Iterator<Long> iter = itemList.keySet().iterator();

        while(iter.hasNext()) {
            Long key = iter.next();
            if(itemList.get(key).getBigCategoryNo() == bigCategory && itemList.get(key).getMiddleCategoryNo() == middleCategory
                    && itemList.get(key).getSmallCategoryNo() == smallCategory) {
                categoryItemList.add(itemList.get(key));
            }
        }
        return categoryItemList;
    }

    /**
     * <code>item</code>인 상품에 관련된 변경 내용이 있을 경우 해당 메소드를 통해 상품 저장소인 <code>itemList</code>에 저장한다.
     * @param item
     * */
    protected void updateItemInfo(@Nonnull Long itemNo, @Nonnull Item item) {
        logger.debug("itemNo : "+itemNo + "itemInfo"+ item.toString());
        itemList.put(itemNo, item);
    }
}
