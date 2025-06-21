package com.ceos21.vote.domain.vote.dto;

import com.ceos21.vote.domain.candidate.domain.VoteType;

public record VoteResponse(
        String message,
        Long votedCandidateId,
        VoteType voteType
) {
    public static VoteResponse from(VoteType voteType, Long candidateId) {
        return new VoteResponse(
                voteType.name() + " 투표가 완료되었습니다.",
                candidateId,
                voteType
        );
    }
}

