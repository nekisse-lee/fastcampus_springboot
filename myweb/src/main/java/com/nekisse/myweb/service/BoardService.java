package com.nekisse.myweb.service;

import com.nekisse.myweb.domain.board.Board;
import com.nekisse.myweb.domain.board.BoardRepository;
import com.nekisse.myweb.dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class BoardService {
    BoardRepository boardRepository;


    public void createBoard(BoardDto boardDto) {
        Board board = Board.builder()
                .title(boardDto.getTitle())
                .description(boardDto.getDescription())
                .location(boardDto.getLocation())
                .img(boardDto.getImg())
                .build();

        boardRepository.save(board);
    }


    public List<Board> getBoardList() {
            return boardRepository.findAll();
        }
}
