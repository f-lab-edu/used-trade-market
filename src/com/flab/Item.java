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
    public String itemNo;

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

    public Item(String itemNo) {
        this.itemNo = itemNo;
    }
}
