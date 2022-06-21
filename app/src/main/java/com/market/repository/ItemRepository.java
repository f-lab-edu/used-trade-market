package com.market.repository;

import com.market.dto.ItemDTO;
import com.market.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import java.util.*;

/**
 * @author 배영현
 * @version 1.0
 *
 * 상품 정보를 저장하는 클래스
 * */
@Slf4j
@Repository
public class ItemRepository {

    /**
     * 상품을 저장할 HashMap
     * */
    private static Map<Long, ItemDTO> itemList = new HashMap<>();

    /**
     * 맵의 Key값 1씩 증가
     * */
    private static Long key = 0L;

    /**
     * <code>item</code>인 상품정보를 상품 저장소 <code>itemList</code>에 저장한다.
     * <code>key</code>는 상품 번호를 나타내며 <code>key</code>는 1씩 증가해서 저장될 수 있도록 한다.
     * */
    public void registerItem(ItemDTO itemDTO) {
        itemDTO.setItemNo(++key);
        itemDTO.setTransactionYN(true);
        itemList.put(key, itemDTO);

        log.info("register item", key);

        log.info("register Item info", itemList.get(key));
    }

    /**
     * <code>itemList</code>에서 상품 번호가 <code>itemNo</code>을 key 값으로 갖는 상품 객체를 반환한다.
     * */
    public ItemDTO getItemSelectOne(Long itemNo) {
        log.debug("itemInfo", itemList.get(itemNo));
        return  itemList.get(itemNo);
    }

    /**
     * <code>itemList</code>에 저장되있는 모든 상품의 객체를 갖고온다.
     * */
    public Map<Long, ItemDTO> getAllItem() {
        return itemList;
    }

    /**
     * 추천 상품 목록 미구현..
     * */
    public List<ItemDTO> showRecommendItemList(MemberDTO member) {
        return new ArrayList<ItemDTO>();
    }


    /**
     * <code>item</code>인 상품에 관련된 변경 내용이 있을 경우 해당 메소드를 통해 상품 저장소인 <code>itemList</code>에 저장한다.
     * @param itemDTO
     * */
    public void updateItemInfo(@Nonnull Long itemNo, @Nonnull ItemDTO itemDTO) {
        log.debug("itemNo : {}, itemInfo : {}", itemNo, itemDTO);
        itemList.put(itemNo, itemDTO);
    }
}
