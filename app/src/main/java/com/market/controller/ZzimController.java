package com.market.controller;

import com.market.repository.ZzimRepository;
import com.market.dto.ItemDTO;
import com.market.dto.ZzimDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 배영현
 * @version 1.0
 * 사용자가 상품에 대해 찜을 하는 행위를 관리하는 클래스
 * */
@Slf4j
@RestController
public class ZzimController {

    @Autowired
    private ZzimRepository zzimRepository;

    @Autowired
    private ItemController itemController;

    /**
     * 상품 번호가 <code>itemNo</code>인 상품을 찜 리스트에 추가한다.
     * 정상적으로 찜리스트에 추가된 경우에는 <code>true</code>를 반환한다. 이미 찜리스트에 있는 경우에는 중복되어 추가되지 않고 찜이 취소되며 <code>false</code>를 반환한다.
     * <code>itemNo</code>가 <code>null</code>인 경우에는 NullPointException을 반환한다.
     * @param itemNo 상품 번호
     *
     * */
    public boolean zzim(Long itemNo, Long memberNo) {
        log.info("----- zzim -----");
        boolean result = false;
        if(itemNo == null || memberNo == null) {
            throw new NullPointerException();
        }

        if(!zzimRepository.checkZzimList(itemNo, memberNo)) {
            zzimRepository.removeZzimList(itemNo, memberNo);

            ItemDTO zzimCountUpdateItemDTO = itemController.getItem(itemNo);
            zzimCountUpdateItemDTO.setZzimCount(zzimCountUpdateItemDTO.getZzimCount()-1);

            itemController.updateItemInfo(itemNo, zzimCountUpdateItemDTO);

        } else {
            ZzimDTO newZzim = new ZzimDTO();
            newZzim.setItemNo(itemNo);
            newZzim.setMemberNo(memberNo);
            zzimRepository.addZzimList(newZzim);

            ItemDTO zzimCountUpdateItemDTO = itemController.getItem(itemNo);
            zzimCountUpdateItemDTO.setZzimCount(zzimCountUpdateItemDTO.getZzimCount()+1);

            itemController.updateItemInfo(itemNo, zzimCountUpdateItemDTO);

            result = true;
        }

        log.debug("parameter itemNo : {}", itemNo, "memberNo : {}", memberNo);
        log.info("----------------");
        return result;
    }

}
