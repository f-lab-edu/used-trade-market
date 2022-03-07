package com.flab;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberRepositoryTest {

    MemberRepository memberRepository = new MemberRepository();

    @DisplayName("회원이 등록 되었는지 확인하는 메소드")
    @Test
    public void registerMember() {

        MemberManager memberManager = new MemberManager();

        // given : 어떠한 데이터가 준비되었을 때
        Member member = new Member();
        member.setMemberId("test001");
        member.setMemberPassword("password001");
        member.setMemberName("홍길동");

        // when : 어떠한 함수를 실행하면
        memberManager.registerMember(member);

        Member checkMember = memberRepository.searchMember(member.getMemberNo());

        // then : 어떠한 결과가 나와야 한다.
        assertThat(checkMember).isEqualTo(member);

    }
}
