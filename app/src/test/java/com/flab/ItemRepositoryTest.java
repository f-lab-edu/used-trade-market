package com.flab;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @Test
    @DisplayName("상품 등록 확인")
    public void registerItem() {

        // given ~가 준비되었을 때
        ItemManager itemManager = new ItemManager();
        Item item = new Item();
        item.setTitle("테스트 게시글 제목");
        item.setBigCategoryNo(1);
        item.setMiddleCategoryNo(1);
        item.setSmallCategoryNo(2);
        item.setAddress("경기도");
        item.setUsedYN(false);
        item.setExchangeYN(true);
        item.setPrice(100000);
        item.setRemark("비고");
        item.setTag("#태크");
        item.setItemNum(1);

        // when 함수를 실행하면
        itemManager.registerItem(item, 1L);

        Item result = itemRepository.getItemSelectOne(item.getItemNo());

        // then 이런 결과가 나와야한다.
        assertThat(item).isEqualTo(result);
    }
}
