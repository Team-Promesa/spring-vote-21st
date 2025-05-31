package com.ceos21.vote.common.exception;

public class ExpiredTokenException extends VoteCodeException{

    public static final VoteCodeException EXCEPTION = new ExpiredTokenException();

    private ExpiredTokenException() {
        super(GlobalErrorCode.INVALID_TOKEN);
    }
}