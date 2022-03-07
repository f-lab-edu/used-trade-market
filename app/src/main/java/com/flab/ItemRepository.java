package com.flab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

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
        itemList.put(key, item);
        logger.info(key + "add Member");
        itemList.put(key, item);
        logger.info("add Item info");
        logger.info(itemList.get(key).toString());
    }

    /**
     * <code>itemList</code>에서 상품 번호가 <code>itemNo</code>을 key 값으로 갖는 상품 객체를 반환한다.
     * */
    protected Item getItemSelectOne(Long itemNo) {
        return  itemList.get(itemNo);
    }

    /**
     * <code>itemList</code>에 저장되있는 모든 상품의 객체를 갖고온다.
     * */
    protected Map<Long, Item> getAllItem() {
        return itemList;
    }
}
