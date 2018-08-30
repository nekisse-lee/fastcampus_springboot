package com.nekisse.myweb.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByMemberId(String userId);


    Member findByEmail(String email);
}
