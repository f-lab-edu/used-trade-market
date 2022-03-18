package com.flab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PointManager {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final double pointAccumulate = 0.01;

    MemberManager memberManager = new MemberManager();
    ItemManager itemManager = new ItemManager();
    /**
     * 상품 번호가 <code>itemNo</code>인 상품에 대한 포인트를 구매자에게 지급하는 메소드
     * <code>itemNo</code>가 <code>null</code>인 경우에는 NullPointException을 반환한다.
     * @param itemNo 상품번호
     * @return 포인트 정상 지급 Y/N
     * */
    protected void addPoint(Long itemNo, Long memberNo) {
        logger.info("addPoint Method");
        logger.debug("parameter itemNo : {}", itemNo);

        Member memberInfo = memberManager.getMemberSelectOne(memberNo);
        Item item = itemManager.getItem(itemNo);
        double adaptPoint = item.getPrice() * pointAccumulate;
        memberInfo.setPoint(memberInfo.getPoint() + (int)adaptPoint);

        memberManager.updateMemberInfo(memberNo, memberInfo);

        logger.info("success addPoint");
    }
}
