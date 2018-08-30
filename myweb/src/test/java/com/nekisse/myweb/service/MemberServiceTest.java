package com.nekisse.myweb.service;

import com.nekisse.myweb.domain.memberrole.MemberRole;
import com.nekisse.myweb.domain.member.Member;
import com.nekisse.myweb.dto.MemberDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {
    @Autowired
    MemberService memberService;

    private Member member = new Member();

    @Test
    public void memberAdd() {
        MemberDto memberDto = MemberDto.builder()
                .memberId("lee")
                .password("1111")
                .email("lee@gmail.com")
                .build();
        member = memberService.addMember(memberDto);

        System.out.println(member.getEmail());

        Member member2 = memberService.getMemberByMemberId("lee");
        for (MemberRole memberRole : member2.getMemberRoles()) {
            System.out.println(memberRole.getRoleName());
        }

        System.out.println("member.getPassword() = " + member.getPassword());

    }

}
