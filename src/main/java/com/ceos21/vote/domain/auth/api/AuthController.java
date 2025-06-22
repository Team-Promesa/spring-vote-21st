package com.ceos21.vote.domain.auth.api;

import com.ceos21.vote.common.jwt.JwtUtil;
import com.ceos21.vote.common.jwt.RefreshTokenRepository;
import com.ceos21.vote.common.security.UserDetailsImpl;
import com.ceos21.vote.domain.auth.application.AuthService;
import com.ceos21.vote.domain.auth.dto.LoginRequest;
import com.ceos21.vote.domain.auth.dto.RefreshResponse;
import com.ceos21.vote.domain.auth.dto.SignupRequest;
import com.ceos21.vote.domain.auth.dto.UserInfoResponse;
import com.ceos21.vote.domain.member.domain.Member;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    @PostMapping("/refresh")
    @Operation(
            description = "액세스 토큰을 재발급합니다."
    )
    public ResponseEntity<RefreshResponse> refresh(
        @RequestHeader("Refresh-Token") String refreshToken
    ) {
        String accessToken = authService.reissue(refreshToken);
        return ResponseEntity.ok(new RefreshResponse(accessToken));
    }
  
    @Operation(
            summary = "로그아웃",
            description = "로그아웃합니다."
    )
    @PostMapping("/logout")
    public ResponseEntity<Void> refresh(HttpServletRequest request) {
        String token = jwtUtil.getJwtFromHeader(request);   // "Authorization" 헤더에서 access token 추출
        authService.logout(token);

        return  ResponseEntity.ok().build();
    }
  
    @GetMapping("/me")
    public ResponseEntity<UserInfoResponse> getCurrentUserInfo(
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        Member member = userDetails.getUser();
        return ResponseEntity.ok(UserInfoResponse.from(member));
    }
}