package com.ceos21.vote.domain.auth.exception;

import com.ceos21.vote.common.dto.ErrorReason;
import com.ceos21.vote.common.exception.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.ceos21.vote.common.consts.VoteStatic.CONFLICT;

@Getter
@AllArgsConstructor
public enum AuthErrorCode implements BaseErrorCode {
    EMAIL_DUPLICATE(CONFLICT, "Auth_409", "이미 존재하는 이메일입니다."),
    IDENTIFIER_DUPLICATE(CONFLICT, "Auth_409", "이미 존재하는 아이디입니다.");

    private Integer status;
    private String code;
    private String reason;

    @Override
    public ErrorReason getErrorReason() {
        return ErrorReason.builder()
                .reason(reason)
                .code(code)
                .status(status)
                .build();
    }
}
