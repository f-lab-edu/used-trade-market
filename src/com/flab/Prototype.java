package com.flab;

import java.lang.reflect.Member;

public class Prototype {
    public static void main(String[] args) {

        /** 
         * 임시 객체
         * */
        Member member = new Member();
        Item item = new Item();
        Seller seller = new Seller();
        Buyer buyer = new Buyer();

        /**
         * 기본기능
         * */
        // 회원가입
        member.join(member);

        //추천 리스트 보여주기
        List<Item> recommendList = member.recommendList();

        // 상품 리스트 보여주기
        List<Item> normalList = member.viewItemList();

        // 회원만 이용 가능
        //if(member.getId() == null || member.getId().isEmpty()) {
        /**
         * 회원인지 아닌지 체크 후 회원이 아니면 로그인 메소드를 타도록 함.
         * */
        if(!member.isRegistered()) {
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
        buyer.selectItem(item.itemNo);

        // 찜하기
        buyer.zzim(item.itemNo);

        // 연락하기
        buyer.sendMessage(item.itemNo);

        /**
         * isDirectTransaction()을 통해 택배배송인지 직거래인지 체크해서 true 직거래 그렇지 않으면 택배거래를 하도록 함
         * */
        // 삼항연산자로 변경
        buyer.isDirectTransaction(item.itemNo) ? buyer.directTransaction(item.itemNo) : buyer.courierServiceBuy(item.itemNo);

    }
}


