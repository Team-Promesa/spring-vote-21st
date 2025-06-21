package com.ceos21.vote.domain.candidate.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Candidate {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id")
    private Long id;

    @NotBlank
    private String name;

    @Column(name = "vote_count")
    private int voteCount;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "vote_type")
    private VoteType voteType;

    public void addVote() {
        this.voteCount += 1;
    }
}
