package com.ceos21.vote.domain.candidate.dto;

import com.ceos21.vote.domain.candidate.domain.Candidate;

public record CandidateListResponse(
        Long id,
        String name
) {
    public static CandidateListResponse from(Candidate candidate) {
        return new CandidateListResponse(
                candidate.getId(),
                candidate.getName()
        );
    }
}
