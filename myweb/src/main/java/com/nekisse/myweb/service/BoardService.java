package com.nekisse.myweb.service;

import com.nekisse.myweb.domain.board.Board;
import com.nekisse.myweb.domain.board.BoardRepository;
import com.nekisse.myweb.dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class BoardService {
    BoardRepository boardRepository;


    public void createBoard(BoardDto boardDto) {
        Board board = Board.builder()
                .title(boardDto.getTitle())
                .description(boardDto.getDescription())
                .location(boardDto.getLocation())
                .img(boardDto.getImg())
                .reportingDate(LocalDate.now())
                .build();

        boardRepository.save(board);
    }


}
