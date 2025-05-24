package com.ceos21.vote.domain.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Member {
    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String name;    // 로그인한 사용자 이름

    private String provider;    // 사용자가 로그인한 서비스 (ex.google, kakao, naver)

    public Member updateMember(String name){
        this.name = name;
        return this;
    }
}
