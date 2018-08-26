package com.nekisse.myweb.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nekisse.myweb.domain.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "member")
@NoArgsConstructor
public class Member {


    @Id
    @Column(name = "member_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @JsonProperty
    @Column(unique = true)
    private String memberId;

    @JsonProperty
    private String password;


    @JsonProperty
    @Column(unique = true)
    private String email;


    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Board> boardList;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_board",
            joinColumns = @JoinColumn(name = "user_seq"),
            inverseJoinColumns = @JoinColumn(name = "board_seq")
    )
    private List<Board> userBoards = new ArrayList<>();

    @Builder
    public Member(String memberId, String password, String email) {
        this.memberId = memberId;
        this.password = password;
        this.email = email;
    }
}
