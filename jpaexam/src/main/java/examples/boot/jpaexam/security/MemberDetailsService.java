package examples.boot.jpaexam.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class MemberDetailsService implements UserDetailsService {

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //email에 해당하는 Member정보를 구한다.

        // UserDetails를 구현하고 있는 객체를 생성(email, password, 권한목록)

        /// 해당 객체를 리턴.
        return null;
    }
}
