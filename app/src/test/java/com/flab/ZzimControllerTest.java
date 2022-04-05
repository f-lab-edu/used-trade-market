package com.flab;

import com.market.controller.ItemController;
import com.market.controller.MemberController;
import com.market.controller.ZzimController;
import com.market.dto.ItemDTO;
import com.market.dto.MemberDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ZzimControllerTest {

    ZzimController zzimController = new ZzimController();

    private ItemDTO itemDTO;
    private ItemDTO itemDTO2;
    private ItemDTO itemDTO3;

    private MemberDTO member;
    private MemberDTO member2;
    private MemberDTO member3;

    MemberController memberController = new MemberController();
    ItemController itemController = new ItemController();

    @BeforeEach
    public void setUp() {


        ItemDTO registerItemDTO = new ItemDTO();
        registerItemDTO.setTitle("테스트 상품1");
        registerItemDTO.setPrice(10000);
        registerItemDTO.setRemark("비고");
        registerItemDTO.setBigCategoryNo(1);
        registerItemDTO.setMiddleCategoryNo(1);
        registerItemDTO.setSmallCategoryNo(1);

        // 회원 객체 미리 저장
        MemberDTO registerMember = new MemberDTO();
        registerMember.setMemberId("test001");
        registerMember.setMemberPassword("password001");
        registerMember.setMemberName("홍길동");

        MemberDTO registerMember2 = new MemberDTO();
        registerMember2.setMemberId("test002");
        registerMember2.setMemberPassword("password002");
        registerMember2.setMemberName("고길동");

        MemberDTO registerMember3 = new MemberDTO();
        registerMember3.setMemberId("test003");
        registerMember3.setMemberPassword("password003");
        registerMember3.setMemberName("이순신");

        memberController.registerMember(registerMember);
        memberController.registerMember(registerMember2);
        memberController.registerMember(registerMember3);

        member = memberController.getMemberSelectOne(registerMember.getMemberNo());
        member2 = memberController.getMemberSelectOne(registerMember2.getMemberNo());
        member3 = memberController.getMemberSelectOne(registerMember3.getMemberNo());

        itemController.registerItem(registerItemDTO, member.getMemberNo());

        itemDTO = itemController.getItem(registerItemDTO.getItemNo());

    }

    @Test
    public void ZzimTest() {
        // given

        // 찜 성공 상품에 대한 찜 count가 1 증가
        // when
        boolean result = zzimController.zzim(itemDTO.getItemNo(), member.getMemberNo());
        ItemDTO zzimItemDTO = itemController.getItem(itemDTO.getItemNo());
        // then
        assertThat(result).isEqualTo(true);
        assertThat(1).isEqualTo(zzimItemDTO.getZzimCount());


        // 찜 취소 이미 찜이 있을 경우 찜 취소 상품에 대한 찜 count가 1 감소
        // when
        boolean result2 = zzimController.zzim(itemDTO.getItemNo(), member.getMemberNo());
        zzimItemDTO = itemController.getItem(itemDTO.getItemNo());
        // then
        assertThat(result2).isEqualTo(false);
        assertThat(0).isEqualTo(zzimItemDTO.getZzimCount());
    }
}
