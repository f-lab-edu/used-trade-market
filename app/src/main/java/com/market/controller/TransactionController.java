package com.market.controller;

import com.market.dto.ItemDTO;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;

/**
 * @author 배영현
 * @version 1.0
 * 거래 관련 관리 클래스
 * */
@Slf4j
@RestController
public class TransactionController {

    @Autowired
    ItemController itemController;

    @Autowired
    PointController pointController;

    /**
     * <code>dealType</code>는 거래 방법을 의미하는 파라미터로 해당 파라미터를 통해 직거래이면 <code>true</code> 직거래가 아니라 택배거래이면
     * <code>false</code>를 반환한다.
     * @param selectDealTypeCode
     * return result
     * */
    public boolean isDirectTransaction(int selectDealTypeCode) {
        boolean result = false;
        if(selectDealTypeCode == 1) {
            result = true;
        }
        log.info("isDirectTransaction method");
        log.debug("parameter dealType : {}", selectDealTypeCode);
        return result;
    }
    /**
     * 구매자가 상품 번호가 <code>itemNo</code>인 상품의 거래방법을 직거래를 선택했을 때 사용하는 메소드로 거래방법
     * @param itemNo 상품번호
     * @param memberNo 구매자번호
     * return result  구매가 정상적으로 일어났는지 boolean 타입으로 확인
     * */
    public boolean directTransaction(@Nonnull Long itemNo, @Nonnull Long memberNo) {
        TransactionController transactionController = new TransactionController();
        boolean result = false;
        log.info("directTransaction method");
        log.debug("parameter itemNo : {}", itemNo);
        transactionController.sendMoneyBuyerToCompany(itemNo);

        if(transactionController.purchaseConfirmation(itemNo, memberNo)) {
            transactionController.sendMoneyCompanyToSeller(itemNo, memberNo);
            pointController.addPoint(itemNo, memberNo);
        } else {
            transactionController.sendMoneyCompanyToBuyer(itemNo, memberNo);
        }
        result = true;
        return result;
    }

    /**
     * 구매자가 상품 번호가 <code>itemNo</code>인 상품의 거래방법을 택배 배송을 선택했을 때 사용하는 메소드
     * @param itemNo 상품번호
     * @param memberNo 구매자번호
     * return result  구매가 정상적으로 일어났는지 boolean 타입으로 확인
     * */
    public boolean courierServiceBuy(@Nonnull  Long itemNo, @Nonnull Long memberNo) {
        TransactionController transactionController = new TransactionController();
        if(itemNo == null || memberNo == null) {
            throw new NullPointerException();
        }
        boolean result = false;

        sendMoneyBuyerToCompany(itemNo);
        transactionController.delivery(itemNo, memberNo);

        if(this.purchaseConfirmation(itemNo, memberNo)) {
            transactionController.sendMoneyCompanyToSeller(itemNo, memberNo);
            pointController.addPoint(itemNo, memberNo);
        } else {
            transactionController.sendMoneyCompanyToBuyer(itemNo, memberNo);
        }
        return result;

    }

    /**
     * 상품 번호가 <code>itemNo</code>인 상품을 구매자가 구입 후 구매 확정이 되기 전 구매자가 중개자에게 비용을 맡기는 기능을 하는 메소드
     * @param itemNo 상품번호
     * @return result 비용 정상 지급 Y/N
     * */
    public boolean sendMoneyBuyerToCompany(@Nonnull Long itemNo) {
        log.info("sendMoneyBuyerToCompany method");
        log.debug("parameter itemNo : {}", itemNo);

        if(itemNo == null) {
            throw new NullPointerException();
        }

        boolean result = false;
        ItemDTO itemDTO = itemController.getItem(itemNo);

        itemDTO.setSendMoneySellerToCompany(true);
        itemDTO.setTransactionYN(false);
        itemController.updateItemInfo(itemNo, itemDTO);
        result = true;


        return result;
    }


    /**
     * 구매확정 후 판매자에게 돈 지불하는 메소드로 <code>itemNo</code>인 상품을 찾아 금액을 확인 한 후 판매자에게 돈을 지불한다.
     * @param itemNo 상품 번호
     * @return result 정상 지급 Y/N
     * */
    public boolean sendMoneyCompanyToSeller(@Nonnull Long itemNo, @Nonnull Long memberNo) {
        if(itemNo == null || memberNo == null) {
            throw new NullPointerException();
        }
        log.info("sendMoneyCompanyToSeller method");
        log.debug("parameter itemNo : {}", itemNo);

        boolean result = false;

        ItemDTO itemDTO = itemController.getItem(itemNo);
        itemDTO.setSendMoneyCompanyToBuyer(true);

        itemController.updateItemInfo(itemNo, itemDTO);

        result = true;

        return result;
    }

    /**
     * 구매취소 후 구매자에게 돈을 환급하는 메소드로 <code>itemNo</code>인 상품의 금액을 찾아고 구매자의 정보를 찾은 후 구매자에게 돈을 환급한다
     * <code>itemNo</code>가 <code>null</code>인 경우 NullPointException을 반환한다.
     * @param itemNo 상품 번호
     * */
    public void sendMoneyCompanyToBuyer(@Nonnull Long itemNo, @Nonnull Long memberNo) {
        if(itemNo == null || memberNo == null) {
            throw new NullPointerException();
        }
        log.info("sendMoneyCompanyToBuyer method");
        log.debug("parameter itemNo : {]", itemNo);

        ItemDTO itemDTO = itemController.getItem(itemNo);
        itemDTO.setSendMoneyCompanyToBuyer(false);
        itemDTO.setSendMoneySellerToCompany(false);

        itemController.updateItemInfo(itemNo, itemDTO);

    }

    /**
     * 상품 번호가 <code>itemNo</code>인 상품에 대해 구매자가 상품 구매 후 문제가 없다면 구매를 확정하는지 확인하는 메소드로
     * 구매 확정 상태가 변경된다.
     * @param itemNo 상품번호
     * @return result 구매확정 Y/N
     * */
    public boolean purchaseConfirmation(@Nonnull Long itemNo, @Nonnull Long memberNo) {
        if(itemNo == null || memberNo == null) {
            throw new NullPointerException();
        }
        boolean result = false;
        log.info("purchaseConfirmation method");
        log.debug("parameter itemNo : {}", itemNo);

        ItemDTO itemDTO = itemController.getItem(itemNo);
        itemDTO.setPurchaseConfirmationYN(true);

        itemController.updateItemInfo(itemNo, itemDTO);

        result = true;

        return result;
    }

    /**
     * 상품 배송 메소드
     * <code>itemNo</code>가 <code>null</code>인 경우에는 NullPointException을 반환한다.
     * @param itemNo 상품번호
     * @return result 정상배송 Y/N
     * */
    public boolean delivery(@Nonnull Long itemNo, @Nonnull Long memberNo) {
        if(itemNo == null || memberNo == null) {
            throw new NullPointerException();
        }
        boolean result = false;

        ItemDTO itemDTO = itemController.getItem(itemNo);
        itemDTO.setTransactionYN(true);

        itemController.updateItemInfo(itemNo, itemDTO);

        log.info("상품 배송이 완료되었습니다.");

        result = true;
        return result;
    }
}
