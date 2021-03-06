package com.nekisse.myweb.service;

import com.nekisse.myweb.Util.UserContextHolder;
import com.nekisse.myweb.domain.board.Board;
import com.nekisse.myweb.domain.board.BoardRepository;
import com.nekisse.myweb.dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public void createBoard2(BoardDto boardDto) {
        Board board = Board.newInstance();
        board.create(
                boardDto.getTitle(),
                boardDto.getLocation(),
                boardDto.getDescription(),
                boardDto.getImg(),
                UserContextHolder.get()
        );

    }


    public List<Board> getBoardList() {
            return boardRepository.findAll();
        }


    public Page<Board> getBoards(int page) {
        Pageable pageable = PageRequest.of(page - 1, 4);
        return boardRepository.getBoards(pageable);
    }
}
