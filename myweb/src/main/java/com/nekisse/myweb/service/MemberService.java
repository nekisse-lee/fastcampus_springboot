package com.nekisse.myweb.service;

import com.nekisse.myweb.domain.memberrole.MemberRole;
import com.nekisse.myweb.domain.memberrole.MemberRoleRepository;
import com.nekisse.myweb.domain.member.Member;
import com.nekisse.myweb.domain.member.MemberRepository;
import com.nekisse.myweb.dto.MemberDto;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class MemberService {

    MemberRepository memberRepository;

    MemberRoleRepository memberRoleRepository;

    public Member addMember(MemberDto memberDto) {

        //파라미터로 들어온 memberDto(memberId, password, email
        //password 는 암호화하여 다시 설정

        PasswordEncoder passwordEncoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));


        Member member = Member.builder()
                .memberId(memberDto.getMemberId())
                .password(memberDto.getPassword())
                .email(memberDto.getEmail())
                .build();
        // MemberRole에 대한 설정도 해야한다. MemberRoleRepository 를 만든다.
        // role name이 "ROLE_USER"인 것을 읽어와서 Member 의 memberRoles 에 설정

        Set<MemberRole> memberRoles = new HashSet<>();
        memberRoles.add(memberRoleRepository.findByRoleName("ROLE_USER"));
        member.setMemberRoles(memberRoles);
        member = memberRepository.save(member);
        return member;

    }

    public String getMember(String memberId, String password, HttpSession session) {
        Member member = memberRepository.findByMemberId(memberId);
        if (member == null) {
            return "redirect:/login";
        }
        if (!password.equals(member.getPassword())) {
            return "redirect:login";
        }
        session.setAttribute("member", member);
        return null;
    }


    public Member getMemberByMemberId(String memberId) {
        return memberRepository.findByMemberId(memberId);
    }






}
