package com.nekisse.myweb.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nekisse.myweb.domain.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "user")
@NoArgsConstructor
public class User {


    @Id
    @Column(name = "user_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    @JsonProperty
    private String userId;
    @JsonProperty
    private String password;
    @JsonProperty
    private String email;


//    @OneToMany
//    private Board board;

    @Builder
    public User(String userId, String password, String email) {
        this.userId = userId;
        this.password = password;
        this.email = email;
    }
}
