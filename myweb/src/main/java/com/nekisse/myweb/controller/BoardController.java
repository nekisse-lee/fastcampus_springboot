package com.nekisse.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boardlist")
public class BoardController {



    @GetMapping("")
    public String recommendationBoard() {
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



}
