package com.nekisse.myweb.domain.board;


import com.nekisse.myweb.Util.TimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

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

    private LocalDate reportingDate;


    @Builder
    public Board(String title, String description, String location, String img, LocalDate reportingDate) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.img = img;
        this.reportingDate = LocalDate.now();
    }
}
