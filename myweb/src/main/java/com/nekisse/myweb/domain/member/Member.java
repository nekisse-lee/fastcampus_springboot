package com.nekisse.myweb.domain.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nekisse.myweb.Util.TimeEntity;
import com.nekisse.myweb.domain.board.Board;
import com.nekisse.myweb.domain.memberrole.MemberRole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "member")
@NoArgsConstructor
public class Member extends TimeEntity {


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

    @Column(name = "join_date")
    private LocalDateTime localDateTime;


    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Board> boardList;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "member_board",
            joinColumns = @JoinColumn(name = "member_seq"),
            inverseJoinColumns = @JoinColumn(name = "board_seq")
    )
    private List<Board> userBoards = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "member_member_role",
            joinColumns = @JoinColumn(name = "member_seq"),
            inverseJoinColumns = @JoinColumn(name = "role_seq")
    )
    public Set<MemberRole> memberRoles = new HashSet<>();


    public boolean isSameUser(String memberId) {
        return this.memberId.equals(memberId);
    }







    @Builder
    public Member(String memberId, String password, String email ) {
        this.memberId = memberId;
        this.password = password;
        this.email = email;
        this.localDateTime = LocalDateTime.now();
    }




}
