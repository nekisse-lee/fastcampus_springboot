package com.nekisse.myweb.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    public Board getBoardById(Long id); // method query의 추가

    @Query("SELECT b FROM Board b WHERE b.id = :id")
    public Board getBoard(@Param("id") Long id);

    @Query("SELECT distinct b FROM Board b left join fetch b.boardFiles order by b.id")
    public List<Board> getBoards();
}
