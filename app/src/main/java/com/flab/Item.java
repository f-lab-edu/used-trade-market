package com.flab;
/**
 * 상품 속성 클래스
 *
 * @author 배영현
 * @version 1.0
 * */
public class Item {
    /**
     * 상품번호
     * */
    private Long itemNo;

    /**
     * 상품 등록 회원 번호
     * */
    private Long memberNo;

    /**
     * 상품이미지
     * */
    private String imgNo;

    /**
     * 게시글 제목
     * */
    private String title;

    /**
     * 대분류 카테고리 번호
     * */
    private int bigCategoryNo;

    /**
     * 중분류 카테고리 번호
     * */
    private int middleCategoryNo;

    /**
     * 소분류 카테고리 번호
     * */
    private int smallCategoryNo;

    /**
     * 거래지역
     * */
    private String address;

    /**
     * 중고상품 Y/N
     * */
    private Boolean UsedYN;

    /**
     * 교환 타입(교환불가, 교환가능)
     * */
    private Boolean exchangeYN;

    /**
     * 가격
     * */
    private int price;

    /**
     * 설명
     * */
    private String remark;

    /**
     * 태그
     * */
    private String tag;

    /**
     * 수량
     * */
    private int itemNum;

    public Item() {}

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

    public String getImgNo() {
        return imgNo;
    }

    public void setImgNo(String imgNo) {
        this.imgNo = imgNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBigCategoryNo() {
        return bigCategoryNo;
    }

    public void setBigCategoryNo(int bigCategoryNo) {
        this.bigCategoryNo = bigCategoryNo;
    }

    public int getMiddleCategoryNo() {
        return middleCategoryNo;
    }

    public void setMiddleCategoryNo(int middleCategoryNo) {
        this.middleCategoryNo = middleCategoryNo;
    }

    public int getSmallCategoryNo() {
        return smallCategoryNo;
    }

    public void setSmallCategoryNo(int smallCategoryNo) {
        this.smallCategoryNo = smallCategoryNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getUsedYN() {
        return UsedYN;
    }

    public void setUsedYN(Boolean usedYN) {
        UsedYN = usedYN;
    }

    public Boolean getExchangeYN() {
        return exchangeYN;
    }

    public void setExchangeYN(Boolean exchangeYN) {
        this.exchangeYN = exchangeYN;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getItemNum() {
        return itemNum;
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }
}
