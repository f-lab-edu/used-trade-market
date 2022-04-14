package com.market.controller;

import com.market.exception.UserNotFoundException;
import com.market.dto.MemberDTO;
import com.market.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * 회원 관리 기능 구현 클래스
 *
 * @author 배영현
 * @version 1.0
 * */
@Slf4j
@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 회원 정보인 <code>member</code>를 통해 회원이 서비스를 이용할 수 있도록 가입을 할 수 있도록 한다.
     * @param member 회원 정보 입력
     * */
    @PostMapping
    public EntityModel<MemberDTO> registerMember(@Valid @RequestBody @Nonnull MemberDTO member) {
        if(member == null) {
            throw new NullPointerException();
        }
        log.info("Member register method");
        log.debug("parameter : " , member);
        memberService.registerMember(member);

        // HATEOAS 적용
        EntityModel<MemberDTO> entityModel = EntityModel.of(member);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getMembers());
        entityModel.add(linkTo.withRel("all-members"));

        WebMvcLinkBuilder linkTo2 = linkTo(methodOn(this.getClass()).getMemberSelectOne(member.getMemberNo()));
        entityModel.add(linkTo2.withRel("register-member-info"));

        log.info("success register member");

        return entityModel;
    }

    /**
     * 모든 회원의 정보를 반환한다.
     * */
    @GetMapping
    public List<MemberDTO> getMembers() {
        return memberService.getMembers();
    }

    /**
     * <code>memberNo</code>인 회원 정보를 갖는 회원을 회원 객체를 갖고 오는 메소드
     * */
    @GetMapping("/{memberNo}")
    public EntityModel<MemberDTO> getMemberSelectOne(@PathVariable @RequestBody @Nonnull Long memberNo) {
        if(memberNo == null) {
            throw new NullPointerException();
        }
        MemberDTO member = memberService.getMemberSelectOne(memberNo);
        if(member == null) {
            throw new UserNotFoundException("ID[" + memberNo +"]" +"not found");
        }

        // HATEOAS 적용
        EntityModel<MemberDTO> entityModel = EntityModel.of(member);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getMembers());
        entityModel.add(linkTo.withRel("all-members"));

        return entityModel;
    }

    /**
     * 회원 탈퇴 메서드로 <code>memberNo</code>를 갖는 회원의 정보를 삭제한다.
     * */
    @DeleteMapping("/{memberNo}")
    public EntityModel<MemberDTO> deleteMember(@PathVariable @Nonnull Long memberNo) {
        if(memberNo == null) {
            throw new UserNotFoundException("탈퇴할 회원 정보가 없습니다.");
        }

        MemberDTO member = memberService.getMemberSelectOne(memberNo);

        // HATEOAS 적용
        EntityModel<MemberDTO> entityModel = EntityModel.of(member);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getMembers());
        entityModel.add(linkTo.withRel("all-members"));

        memberService.deleteMember(memberNo);

        return entityModel;
    }



    /**
     * <code>memberNo</code>의 회원번호와 <code>memberInfo</code>인 회원 정보를 갖는 회원의 정보를
     * <code>memberList</code>라는 회원 저장 테이블 변경 내용을 저장하는 메소드
     * @param memberInfo    회원 정보
     * */
    @PutMapping
    public EntityModel<MemberDTO> updateMemberInfo(@RequestBody @Nonnull MemberDTO memberInfo) {
        if(memberInfo == null) {
            throw new NullPointerException();
        }

        memberService.updateMemberInfo(memberInfo);

        // HATEOAS 적용
        EntityModel<MemberDTO> entityModel = EntityModel.of(memberInfo);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getMemberSelectOne(memberInfo.getMemberNo()));
        entityModel.add(linkTo.withRel("udpate-member-info"));

        WebMvcLinkBuilder linkTo2 = linkTo(methodOn(this.getClass()).getMembers());
        entityModel.add(linkTo2.withRel("all-members"));

        return entityModel;
    }

    /**
     * 회원만 사용할 수 있도록 체크하는 메서드
     * 회원 정보가 <code>member</code>인 객체를 확인하고 정보가 없으면 false를 반환하고 정보가 있으면 true를 반환한다.
     * @param member
     * @return result
     * */
    public boolean isRegistered(@Nullable MemberDTO member) {
        log.info("isRegistered Method");
        boolean result = true;

        if(member.getMemberNo() == null) {
            result = false;
        }

        return result;
    }

    /**
     * 로그인 화면으로 보내는 메소드로 로그인 되어 있지 않은 경우에 호출되는 메소드
     * */
    public void goLogin() {
        log.info("-------------------------");
        log.info("Go login");
        log.info("-------------------------");
    }


}
