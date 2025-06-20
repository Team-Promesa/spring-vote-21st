package com.ceos21.vote.common.exception;

public class InvalidSignatureException extends VoteCodeException{
    public static final VoteCodeException EXCEPTION = new InvalidSignatureException();

    private InvalidSignatureException() {
        super(GlobalErrorCode.INVALID_TOKEN);
    }
}