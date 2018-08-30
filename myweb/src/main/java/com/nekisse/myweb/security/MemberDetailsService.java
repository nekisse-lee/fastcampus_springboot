package com.nekisse.myweb.security;

import com.nekisse.myweb.domain.member.Member;
import com.nekisse.myweb.domain.member.MemberRepository;
import com.nekisse.myweb.domain.memberrole.MemberRole;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class MemberDetailsService implements UserDetailsService {

    MemberRepository memberRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        //memberId 에 해당하는 member 정보를 구한다.
        Member member = memberRepository.findByMemberId(memberId);
        if (member == null) {
            throw new UsernameNotFoundException(memberId + " not found !");
        }

        List<GrantedAuthority> list = new ArrayList<>();
        for (MemberRole memberRole : member.getMemberRoles()) {
            list.add(new SimpleGrantedAuthority(memberRole.getRoleName()));
        }

        //UserDetails 를 구현하고 있는 객체를 생성( email, password, 권한목록)
        MemberLoginInfo  userDetails =
                new MemberLoginInfo(member.getMemberId(), member.getPassword(), list);
        userDetails.setName(member.getMemberId());



        //해당객체 리턴
        return userDetails;
    }
}
