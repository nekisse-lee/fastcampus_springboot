package com.nekisse.myweb.controller;

import com.nekisse.myweb.domain.board.Board;
import com.nekisse.myweb.dto.BoardDto;
import com.nekisse.myweb.service.BoardService;
import com.nekisse.myweb.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/board")
@AllArgsConstructor
public class BoardController {

    private BoardService boardService;

    private MemberService memberService;


    //  /boards    1page를 보여준다.
    //  /boards?page=1
    //  /boards?page=2
    @GetMapping("")
    public String boardList(
            Principal principal,
            @RequestParam(name = "page",
                    required = false,
                    defaultValue = "1")
                    int page, ModelMap modelMap){
        if(principal != null)
            System.out.println("pricipal name :" + principal.getName());
        Page<Board> boardList = boardService.getBoards(page);

        /*List<Board> boardList = boardService.getBoardList();

        modelMap.addAttribute("boardList", boardList);*/
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
        return "redirect:/board";
    }

    @GetMapping("/writeboard")
    public String writeBoard() {
        return "/write/writeboard";
    }





}
