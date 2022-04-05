package com.market.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 상품 속성 클래스
 *
 * @author 배영현
 * @version 1.0
 * */
@Getter @Setter
public class ItemDTO {
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

    /**
     * 구매자 -> 중개자 비용 지불 YN
     * */
    private boolean sendMoneySellerToCompany;

    /**
     * 중개자 -> 판매자 비용 지불 YN
     * */
    private boolean sendMoneyCompanyToBuyer;

    /**
     * 거래 가능 YN
     * */
    private boolean transactionYN;

    /**
     * 구매확정 YN
     * */
    private boolean purchaseConfirmationYN;

    /**
     * 찜 갯수
     * */
    private int zzimCount;

    public ItemDTO() {}


    @Override
    public String toString() {
        return "Item{" +
                "itemNo=" + itemNo +
                ", memberNo=" + memberNo +
                ", imgNo='" + imgNo + '\'' +
                ", title='" + title + '\'' +
                ", bigCategoryNo=" + bigCategoryNo +
                ", middleCategoryNo=" + middleCategoryNo +
                ", smallCategoryNo=" + smallCategoryNo +
                ", address='" + address + '\'' +
                ", UsedYN=" + UsedYN +
                ", exchangeYN=" + exchangeYN +
                ", price=" + price +
                ", remark='" + remark + '\'' +
                ", tag='" + tag + '\'' +
                ", itemNum=" + itemNum +
                ", sendMoneySellerToCompany=" + sendMoneySellerToCompany +
                ", sendMoneyCompanyToBuyer=" + sendMoneyCompanyToBuyer +
                ", transactionYN=" + transactionYN +
                ", purchaseConfirmationYN=" + purchaseConfirmationYN +
                '}';
    }
}
