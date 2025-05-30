package com.ceos21.vote.common.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorReason {
    private final int status;
    private final String code;
    private final String reason;
}