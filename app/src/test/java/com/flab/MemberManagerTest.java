package com.flab;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberManagerTest {

    MemberManager memberManager = new MemberManager();

    MemberRepository memberRepository = new MemberRepository();

    /** 
     * 회원 가입 할 정보를 담을 임시 객체 3명
     * */
    private Member member;
    private Member member2;
    private Member member3;

    @BeforeEach
    public void setUp() {
        // given : 어떠한 데이터가 준비되었을 때
        member = new Member();
        member.setMemberId("test001");
        member.setMemberPassword("password001");
        member.setMemberName("홍길동");

        member2 = new Member();
        member2.setMemberId("test002");
        member2.setMemberPassword("password002");
        member2.setMemberName("고길동");

        member3 = new Member();
        member3.setMemberId("test003");
        member3.setMemberPassword("password003");
        member3.setMemberName("이순신");
    }

    @Test
    @DisplayName("MemberManager 회원 등록 메서드 테스트")
    public void registerMember() {
        // given : 어떠한 데이터가 준비되었을 때
        // setUp 메서드로 뺌

        // when : 어떠한 함수를 실행하면
        memberManager.registerMember(member);
        memberManager.registerMember(member2);
        memberManager.registerMember(member3);


        Member checkMember = memberRepository.getMemberSelectOne(member.getMemberNo());
        Member checkMember2 = memberRepository.getMemberSelectOne(member2.getMemberNo());
        Member checkMember3 = memberRepository.getMemberSelectOne(member3.getMemberNo());

        // then : 어떠한 결과가 나와야 한다.
        assertThat(checkMember).isEqualTo(member);
        assertThat(checkMember2).isEqualTo(member2);
        assertThat(checkMember3).isEqualTo(member3);
    }
    
    @Test
    @DisplayName("MemberManager 회원 정보 갖고 오는 메서드 테스트")
    public void getMemberSelectOne() {
        // given
        memberManager.registerMember(member);
        memberManager.registerMember(member2);
        memberManager.registerMember(member3);

        // when
        Member testMember1 = memberManager.getMemberSelectOne(member.getMemberNo());
        Member testMember2 = memberManager.getMemberSelectOne(member2.getMemberNo());
        Member testMember3 = memberManager.getMemberSelectOne(member3.getMemberNo());

        // then
        assertThat(member).isEqualTo(testMember1);
        assertThat(member2).isEqualTo(testMember2);
        assertThat(member3).isEqualTo(testMember3);
    }

    @Test
    @DisplayName("MemberManager 회원 등록 여부 확인 메서드")
    public void isRegistered() {
        // given
        // setUp() 메서드
        memberManager.registerMember(member);
        memberManager.registerMember(member2);

        // when
        boolean test = memberManager.isRegistered(member);
        boolean test2 = memberManager.isRegistered(member2);
        boolean test3 = memberManager.isRegistered(member3);

        // then
        assertThat(true).isEqualTo(test);
        assertThat(true).isEqualTo(test2);
        assertThat(false).isEqualTo(test3);

    }


    @Test
    @DisplayName("MemberManager 회원 정보 업데이트 메서드 테스트")
    public void updateMemberInfo() {
        // given
        memberManager.registerMember(member);
        memberManager.registerMember(member2);
        memberManager.registerMember(member3);

        Member changeMember = memberManager.getMemberSelectOne(member.getMemberNo());
        changeMember.setMemberId("changeTest001");
        changeMember.setMemberPassword("changePassword001");
        changeMember.setMemberName("바뀐홍길동");

        Member changeMember2 = memberManager.getMemberSelectOne(member2.getMemberNo());
        changeMember2.setMemberId("changeTest002");
        changeMember2.setMemberPassword("changePassword002");
        changeMember2.setMemberName("바뀐고길동");

        Member changeMember3 = memberManager.getMemberSelectOne(member3.getMemberNo());
        changeMember3.setMemberId("changeTest003");
        changeMember3.setMemberPassword("changePassword003");
        changeMember3.setMemberName("바뀐이순신");

        // when
        memberManager.updateMemberInfo(changeMember.getMemberNo(), changeMember);
        memberManager.updateMemberInfo(changeMember2.getMemberNo(), changeMember2);
        memberManager.updateMemberInfo(changeMember3.getMemberNo(), changeMember3);

        // then
        assertThat(changeMember).isEqualTo(memberManager.getMemberSelectOne(changeMember.getMemberNo()));
        assertThat("changeTest001").isEqualTo(memberManager.getMemberSelectOne(changeMember.getMemberNo()).getMemberId());
        assertThat("changePassword001").isEqualTo(memberManager.getMemberSelectOne(changeMember.getMemberNo()).getMemberPassword());
        assertThat("바뀐홍길동").isEqualTo(memberManager.getMemberSelectOne(changeMember.getMemberNo()).getMemberName());

        assertThat(changeMember2).isEqualTo(memberManager.getMemberSelectOne(changeMember2.getMemberNo()));
        assertThat("changeTest002").isEqualTo(memberManager.getMemberSelectOne(changeMember2.getMemberNo()).getMemberId());
        assertThat("changePassword002").isEqualTo(memberManager.getMemberSelectOne(changeMember2.getMemberNo()).getMemberPassword());
        assertThat("바뀐고길동").isEqualTo(memberManager.getMemberSelectOne(changeMember2.getMemberNo()).getMemberName());

        assertThat(changeMember3).isEqualTo(memberManager.getMemberSelectOne(changeMember3.getMemberNo()));
        assertThat("changeTest003").isEqualTo(memberManager.getMemberSelectOne(changeMember3.getMemberNo()).getMemberId());
        assertThat("changePassword003").isEqualTo(memberManager.getMemberSelectOne(changeMember3.getMemberNo()).getMemberPassword());
        assertThat("바뀐이순신").isEqualTo(memberManager.getMemberSelectOne(changeMember3.getMemberNo()).getMemberName());

    }
}
