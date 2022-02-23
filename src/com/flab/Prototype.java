package com.flab;

import org.apache.log4j.BasicConfigurator;

import java.util.List;
import java.util.function.Function;

public class Prototype {
    public static void main(String[] args) {
        BasicConfigurator.configure();

        /** 
         * 임시 객체
         * */
        Member member = new Member();
        Item item = new Item();
        Seller seller = new Seller();
        Buyer buyer = new Buyer();
        TransactionService transactionService = new TransactionService();

        /**
         * 기본기능
         * */
        // 회원가입
        member.join(member);

        //추천 리스트 보여주기
        List<Item> recommendList = transactionService.recommendList(member);

        // 상품 리스트 보여주기
        List<Item> normalList = transactionService.viewItemList(item);

        /**
         * 회원인지 아닌지 체크 후 회원이 아니면 로그인 메소드를 타도록 함.
         * */
        if(!transactionService.isRegistered(member)) {
            member.goLogin();
        }

        /**
         * 판매자
         * */
        // 판매자 등록
        seller.register(item);

        /**
         * 구매자
         * */
        // 상품 선택
        Item selectItem = buyer.selectItem(item.itemNo);

        // 찜하기
        buyer.zzim(selectItem.itemNo);

        // 연락하기
        buyer.sendMessage(selectItem.itemNo);

        /**
         * 구매자가 거래방법 체크하는 메소드 추가
         * enum 클래스 활용하여 사용자가 직거래나 택배거래를 선택하면 해당 코드 반환
         * */
        int selectDealTypeCode = DealType.courierServiceBuy.getDealTypeCode();

        /**
         * isDirectTransaction()을 통해 택배배송인지 직거래인지 체크해서 true 직거래 그렇지 않으면 택배거래를 하도록 함
         * */
        boolean checkIsDirectTransaction = buyer.isDirectTransaction(selectDealTypeCode);

        // if문 제거 람다식으로 변환
        Function<Boolean, Boolean> isDirectTransaction = check -> true ? buyer.directTransaction(selectItem.itemNo) : buyer.courierServiceBuy(selectItem.itemNo);
        isDirectTransaction.apply(checkIsDirectTransaction);

    }
}


