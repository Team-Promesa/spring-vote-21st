package com.ceos21.vote.common.exception;

import com.ceos21.vote.common.dto.ErrorReason;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.ceos21.vote.common.consts.VoteStatic.*;

@Getter
@AllArgsConstructor
public enum GlobalErrorCode implements BaseErrorCode {
    EXAMPLE_NOT_FOUND(NOT_FOUND, "EXAMPLE_404", "예시를 찾을 수 없습니다."),

    INVALID_SIGNATURE(UNAUTHORIZED, "AUTH_401", "JWT 서명이 유효하지 않습니다."),
    EXPIRED_TOKEN(UNAUTHORIZED, "AUTH_401", "JWT 토큰이 만료되었습니다."),
    UNSUPRORTED_TOKEN(UNAUTHORIZED, "AUTH_401", "지원하지 않는 JWT 토큰입니다."),
    INVALID_TOKEN(UNAUTHORIZED, "AUTH_401", "잘못된 JWT 토큰입니다."),

    INTERNAL_SERVER_ERROR(INTERNAL_SERVER, "GLOBAL_500", "서버 오류");

    private Integer status;
    private String code;
    private String reason;

    @Override
    public ErrorReason getErrorReason() {
        return ErrorReason.builder()
                .status(status)
                .code(code)
                .reason(reason)
                .build();
    }
}
