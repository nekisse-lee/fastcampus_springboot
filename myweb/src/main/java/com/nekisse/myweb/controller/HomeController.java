package com.nekisse.myweb.controller;


import com.nekisse.myweb.dto.MemberDto;
import com.nekisse.myweb.security.MemberLoginInfo;
import com.nekisse.myweb.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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
        model.addAttribute("isLogin", isAuthenticated());
        return "index";
    }

    private boolean isAuthenticated() {
        SecurityContext context = SecurityContextHolder.getContext();
        if(context == null) {
            return false;
        }
        Authentication authentication = context.getAuthentication();
        if(authentication == null) {
            return false;
        }
        Object principal = authentication.getPrincipal();
        if(principal == null) {
            return false;
        }
        return principal instanceof MemberLoginInfo;
    }

    @GetMapping("/hotissue")
    public String contact() {
        return "hotissue";
    }

    @PostMapping("/hotissue/add")
    public String addhotissue() {
        return "";
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

/*
    @PostMapping("/login")
    public String login(String userId, String password, HttpSession session) {
        String x = memberService.getMember(userId, password, session);
        if (x != null) {return x;}

        return "redirect:/";
    }
*/



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
