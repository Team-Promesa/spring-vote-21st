package com.ceos21.vote.domain.member.exception;

import com.ceos21.vote.common.exception.VoteCodeException;

public class MemberNotFoundException extends VoteCodeException {
    public static final VoteCodeException EXCEPTION = new MemberNotFoundException();

    private MemberNotFoundException() {
        super(MemberErrorCode.MEMBER_NOT_FOUND);
    }
}

