package com.nekisse.myweb.controller;

import com.nekisse.myweb.domain.board.Board;
import com.nekisse.myweb.domain.board.BoardRepository;
import com.nekisse.myweb.dto.BoardDto;
import com.nekisse.myweb.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/boardlist")
@AllArgsConstructor
public class BoardController {

    private BoardService boardService;

    private BoardRepository boardRepository;

    @GetMapping("")
    public String boardList(ModelMap modelMap) {
        List<Board> boardList = boardRepository.findAll();
        modelMap.addAttribute("boardList", boardList);
        return "boardlist";
    }

    @GetMapping("/writeboard")
    public String writeBoard() {
        return "/write/writeboard";
    }

    @GetMapping("/test")
    public String writeBoard2() {
        return "test";
    }

    @PostMapping("/add")
    public String createBoard(@ModelAttribute BoardDto boardDto) {
        boardService.createBoard(boardDto);
        return "redirect:/boardlist";
    }


}
