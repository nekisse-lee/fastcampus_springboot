package examples.boot.jpaexam.repository.custom;

import com.querydsl.jpa.JPQLQuery;
import examples.boot.jpaexam.domain.Board;
import examples.boot.jpaexam.domain.QBoard;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class BoardRepositoryImpl extends QuerydslRepositorySupport implements BoardRepositoryCustom {


    public BoardRepositoryImpl() {
        super(Board.class);     //부모에게 사용할 Entity 클래스를 설정
    }


    //@Query("select b from Board b where b.id = :id")
    @Override
    public Board getBoardByDsl(Long id) {

        QBoard qBoard = QBoard.board;
//        JPQLQuery<Board> jpqlQuery = from(qBoard); // FROM Board
//        jpqlQuery = jpqlQuery.where(qBoard.id.eq(id));  // FROM BOARD Where b.id = :id
//          return jpqlQuery.fetchOne()
        return from(qBoard).where(qBoard.id.eq(id)).fetchOne();
    }

}
