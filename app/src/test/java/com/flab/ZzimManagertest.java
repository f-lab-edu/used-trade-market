package com.flab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ZzimManagertest {

    ZzimManager zzimManager = new ZzimManager();

    private Item item;
    private Item item2;
    private Item item3;

    private Member member;
    private Member member2;
    private Member member3;

    MemberManager memberManager = new MemberManager();
    ItemManager itemManager = new ItemManager();

    @BeforeEach
    public void setUp() {


        Item registerItem = new Item();
        registerItem.setTitle("테스트 상품1");
        registerItem.setPrice(10000);
        registerItem.setRemark("비고");
        registerItem.setBigCategoryNo(1);
        registerItem.setMiddleCategoryNo(1);
        registerItem.setSmallCategoryNo(1);

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

        itemManager.registerItem(registerItem, member.getMemberNo());

        item = itemManager.getItem(registerItem.getItemNo());

    }

    @Test
    public void ZzimTest() {
        // given

        // 찜 성공 상품에 대한 찜 count가 1 증가
        // when
        boolean result = zzimManager.zzim(item.getItemNo(), member.getMemberNo());
        Item zzimItem = itemManager.getItem(item.getItemNo());
        // then
        assertThat(result).isEqualTo(true);
        assertThat(1).isEqualTo(zzimItem.getZzimCount());


        // 찜 취소 이미 찜이 있을 경우 찜 취소 상품에 대한 찜 count가 1 감소
        // when
        boolean result2 = zzimManager.zzim(item.getItemNo(), member.getMemberNo());
        zzimItem = itemManager.getItem(item.getItemNo());
        // then
        assertThat(result2).isEqualTo(false);
        assertThat(0).isEqualTo(zzimItem.getZzimCount());
    }
}
