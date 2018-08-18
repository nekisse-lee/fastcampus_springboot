package examples.boot.jpaexam.repository;

import examples.boot.jpaexam.domain.Board;
import examples.boot.jpaexam.repository.custom.BoardRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom {

    public Board getBoardById(Long id);  //method query 의 추가

    @Query("select b from  Board b where b.id= :id")
    public Board getBoard(@Param("id") Long id);


    @Query("SELECT distinct b FROM Board b left join fetch b.boardFiles order by b.id")
    public List<Board> getBoards();

}
