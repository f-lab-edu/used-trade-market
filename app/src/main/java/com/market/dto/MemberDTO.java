package com.market.dto;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 회원 일반 기능 정의 클래스
 *
 * @author 배영현
 * @version 1.0
 * */
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "사용자 상세 정보를 위한 도메인 객체")
public class MemberDTO implements Serializable {

    /**
     * 회원 번호
     * */
    private Long memberNo;

    /**
     * 회원 아이디
     * */
    @NotNull
    private String memberId;

    /**
     * 회원 비밀번호
     * */
    @NotNull
    private String memberPassword;

    /**
     * 회원 이름
     * */
    @NotNull
    @Size(min = 2, message = "이름은 2글자 이상 입력해 주세요.")
    @ApiModelProperty(notes =  "사용자 이름을 입력해 주세요.")
    private String memberName;

    /**
     * 주소
     * */
    @NotEmpty
    @ApiModelProperty(notes =  "사용자 주소를 입력해 주세요.")
    private String address;

    /**
     * 포인트
     * */
    private int point;

    /**
     * 회원 역할
     * */
    private String memberRole;

    /**
     * 유저 이메일
     * */
    @Email
    private String memberEmail;

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.memberPassword = passwordEncoder.encode(this.memberPassword);
    }
}
