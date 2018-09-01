package com.nekisse.myweb.domain.board;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.nekisse.myweb.Util.TimeEntity;
import com.nekisse.myweb.domain.boardcatecory.BoardCategory;
import com.nekisse.myweb.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@Table(name = "board")
@NoArgsConstructor
public class Board extends TimeEntity {
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



    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_seq", insertable = false, updatable = false)
    private Member member;

    @Column(name = "member_seq")
    private Long memberSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_seq")
    private BoardCategory boardCategory;

    /*//어떤 파일을 가지고 있느냐
    @OneToMany(mappedBy = "board" ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BoardFile> boardFiles;*/

    @Column(name = "read_count")
    private Long readCount;

    @Column(name = "like_count")
    private Long likeCount;




    @Builder
    public Board(String title, String location, String img, String description,  Member member,@Nullable BoardCategory boardCategory, @Nullable Long readCount, @Nullable Long likeCount) {
        this.title = title;
        this.location = location;
        this.img = img;
        this.description = description;
        this.member = member;
        this.boardCategory = boardCategory;
        this.readCount = readCount;
        this.likeCount = likeCount;
    }


    public void update(String title, String location, String img, String description, Member member ) {
        this.title = title;
        this.location = location;
        this.img = img;
        this.description = description;
        this.memberSeq = member.getSeq();

    }

    public void create(String title, String location, String img, String description, Member member ) {
        this.title = title;
        this.location = location;
        this.img = img;
        this.description = description;
        this.memberSeq = member.getSeq();

    }
}
