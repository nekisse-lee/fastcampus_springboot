package com.nekisse.firstweb;


import org.springframework.web.bind.annotation.GetMapping;

@AA  //  = @RestController
public class HelloController {

    public HelloController() {
        System.out.println("HelloController 생성자");
    }

    @GetMapping("/hello")
    public String hello() {
        System.out.println("console hello()");
        return "hello";
    }
}
