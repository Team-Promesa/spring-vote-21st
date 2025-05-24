package com.ceos21.vote.domain.member.dao;

import com.ceos21.vote.domain.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findMemberByNameAndProvider(String name, String provider);
}
