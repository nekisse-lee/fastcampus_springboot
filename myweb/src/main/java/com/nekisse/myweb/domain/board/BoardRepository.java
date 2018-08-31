package com.nekisse.myweb.domain.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board, Long> {

/*    @Query("SELECT b FROM Board b order by b.id desc")
    public Page<Board> getBoards(Pageable page);*/

    @Query(value = "SELECT distinct b FROM Board b join fetch b.member order by b.id desc",
            countQuery = "SELECT count(b) FROM Board b")
    public Page<Board> getBoards(Pageable page);

}
