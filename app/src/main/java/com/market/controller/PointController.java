package com.market.controller;

import com.market.dto.ItemDTO;
import com.market.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PointController {

    private final double pointAccumulate = 0.01;

    @Autowired
    MemberController memberController;

    @Autowired
    ItemController itemController;
    /**
     * 상품 번호가 <code>itemNo</code>인 상품에 대한 포인트를 구매자에게 지급하는 메소드
     * <code>itemNo</code>가 <code>null</code>인 경우에는 NullPointException을 반환한다.
     * @param itemNo 상품번호
     * @return 포인트 정상 지급 Y/N
     * */
    protected void addPoint(Long itemNo, Long memberNo) {
        log.info("addPoint Method");
        log.debug("parameter itemNo : {}", itemNo);

        /*MemberDTO memberInfo = memberController.getMemberSelectOne(memberNo);
        ItemDTO itemDTO = itemController.getItem(itemNo);
        double adaptPoint = itemDTO.getPrice() * pointAccumulate;
        memberInfo.setPoint(memberInfo.getPoint() + (int)adaptPoint);

        memberController.updateMemberInfo(memberInfo);*/

        log.info("success addPoint");
    }
}
