package com.nekisse.myweb.controller;

import com.nekisse.myweb.domain.board.Board;
import com.nekisse.myweb.domain.board.BoardRepository;
import com.nekisse.myweb.dto.BoardDto;
import com.nekisse.myweb.dto.UserDto;
import com.nekisse.myweb.service.BoardService;
import com.nekisse.myweb.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/boardlist")
@AllArgsConstructor
public class BoardController {

    private BoardService boardService;

    private UserService userService;

    @GetMapping("")
    public String boardList(ModelMap modelMap) {
        List<Board> boardList = boardService.getBoardList();
        modelMap.addAttribute("boardList", boardList);
        return "boardlist";
    }



    @PostMapping("/add")
    public String createBoard(@ModelAttribute BoardDto boardDto) {
        boardService.createBoard(boardDto);
        return "redirect:/boardlist";
    }

    @GetMapping("/writeboard")
    public String writeBoard() {
        return "/write/writeboard";
    }

    @GetMapping("/test")
    public String writeBoard2() {
        return "test";
    }



}
