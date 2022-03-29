package com.market.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 찜 상태를 나타내는 클래스
 * */
@Getter @Setter
public class ZzimDTO {

    /** 
     * 상품 번호
     * */
    private Long itemNo;

    /** 
     * 사용자 번호
     * */
    private Long memberNo;

}
