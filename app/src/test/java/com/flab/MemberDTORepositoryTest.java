package com.flab;

import com.market.controller.MemberController;
import com.market.dto.MemberDTO;
import com.market.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberDTORepositoryTest {

    /*MemberRepository memberRepository = new MemberRepository();

    @DisplayName("회원 등록 확인")
    @Test
    public void registerMember() {

        // given : 어떠한 데이터가 준비되었을 때
        MemberController memberController = new MemberController();
        MemberDTO member = new MemberDTO();
        member.setMemberId("test001");
        member.setMemberPassword("password001");
        member.setMemberName("홍길동");

        // when : 어떠한 함수를 실행하면
        memberController.registerMember(member);

        MemberDTO checkMember = memberRepository.getMemberSelectOne(member.getMemberNo());

        // then : 어떠한 결과가 나와야 한다.
        assertThat(checkMember).isEqualTo(member);

    }*/
}
