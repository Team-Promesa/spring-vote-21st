package com.ceos21.vote.common.exception;

public class InvalidRefreshTokenException extends VoteCodeException{
    public static final VoteCodeException EXCEPTION = new InvalidRefreshTokenException();

    private InvalidRefreshTokenException() {
        super(GlobalErrorCode.INVALID_REFRESH_TOKEN);
    }
}
