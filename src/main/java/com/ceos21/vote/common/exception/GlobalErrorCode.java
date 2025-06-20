package com.ceos21.vote.common.exception;

import com.ceos21.vote.common.dto.ErrorReason;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.ceos21.vote.common.consts.VoteStatic.INTERNAL_SERVER;
import static com.ceos21.vote.common.consts.VoteStatic.NOT_FOUND;

@Getter
@AllArgsConstructor
public enum GlobalErrorCode implements BaseErrorCode {
    EXAMPLE_NOT_FOUND(NOT_FOUND, "EXAMPLE_404", "예시를 찾을 수 없습니다."),

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
