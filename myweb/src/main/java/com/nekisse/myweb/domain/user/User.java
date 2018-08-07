package com.nekisse.myweb.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class User {


    @Id
    @Column(name = "user_seq")
    @GeneratedValue
    private Long seq;

    private String userId;
    private String password;
    private String email;

}
