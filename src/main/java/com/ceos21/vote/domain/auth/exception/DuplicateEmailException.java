package com.ceos21.vote.domain.auth.exception;

import com.ceos21.vote.common.exception.VoteCodeException;

public class DuplicateEmailException extends VoteCodeException {
    public static final DuplicateEmailException EXCEPTION = new DuplicateEmailException();
    private DuplicateEmailException() {
        super(AuthErrorCode.EMAIL_DUPLICATE);
    }
}
