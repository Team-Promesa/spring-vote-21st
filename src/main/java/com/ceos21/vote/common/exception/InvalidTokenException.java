package com.ceos21.vote.common.exception;

public class InvalidTokenException extends VoteCodeException{
    public static final VoteCodeException EXCEPTION = new InvalidTokenException();

    private InvalidTokenException() {
        super(GlobalErrorCode.INVALID_TOKEN);
    }
}
