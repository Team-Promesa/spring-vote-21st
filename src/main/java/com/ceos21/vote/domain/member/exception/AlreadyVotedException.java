package com.ceos21.vote.domain.member.exception;

import com.ceos21.vote.common.exception.VoteCodeException;

public class AlreadyVotedException extends VoteCodeException {
    public static final AlreadyVotedException EXCEPTION = new AlreadyVotedException();

    private AlreadyVotedException() {
        super(MemberErrorCode.ALREADY_VOTED);
    }
}
