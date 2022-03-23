package com.flab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ItemManagerTest {

    ItemManager itemManager = new ItemManager();

    MemberManager memberManager = new MemberManager();

    ItemRepository itemRepository = new ItemRepository();

    private Item item;
    private Item item2;
    private Item item3;

    private Member member;
    private Member member2;
    private Member member3;

    @BeforeEach
    public void setUp() {
        item = new Item();
        item.setTitle("테스트 상품1");
        item.setPrice(10000);
        item.setRemark("비고");
        item.setBigCategoryNo(1);
        item.setMiddleCategoryNo(1);
        item.setSmallCategoryNo(1);

        // 회원 객체 미리 저장
        Member registerMember = new Member();
        registerMember.setMemberId("test001");
        registerMember.setMemberPassword("password001");
        registerMember.setMemberName("홍길동");

        Member registerMember2 = new Member();
        registerMember2.setMemberId("test002");
        registerMember2.setMemberPassword("password002");
        registerMember2.setMemberName("고길동");

        Member registerMember3 = new Member();
        registerMember3.setMemberId("test003");
        registerMember3.setMemberPassword("password003");
        registerMember3.setMemberName("이순신");

        memberManager.registerMember(registerMember);
        memberManager.registerMember(registerMember2);
        memberManager.registerMember(registerMember3);

        member = memberManager.getMemberSelectOne(registerMember.getMemberNo());
        member2 = memberManager.getMemberSelectOne(registerMember2.getMemberNo());
        member3 = memberManager.getMemberSelectOne(registerMember3.getMemberNo());
    }

    @Test
    @DisplayName("ItemManager 상품 등록 메서드 테스트")
    public void registerItem() {
        // given
        // setUp() 메서드에서 객체 생성

        // when
        itemManager.registerItem(item, member.getMemberNo());

        // then
        assertThat(item).isEqualTo(itemManager.getItem(item.getItemNo()));
    }

    @Test
    @DisplayName("Itemmanager 상품 보여주는 메서드 테스트")
    public void showItemList() {

        // given
        itemManager.registerItem(item, member.getMemberNo());

        Item userSelectCategoryItem = new Item();
        item.setBigCategoryNo(2);
        item.setMiddleCategoryNo(2);
        item.setSmallCategoryNo(2);

        // when
        List<Item> searchItemList = itemManager.showItemList(item);

        List<Item> searchFailItemList = itemManager.showItemList(userSelectCategoryItem);

        // then
        assertThat(searchItemList.size()).isEqualTo(1);
        assertThat(searchItemList.get(0).getTitle()).isEqualTo("테스트 상품1");

        // 일치하는 상품이 없을 때
        assertThat(searchFailItemList.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("해당 상품 번호를 갖고 있는 상품 정보 갖고 오는 메서드 테스트")
    public void getItem() {
        // given
        itemManager.registerItem(item, member.getMemberNo());

        // when
        Item testItem1 = itemManager.getItem(item.getItemNo());

        // then
        assertThat(item).isEqualTo(testItem1);
    }

    @Test
    @DisplayName("상품 변경 내용 적용되는지 확인하는 메서드 테스트")
    public void updateItemInfo() {
        // given

        itemManager.registerItem(item, member.getMemberNo());

        item.setTitle("변경된 테스트 상품1");
        item.setPrice(20000);
        item.setRemark("변경된 비고");
        item.setBigCategoryNo(2);
        item.setMiddleCategoryNo(3);
        item.setSmallCategoryNo(2);

        // when
        itemManager.updateItemInfo(item.getItemNo(), item);

        Item updateItem = itemManager.getItem(item.getItemNo());

        // then
        assertThat(updateItem.getTitle()).isEqualTo("변경된 테스트 상품1");
        assertThat(updateItem.getPrice()).isEqualTo(20000);
        assertThat(updateItem.getRemark()).isEqualTo("변경된 비고");
        assertThat(updateItem.getBigCategoryNo()).isEqualTo(2);
        assertThat(updateItem.getMiddleCategoryNo()).isEqualTo(3);
        assertThat(updateItem.getSmallCategoryNo()).isEqualTo(2);

    }
}
