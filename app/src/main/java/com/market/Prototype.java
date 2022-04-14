package com.market;

import com.market.controller.ItemController;
import com.market.controller.MemberController;
import com.market.controller.TransactionController;
import com.market.controller.ZzimController;
import com.market.dto.ItemDTO;
import com.market.dto.MemberDTO;
import com.market.dto.fix.DealType;

import java.util.List;
import java.util.function.Function;

public class Prototype {
    public static void main(String[] args) {

       /* *//**
         * 임시 객체
         * *//*
        MemberDTO member = new MemberDTO();
        ItemDTO itemDTO = new ItemDTO();
        ItemController itemController = new ItemController();
        MemberController memberController = new MemberController();
        ZzimController zzimController = new ZzimController();
        TransactionController transactionController = new TransactionController();

        *//**
         * 기본기능
         * *//*
        // 회원가입
        memberController.registerMember(member);

        *//**
         * 판매자
         * *//*
        itemController.registerItem(itemDTO, member.getMemberNo());

        //추천 리스트 보여주기
        List<ItemDTO> recommendList = itemController.showRecommendItemList(member);

        // 상품 리스트 보여주기
        List<ItemDTO> normalList = itemController.showItemList(itemDTO);

        *//**
         * 회원인지 아닌지 체크 후 회원이 아니면 로그인 메소드를 타도록 함.
         * *//*
        if(!memberController.isRegistered(member)) {
            memberController.goLogin();
        }


        *//**
         * 구매자
         * *//*
        // 상품 선택
        ItemDTO selectItemDTO = itemController.getItem(itemDTO.getItemNo());

        // 찜하기
        zzimController.zzim(selectItemDTO.getItemNo(), member.getMemberNo());

        *//**
         * 구매자가 거래방법 체크하는 메소드 추가
         * enum 클래스 활용하여 사용자가 직거래나 택배거래를 선택하면 해당 코드 반환
         * *//*
        int selectDealTypeCode = DealType.courierServiceBuy.getDealTypeCode();

        *//**
         * isDirectTransaction()을 통해 택배배송인지 직거래인지 체크해서 true 직거래 그렇지 않으면 택배거래를 하도록 함
         * *//*
        boolean checkIsDirectTransaction = transactionController.isDirectTransaction(selectDealTypeCode);

        // if문 제거 람다식으로 변환
        Function<Boolean, Boolean> isDirectTransaction = check -> true ? transactionController.directTransaction(selectItemDTO.getItemNo(), member.getMemberNo())
                : transactionController.courierServiceBuy(selectItemDTO.getItemNo(), member.getMemberNo());
        isDirectTransaction.apply(checkIsDirectTransaction);
*/
    }
}


