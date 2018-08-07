package com.nekisse.myweb.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/hotissue")
    public String contact() {
        return "hotissue";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }


    @GetMapping("/post")
    public String post() {
        return "post";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }



}
