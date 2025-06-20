package com.ceos21.vote.common.jwt;

import com.ceos21.vote.common.dto.ErrorResponse;
import com.ceos21.vote.common.dto.SuccessResponse;
import com.ceos21.vote.domain.auth.dto.LoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final RefreshTokenRepository refreshTokenRepository;
    private final ObjectMapper objectMapper;

    // 로그인 요청 처리
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            // JSON -> LoginRequest
            LoginRequest loginRequest = objectMapper.readValue(request.getInputStream(), LoginRequest.class);


            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(loginRequest.getIdentifier(), loginRequest.getPassword());

            // AuthenticationManager에게 인증 위임
            return authenticationManager.authenticate(authToken);

        } catch (IOException e) {
            throw new RuntimeException("로그인 요청 파싱 실패", e);
        }
    }

    // 인증 성공 시: JWT 토큰 발급 & 응답 헤더에 추가
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult)
            throws IOException, ServletException {

        SecurityContextHolder.getContext().setAuthentication(authResult);   // 인증 정보 저장

        String identifier = authResult.getName();
        List<String> roles = authResult.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        String accessToken = jwtUtil.createAccessToken(identifier, roles);
        String refreshToken = jwtUtil.createRefreshToken(identifier);

        refreshTokenRepository.save(identifier, refreshToken);

        Map<String, String> tokenMap = Map.of(
                "accessToken", accessToken,
                "refreshToken", refreshToken
        );

        SuccessResponse<Map<String, String>> responseBody = SuccessResponse.success(200, tokenMap);

        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json;charset=UTF-8");
        objectMapper.writeValue(response.getWriter(), responseBody);

    }

    // 인증 실패 시 처리
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException {
        ErrorResponse responseBody = ErrorResponse.of(
                401,                          // HTTP 상태 코드
                "AUTH_401",                   // 커스텀 에러 코드
                "아이디 또는 비밀번호가 올바르지 않습니다.",  // 사용자 메시지
                request.getRequestURI()       // 요청 경로
        );

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json;charset=UTF-8");
        objectMapper.writeValue(response.getWriter(), responseBody);

    }
}