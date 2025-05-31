package com.ceos21.vote.domain.member.domain;

import com.ceos21.vote.common.domain.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    private boolean isPartLeaderVoted;
    private boolean isDemoDayVoted;
}