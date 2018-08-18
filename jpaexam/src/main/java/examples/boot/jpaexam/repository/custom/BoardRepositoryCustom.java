package examples.boot.jpaexam.repository.custom;

import examples.boot.jpaexam.domain.Board;

//dynamic     jpql로 or 복잡한 jpql로 실행해야할 메소드가 선언.
public interface BoardRepositoryCustom {
    public Board getBoardByDsl(Long id);


}
