package com.nekisse.myweb.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.Email;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {

    String memberId;

    String password;

    @Email
    String email;


    @Builder
    public MemberDto(String memberId, String password, String email) {
        this.memberId = memberId;
        this.password = password;
        this.email = email;
    }
}
