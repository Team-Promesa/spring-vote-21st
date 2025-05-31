package com.ceos21.vote.common.exception;

public class UnsupportedTokenException extends VoteCodeException{
    public static final VoteCodeException EXCEPTION = new UnsupportedTokenException();

    private UnsupportedTokenException() {
        super(GlobalErrorCode.INVALID_TOKEN);
    }
}
