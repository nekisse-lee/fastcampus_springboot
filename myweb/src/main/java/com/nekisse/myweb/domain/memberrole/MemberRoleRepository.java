package com.nekisse.myweb.domain.memberrole;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRoleRepository extends JpaRepository<MemberRole, Long> {
    public MemberRole findByRoleName(String roleName);
}
