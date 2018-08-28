package com.nekisse.myweb.controller;

import com.nekisse.myweb.domain.board.Board;
import com.nekisse.myweb.dto.BoardDto;
import com.nekisse.myweb.service.BoardService;
import com.nekisse.myweb.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/boardlist")
@AllArgsConstructor
public class BoardController {

    private BoardService boardService;

    private MemberService memberService;

    @GetMapping("")
    public String boardList(ModelMap modelMap) {
        List<Board> boardList = boardService.getBoardList();
        modelMap.addAttribute("boardList", boardList);
        return "boardlist";
    }



    @PostMapping("/add")
    public String createBoard(@Valid @ModelAttribute BoardDto boardDto, BindingResult createError) {
        //custom validation
        /*
        if (createError.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }*/

        /*return ResponseEntity.ok("redirect:/boardlist");*/

        if (createError.hasErrors()) {
            return "redirect:/";
        }
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
