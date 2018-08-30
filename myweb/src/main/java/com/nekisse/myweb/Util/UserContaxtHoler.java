package com.nekisse.myweb.Util;

import com.nekisse.myweb.domain.member.Member;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserContaxtHoler {
    public static Member get() {
        return (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static void validate(String id) {
        if(!get().isSameUser(id)) {
            throw new AccessDeniedException("잘못된 요청입니다.");
        }
    }

}
