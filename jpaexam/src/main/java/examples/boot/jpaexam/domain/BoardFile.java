package examples.boot.jpaexam.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "board_file")
@Getter
@Setter
public class BoardFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Board
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    private String mimeType;
    private String name; // 오리지널 파일 이름

    @Column(name = "save_file_name")
    private String saveFileName;  // c://tmp/2018/08/13/uuid명
    private long size;



}
