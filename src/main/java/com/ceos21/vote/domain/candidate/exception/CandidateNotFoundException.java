package com.ceos21.vote.domain.candidate.exception;

import com.ceos21.vote.common.exception.VoteCodeException;

public class CandidateNotFoundException extends VoteCodeException {
    public static final VoteCodeException EXCEPTION = new CandidateNotFoundException();
    private CandidateNotFoundException() {
        super(CandidateErrorCode.CANDIDATE_NOT_FOUND);
    }
}

