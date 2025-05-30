package com.ceos21.vote.common.exception;

import com.ceos21.vote.common.dto.ErrorReason;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class VoteCodeException extends RuntimeException {

    private BaseErrorCode errorCode;
    public ErrorReason getErrorReason() {return this.errorCode.getErrorReason();}
}