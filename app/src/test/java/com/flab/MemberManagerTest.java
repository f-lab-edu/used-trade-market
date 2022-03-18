package com.flab;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class MemberManagerTest {

    MemberManager memberManager = new MemberManager();

    MemberRepository memberRepository = new MemberRepository();

    @Test
    @DisplayName("MemberManager 회원 등록 메서드 테스트")
    public void registerMember() {
        // given : 어떠한 데이터가 준비되었을 때
        Member member = new Member();
        member.setMemberId("test001");
        member.setMemberPassword("password001");
        member.setMemberName("홍길동");

        // when : 어떠한 함수를 실행하면
        memberManager.registerMember(member);

        Member checkMember = memberRepository.getMemberSelectOne(member.getMemberNo());

        // then : 어떠한 결과가 나와야 한다.
        assertThat(checkMember).isEqualTo(member);
    }
    
    @Test
    @DisplayName("MemberManager 회원 정보 갖고 오는 메서드 테스트")
    public void getMemberSelectOne() {
        // given
        Member member = new Member();
        member.setMemberId("test001");
        member.setMemberPassword("password001");
        member.setMemberName("홍길동");

        Member member2 = new Member();
        member.setMemberId("test002");
        member.setMemberPassword("password002");
        member.setMemberName("고길동");

        memberManager.registerMember(member);
        memberManager.registerMember(member2);

        // when
        Member testMember1 = memberManager.getMemberSelectOne(1L);
        Member testMember2 = memberManager.getMemberSelectOne(2L);

        // then
        assertThat(member).isEqualTo(testMember1);
        assertThat(member2).isEqualTo(testMember2);
    }

    @Test
    @DisplayName("MemberManager 회원 등록 여부 확인 메서드")
    public void isRegistered() {
        // given
        Member member = new Member();
        member.setMemberId("test001");
        member.setMemberPassword("password001");
        member.setMemberName("홍길동");
        memberManager.registerMember(member);

        Member member2 = new Member();
        member2.setMemberId("test002");
        member2.setMemberPassword("password002");
        member2.setMemberName("김길동");

        // when
        boolean test = memberManager.isRegistered(member);
        boolean test2 = memberManager.isRegistered(member2);

        // then
        assertThat(true).isEqualTo(test);
        assertThat(false).isEqualTo(test2);

    }


    @Test
    @DisplayName("MemberManager 회원 정보 업데이트 메서드 테스트")
    public void updateMemberInfo() {
        // given
        Member member = new Member();
        member.setMemberId("test001");
        member.setMemberPassword("password001");
        member.setMemberName("홍길동");
        memberManager.registerMember(member);


        // when
        Member changeMember = memberManager.getMemberSelectOne(member.getMemberNo());
        changeMember.setMemberId("changeTest001");
        changeMember.setMemberPassword("changePassword001");
        changeMember.setMemberName("바뀐홍길동");
        memberManager.updateMemberInfo(changeMember.getMemberNo(), changeMember);

        // then
        assertThat(changeMember).isEqualTo(memberManager.getMemberSelectOne(changeMember.getMemberNo()));
        assertThat("changeTest001").isEqualTo(memberManager.getMemberSelectOne(changeMember.getMemberNo()).getMemberId());
        assertThat("changePassword001").isEqualTo(memberManager.getMemberSelectOne(changeMember.getMemberNo()).getMemberPassword());
        assertThat("바뀐홍길동").isEqualTo(memberManager.getMemberSelectOne(changeMember.getMemberNo()).getMemberName());

    }
    


}
