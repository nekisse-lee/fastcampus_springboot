package com.nekisse.myweb.controller;


import com.nekisse.myweb.dto.MemberDto;
import com.nekisse.myweb.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("")
@AllArgsConstructor
public class HomeController {
    private MemberService memberService;

    @GetMapping("/" )
    public String home(String name, Model model) {
        model.addAttribute("aaa", name);
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


/*
    @GetMapping("/post")
    public String post() {
        return "post";
    }
*/

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String userId, String password, HttpSession session) {
        String x = memberService.getMember(userId, password, session);
        if (x != null) {return x;}

        return "redirect:/";
    }



    @GetMapping("/join" )
    public String join() {
        return "join";
    }


    //@Valid ..
    @PostMapping("/adduser" )
    public String join(@ModelAttribute @Valid MemberDto memberDto) {
        memberService.addMember(memberDto);
        return "redirect:/";
    }


}
