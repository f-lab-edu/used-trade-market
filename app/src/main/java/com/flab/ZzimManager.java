package com.flab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

/**
 * @author 배영현
 * @version 1.0
 * 사용자가 상품에 대해 찜을 하는 행위를 관리하는 클래스
 * */
public class ZzimManager {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private ZzimRepository zzimRepository = new ZzimRepository();

    /**
     * 상품 번호가 <code>itemNo</code>인 상품을 찜 리스트에 추가한다.
     * 정상적으로 찜리스트에 추가된 경우에는 <code>true</code>를 반환한다. 이미 찜리스트에 있는 경우에는 중복되어 추가되지 않고 찜이 취소되며 <code>false</code>를 반환한다.
     * <code>itemNo</code>가 <code>null</code>인 경우에는 NullPointException을 반환한다.
     * @param itemNo 상품 번호
     * @return 찜이 정상적으로 됐는지 안됐는지 boolean 타입
     *
     * */
    protected boolean zzim(Long itemNo, Long memberNo) {
        logger.info("----- zzim -----");
        boolean result = false;
        if(itemNo == null || memberNo == null) {
            throw new NullPointerException();
        }

        if(!zzimRepository.checkZzimList(itemNo, memberNo)) {
            zzimRepository.removeZzimList(itemNo, memberNo);
        } else {
            Zzim newZzim = new Zzim();
            newZzim.setItemNo(itemNo);
            newZzim.setMemberNo(memberNo);
            zzimRepository.addZzimList(newZzim);
            result = true;
        }

        logger.debug("parameter itemNo : " + itemNo + "memberNo : " + memberNo);
        logger.info("----------------");
        return result;
    }

}
