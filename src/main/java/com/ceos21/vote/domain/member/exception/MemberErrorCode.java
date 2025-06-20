package com.ceos21.vote.domain.member.exception;

import com.ceos21.vote.common.dto.ErrorReason;
import com.ceos21.vote.common.exception.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.ceos21.vote.common.consts.VoteStatic.*;

@Getter
@AllArgsConstructor
public enum MemberErrorCode implements BaseErrorCode {
    MEMBER_NOT_FOUND(NOT_FOUND, "Member_404", "해당 사용자를 찾을 수 없습니다."),
    ALREADY_VOTED(FORBIDDEN, "Member_403", "이미 해당 항목에 투표하셨습니다.");

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

