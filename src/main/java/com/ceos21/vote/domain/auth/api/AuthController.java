package com.ceos21.vote.domain.auth.api;

import com.ceos21.vote.common.jwt.JwtUtil;
import com.ceos21.vote.common.jwt.RefreshTokenRepository;
import com.ceos21.vote.domain.auth.application.AuthService;
import com.ceos21.vote.domain.auth.dto.LoginRequest;
import com.ceos21.vote.domain.auth.dto.SignupRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final JwtUtil jwtUtil;
    private final RefreshTokenRepository refreshTokenRepository;

    @Operation(
            summary = "회원가입",
            description = "새로운 사용자를 등록합니다."
    )
    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@Valid @RequestBody SignupRequest request) {
        authService.register(request);
        return  ResponseEntity.ok().build();
    }

    @Operation(
            summary = "로그인",
            description = "아이디와 비밀번호로 로그인합니다."
    )
    @PostMapping("/login")
    public void signin(@Valid @RequestBody LoginRequest request) {
    }
}