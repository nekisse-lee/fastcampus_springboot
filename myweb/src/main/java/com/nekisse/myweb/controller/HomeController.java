package com.nekisse.myweb.controller;


import com.nekisse.myweb.domain.user.User;
import com.nekisse.myweb.domain.user.UserRepository;
import com.nekisse.myweb.dto.UserDto;
import com.nekisse.myweb.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
@AllArgsConstructor
public class HomeController {
    private UserService userService;
    private UserRepository userRepository;

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


    @GetMapping("/post")
    public String post() {
        return "post";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String userId, String password, HttpSession session) {
        String x = userService.getUser(userId, password, session);
        if (x != null) return x;
        return "redirect:/";
    }



    @GetMapping("/join" )
    public String join() {
        return "join";
    }

    @PostMapping("/adduser" )
    public String join(@ModelAttribute UserDto userDto) {
        userService.addUser(userDto);
        return "redirect:/";
    }


}
