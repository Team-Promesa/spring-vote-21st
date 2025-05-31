package com.ceos21.vote.domain.member.domain;

import com.ceos21.vote.common.domain.BaseTimeEntity;
import com.ceos21.vote.common.security.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@AllArgsConstructor
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PartType part;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TeamType team;

    @NotBlank
    private String email;

    @NotBlank
    private String identifier;

    @NotBlank
    private String password;

    private boolean isBELeaderVoted = false;
    private boolean isFELeaderVoted = false;
    private boolean isDemoDayVoted = false;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;
}