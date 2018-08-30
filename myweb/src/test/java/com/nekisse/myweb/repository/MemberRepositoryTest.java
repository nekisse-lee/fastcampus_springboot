package com.nekisse.myweb.repository;

import com.nekisse.myweb.domain.memberrole.MemberRole;
import com.nekisse.myweb.domain.member.Member;
import com.nekisse.myweb.domain.member.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@DataJpaTest
@RunWith(SpringRunner.class)
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    
    @Test
    public void getRoles() {
        Member member = memberRepository.getOne(1L);


        Set<MemberRole> memberRoles = member.getMemberRoles();

        for (MemberRole memberRole : memberRoles) {
            System.out.println("memberRole.getRoleName() = " + memberRole.getRoleName());
        }
    }
}
