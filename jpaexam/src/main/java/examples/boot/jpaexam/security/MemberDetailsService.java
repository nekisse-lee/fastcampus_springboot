package examples.boot.jpaexam.security;

import examples.boot.jpaexam.domain.Member;
import examples.boot.jpaexam.domain.MemberRole;
import examples.boot.jpaexam.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Component
public class MemberDetailsService implements UserDetailsService {
    @Autowired
    MemberService memberService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        //email에 해당하는 Member정보를 구한다.
        Member member = memberService.getMemberByEmail(email);
        if(member == null){
            throw new UsernameNotFoundException(email + " not found!");
        }

        // UserDetails를 구현하고 있는 객체를 생성(email, password, 권한목록)
        /// 해당 객체를 리턴.
        List<GrantedAuthority> list = new ArrayList<>();
        for(MemberRole memberRole :  member.getMemberRoles()){
            list.add(new SimpleGrantedAuthority(memberRole.getName()));
        }
        MemberLoginInfo userDetails =
                new MemberLoginInfo(member.getEmail(), member.getPassword(), list);
        userDetails.setId(member.getId());
        userDetails.setName(member.getName());

        return userDetails;
    }
}
