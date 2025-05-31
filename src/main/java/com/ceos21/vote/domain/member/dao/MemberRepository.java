package com.ceos21.vote.domain.member.dao;

import com.ceos21.vote.domain.member.domain.Member;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByIdentifier(String identifier);
    Optional<Member> findByEmail(String email);
}