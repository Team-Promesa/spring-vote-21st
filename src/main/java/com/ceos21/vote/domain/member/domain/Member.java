package com.ceos21.vote.domain.member.domain;

import com.ceos21.vote.common.domain.BaseTimeEntity;
import com.ceos21.vote.common.security.UserRole;
import com.ceos21.vote.domain.candidate.domain.VoteType;
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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    private boolean isBeLeaderVoted = false;
    private boolean isFeLeaderVoted = false;
    private boolean isDemoDayVoted = false;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    public boolean hasVotedFor(VoteType voteType) {
        return switch (voteType) {
            case BE_LEADER -> isBeLeaderVoted;
            case FE_LEADER -> isFeLeaderVoted;
            case DEMO_DAY -> isDemoDayVoted;
        };
    }

    public void markVoted(VoteType voteType) {
        switch (voteType) {
            case BE_LEADER -> this.isBeLeaderVoted = true;
            case FE_LEADER -> this.isFeLeaderVoted = true;
            case DEMO_DAY -> this.isDemoDayVoted = true;
        }
    }
}