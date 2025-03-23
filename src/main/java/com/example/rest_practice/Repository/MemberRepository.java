package com.example.rest_practice.Repository;

import com.example.rest_practice.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
    boolean existsByUsername(String username);
}
