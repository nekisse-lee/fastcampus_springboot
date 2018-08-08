package com.nekisse.myweb.controller.apicontroller;

import com.nekisse.myweb.dto.BoardDto;
import com.nekisse.myweb.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/*@RestController
@RequestMapping("/api/boardlist")
@AllArgsConstructor*/
public class ApiBoardController {
    private BoardService boardService;

/*
    @PostMapping("/add")
    public void createBoard(@ModelAttribute BoardDto boardDto) {
        boardService.createBoard(boardDto);
    }
*/

}
