package com.nekisse.myweb.domain.board;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.nekisse.myweb.domain.boardcatecory.BoardCategory;
import com.nekisse.myweb.domain.user.Member;
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
    @JoinColumn(name = "member_seq")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_seq")
    private BoardCategory boardCategory;

    /*//어떤 파일을 가지고 있느냐
    @OneToMany(mappedBy = "board" ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BoardFile> boardFiles;*/



    @Builder
    public Board(String title, String description, String location, String img, LocalDate reportingDate) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.img = img;
        this.reportingDate = LocalDate.now();
    }
}
