package com.ceos21.vote.domain.candidate.exception;

import com.ceos21.vote.common.dto.ErrorReason;
import com.ceos21.vote.common.exception.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.ceos21.vote.common.consts.VoteStatic.*;

@Getter
@AllArgsConstructor
public enum CandidateErrorCode implements BaseErrorCode {
    CANDIDATE_NOT_FOUND(NOT_FOUND, "Candidate_404", "해당 후보를 찾을 수 없습니다.");

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

