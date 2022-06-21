package com.market.controller;

import com.market.repository.ItemRepository;
import com.market.dto.ItemDTO;
import com.market.dto.MemberDTO;
import com.market.service.ItemService;
import com.market.util.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/** 
 * 상품 관리 기능 클래스
 * 
 * @author 배영현
 * @version 1.0
 *
 * */
@Slf4j
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * <code>item</code>인 상품을 등록하는 메소드로 정상적으로 상품이 등록 되었을 경우 true를 반환한다.
     * @param itemDTO 상품정보
     * */
    @PostMapping("/register")
    public void registerItem(String registerId, @RequestBody ItemDTO itemDTO) {
        log.info("register method");

        if(itemDTO == null) {
            throw new NullPointerException();
        }

        itemService.registerItem(registerId, itemDTO);

        log.info("success item register");
    }

    /**
     * 회원 정보가 <code>member</code>인 사용자를 통해 추천 상품 리스트를 나열해 보여준다.
     * @param member 회원 정보
     * */
    public List<ItemDTO> showRecommendItemList(@Nonnull MemberDTO member) {
        if(member == null) {
            throw new NullPointerException();
        }

        log.info("Item recommendList");

        log.debug("parameter member : {} " + member);

        return new ArrayList<ItemDTO>();
    }

    /**
     * 상품 목록을 보여주는 메서드로 <code>item</code>을 받아 item의 카테고리 정보를 통해 상품을 보여준다.
     * ArrayList로 상품 정보를 담아 반환한다.
     * @return ArrayList<Item>
     * */
    @GetMapping
    public List<ItemDTO> showItemList() {

        log.info("Item viewItemList");

        return itemService.showItemList();
    }

    /**
     * <code>itemNo</code>을 갖고 있는 Item 객체를 ItemRepository에서 가지고 오는 메소드
     * @param itemNo 상품 번호
     * @return <code>itemNo</code>인 상품 객체
     * */
    @GetMapping("{itemNo}")
    public ItemDTO getItem(@Nonnull  Long itemNo) {
        log.info("getItem Method");
        log.info("itemNo : {}", itemNo);

        if(itemNo == null) {
            throw new NullPointerException();
        }

        return itemService.getItemSelectOne(itemNo);
    }

    /**
     * itemRepository에 있는 저장소 관련 상품정보 update 관련 메소드를 실행시킨다.
     * @param itemNo     상품 번호
     * @param itemDTO       업데이트 될 상품 정보
     * */
    public void updateItemInfo(@Nonnull Long itemNo, @Nonnull ItemDTO itemDTO) {
        itemService.updateItemInfo(itemNo, itemDTO);
    }
}
