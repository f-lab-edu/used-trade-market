package com.market.dto;

/**
 * 찜 상태를 나타내는 클래스
 * */
public class ZzimDTO {

    /** 
     * 상품 번호
     * */
    private Long itemNo;

    /** 
     * 사용자 번호
     * */
    private Long memberNo;

    public Long getItemNo() {
        return itemNo;
    }

    public void setItemNo(Long itemNo) {
        this.itemNo = itemNo;
    }

    public Long getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Long memberNo) {
        this.memberNo = memberNo;
    }
}
