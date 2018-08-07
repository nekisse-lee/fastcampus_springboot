package com.nekisse.shop.controller.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nekisse.shop.dto.Member;
import org.springframework.web.bind.annotation.*;


//@Controller  // @ResponseBody가 안붙었을 경우엔 메소드가 리턴 하는 값은 view  name이다.

//ResponseBody // 컨트롤러 메소드가 리턴하는 값을 응답 바디로 전달.
@RestController
@RequestMapping("/api/members")
public class MemberApiController {


    @GetMapping("/member1")
    public String member1() {
        return "member1";
    }

    @GetMapping("/member2")
    public Member member2() {
        Member member = new Member(1L, "kim", "urstory@gmail.com");
        return member;
    }


    // /member3?name=kim&id=5           //파라미터는 모두 문자열로 구성되어 있다.
    @GetMapping("/member3")
    public Member member3(@RequestParam(name = "name", required = true) String name,
                  @RequestParam(name = "id", required = false, defaultValue = "1") Long id) {
        Member member = new Member(id, name, "");
        return member;
    }

    // /member3?name=kim&id=5           //파라미터는 모두 문자열로 구성되어 있다.
    //@ModelAttribute를  사용하면 파라미터 이름과 같은 프로퍼티 값이 설정된다.
    @GetMapping("/member4")
    public Member member4(@ModelAttribute Member member) {
        return member;
    }

    @PostMapping("/member5")
    public String member5() {
        return "member5";
    }


    @PostMapping("/member6")
    public Member member6(@RequestParam(name = "name", required = true) String name,
                   @RequestParam(name = "id", required = false, defaultValue = "1") Long id) {
        Member member = new Member(id, name, "");
        return member;
    }


    @PostMapping("/member7")
    public Member member7(@RequestBody Member member) {
        return member;
    }

    @GetMapping("/member8/{id}")
    public String member8(@PathVariable(name = "id") String id) {
        return id;
    }




}
