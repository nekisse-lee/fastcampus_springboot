package com.nekisse.myweb.service;

import com.nekisse.myweb.domain.user.Member;
import com.nekisse.myweb.domain.user.MemberRepository;
import com.nekisse.myweb.dto.MemberDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Service
@Transactional
@AllArgsConstructor
public class UserService {

    MemberRepository memberRepository;

    public void addUser(MemberDto memberDto) {
        Member member = Member.builder()
                .memberId(memberDto.getMemberId())
                .password(memberDto.getPassword())
                .email(memberDto.getEmail())
                .build();
        memberRepository.save(member);
    }

    public String getUser(String userId, String password, HttpSession session) {
        Member member = memberRepository.findByMemberId(userId);
        if (member == null) {
            return "redirect:/login";
        }
        if (!password.equals(member.getPassword())) {
            return "redirect:login";
        }
        session.setAttribute("member", member);
        return null;
    }






}
