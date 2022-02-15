package com.flab;

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
        member.join();

        //추천 리스트 보여주기
        List<Item> recommendList = member.recommendList();

        // 상품 리스트 보여주기
        List<Item> normalList = member.viewItemList();

        // 회원만 이용 가능
        if(member.getId().isEmpty() || member.getId() == null) {
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
         * checkDeal()을 통해 택배배송인지 직거래인지 체크해서 1이면 택배배송 그렇지 않으면 직거래를 하도록 함
         * */
        if(buyer.checkDeal() == 1) {
            // 택배배송
            buyer.courierServiceBuy(item.itemNo);
        } else  {
            // 직거래
            buyer.directTransaction(item.itemNo);
        }

    }
}

