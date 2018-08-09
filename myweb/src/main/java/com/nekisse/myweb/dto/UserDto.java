package com.nekisse.myweb.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    @JsonProperty
    String userId;
    @JsonProperty
    String password;
    @JsonProperty
    String email;


    @Builder
    public UserDto(String userId, String password, String email) {
        this.userId = userId;
        this.password = password;
        this.email = email;
    }
}
