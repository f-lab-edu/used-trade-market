package com.flab;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 찜 되어 있는 상품을 관리하는 클래스
 * */
public class ZzimRepository {
    private static List<Zzim> zzimList = new ArrayList<>();

    /**
     * 찜 레포지토리에 저장되어 있는 찜 목록을 모두 갖고 오는 메소드
     * */
    protected List<Zzim> getZzimList() {
        return zzimList;
    }

    /**
     * 상품번호인 <code>itemNo</code>와 회원아이디인 <code>memberNo</code>를 zzim 객체를 저장하는 List인 <code>zzimList</code>를 확인하여
     * 찜이 되어 있는지 안되어 있는지 체크하는 메소드
     * */
    protected boolean checkZzimList(Long itemNo, Long memberNo) {
        for(int i=0; i < zzimList.size(); i++) {
            if(zzimList.get(i).getItemNo() == itemNo && zzimList.get(i).getMemberNo() == memberNo) {
                return false;
            }
        }
        return true;
    }

    /**
     * 상품번호인 <code>itemNo</code>와 회원아이디인 <code>memberNo</code>를 갖고 있는 zzim 객체를 찜 객체를 저장하는 List인 <code>zzimList</code>에서 제거하는 메소드
     * @param itemNo 상품번호
     * @param memberNo 사용자 번호
     * */
    protected void removeZzimList(Long itemNo, Long memberNo) {
        for(int i=0; i < zzimList.size(); i++) {
            if(zzimList.get(i).getItemNo() == itemNo && zzimList.get(i).getMemberNo() == memberNo) {
                zzimList.remove(i);
            }
        }
    }

    /**
     * <code>zzimList</code>에 <code>newZzim</code> 객체를 저장하는 메서드
     * @param newZzim 저장할 찜 객체
     * */
    protected void addZzimList(Zzim newZzim) {
        zzimList.add(newZzim);
    }
}
