package com.ceos21.vote.domain.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "로그인 요청")
public class LoginRequest {
    @Schema(description = "아이디", example = "thisisid")
    private String identifier;

    @Schema(description = "비밀번호", example = "1234")
    private String password;
}