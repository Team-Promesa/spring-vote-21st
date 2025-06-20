package com.ceos21.vote.domain.candidate.dto;

import com.ceos21.vote.domain.candidate.domain.Candidate;

public record CandidateResultResponse(
        Long id,
        String name,
        int voteCount
) {
    public static CandidateResultResponse from(Candidate candidate) {
        return new CandidateResultResponse(
                candidate.getId(),
                candidate.getName(),
                candidate.getVoteCount()
        );
    }
}

