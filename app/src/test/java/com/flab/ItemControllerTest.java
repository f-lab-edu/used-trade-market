package com.flab;

import com.market.controller.ItemController;
import com.market.controller.MemberController;
import com.market.dto.ItemDTO;
import com.market.dto.MemberDTO;
import com.market.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ItemControllerTest {

    ItemController itemController = new ItemController();

    MemberController memberController = new MemberController();

    ItemRepository itemRepository = new ItemRepository();

    private ItemDTO itemDTO;
    private ItemDTO itemDTO2;
    private ItemDTO itemDTO3;

    private MemberDTO member;
    private MemberDTO member2;
    private MemberDTO member3;

    @BeforeEach
    public void setUp() {
        itemDTO = new ItemDTO();
        itemDTO.setTitle("테스트 상품1");
        itemDTO.setPrice(10000);
        itemDTO.setRemark("비고");
        itemDTO.setBigCategoryNo(1);
        itemDTO.setMiddleCategoryNo(1);
        itemDTO.setSmallCategoryNo(1);

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
    }

    @Test
    @DisplayName("ItemManager 상품 등록 메서드 테스트")
    public void registerItem() {
        // given
        // setUp() 메서드에서 객체 생성

        // when
        itemController.registerItem(itemDTO, member.getMemberNo());

        // then
        assertThat(itemDTO).isEqualTo(itemController.getItem(itemDTO.getItemNo()));
    }

    @Test
    @DisplayName("Itemmanager 상품 보여주는 메서드 테스트")
    public void showItemList() {

        // given
        itemController.registerItem(itemDTO, member.getMemberNo());

        ItemDTO userSelectCategoryItemDTO = new ItemDTO();
        itemDTO.setBigCategoryNo(2);
        itemDTO.setMiddleCategoryNo(2);
        itemDTO.setSmallCategoryNo(2);

        // when
        List<ItemDTO> searchItemDTOList = itemController.showItemList(itemDTO);

        List<ItemDTO> searchFailItemDTOList = itemController.showItemList(userSelectCategoryItemDTO);

        // then
        assertThat(searchItemDTOList.size()).isEqualTo(1);
        assertThat(searchItemDTOList.get(0).getTitle()).isEqualTo("테스트 상품1");

        // 일치하는 상품이 없을 때
        assertThat(searchFailItemDTOList.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("해당 상품 번호를 갖고 있는 상품 정보 갖고 오는 메서드 테스트")
    public void getItem() {
        // given
        itemController.registerItem(itemDTO, member.getMemberNo());

        // when
        ItemDTO testItemDTO1 = itemController.getItem(itemDTO.getItemNo());

        // then
        assertThat(itemDTO).isEqualTo(testItemDTO1);
    }

    @Test
    @DisplayName("상품 변경 내용 적용되는지 확인하는 메서드 테스트")
    public void updateItemInfo() {
        // given

        itemController.registerItem(itemDTO, member.getMemberNo());

        itemDTO.setTitle("변경된 테스트 상품1");
        itemDTO.setPrice(20000);
        itemDTO.setRemark("변경된 비고");
        itemDTO.setBigCategoryNo(2);
        itemDTO.setMiddleCategoryNo(3);
        itemDTO.setSmallCategoryNo(2);

        // when
        itemController.updateItemInfo(itemDTO.getItemNo(), itemDTO);

        ItemDTO updateItemDTO = itemController.getItem(itemDTO.getItemNo());

        // then
        assertThat(updateItemDTO.getTitle()).isEqualTo("변경된 테스트 상품1");
        assertThat(updateItemDTO.getPrice()).isEqualTo(20000);
        assertThat(updateItemDTO.getRemark()).isEqualTo("변경된 비고");
        assertThat(updateItemDTO.getBigCategoryNo()).isEqualTo(2);
        assertThat(updateItemDTO.getMiddleCategoryNo()).isEqualTo(3);
        assertThat(updateItemDTO.getSmallCategoryNo()).isEqualTo(2);

    }
}
