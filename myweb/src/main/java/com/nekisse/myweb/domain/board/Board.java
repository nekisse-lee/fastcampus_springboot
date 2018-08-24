package com.nekisse.myweb.domain.board;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.nekisse.myweb.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@Table(name = "board")
@NoArgsConstructor
public class Board {
    public static Board newInstance() {
        return new Board();
    }

//    private  List<Board> boardList = new ArrayList<>();


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_seq" )
    private long seq;


    private String title;
    private String location;
    private String img;
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDate reportingDate;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_seq")
    private User user;



    @Builder
    public Board(String title, String description, String location, String img, LocalDate reportingDate) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.img = img;
        this.reportingDate = LocalDate.now();
    }
}
