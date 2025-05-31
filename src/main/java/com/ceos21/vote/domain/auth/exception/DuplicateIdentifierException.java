package com.ceos21.vote.domain.auth.exception;

import com.ceos21.vote.common.exception.VoteCodeException;

public class DuplicateIdentifierException extends VoteCodeException {
    public static final DuplicateIdentifierException EXCEPTION = new DuplicateIdentifierException();
    private DuplicateIdentifierException() {
        super(AuthErrorCode.IDENTIFIER_DUPLICATE);
    }
}