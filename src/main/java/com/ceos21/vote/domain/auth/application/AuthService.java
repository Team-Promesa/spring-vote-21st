package com.ceos21.vote.domain.auth.application;

import com.ceos21.vote.common.exception.InvalidRefreshTokenException;
import com.ceos21.vote.common.exception.ResourceNotFoundException;
import com.ceos21.vote.common.jwt.JwtUtil;
import com.ceos21.vote.common.jwt.RefreshTokenRepository;
import com.ceos21.vote.common.security.UserRole;
import com.ceos21.vote.domain.auth.dto.SignupRequest;
import com.ceos21.vote.domain.auth.exception.DuplicateEmailException;
import com.ceos21.vote.domain.member.dao.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final JwtUtil jwtUtil;
    private final RefreshTokenRepository refreshTokenRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(SignupRequest request) {
        // 중복 아이디 검사
        if (memberRepository.findByIdentifier(request.identifier).isPresent()) {
            throw DuplicateEmailException.EXCEPTION;
        }

        // 중복 이메일 검사
        if (memberRepository.findByEmail(request.email).isPresent()) {
            throw DuplicateEmailException.EXCEPTION;
        }
        memberRepository.save(request.toEntity(passwordEncoder));
    }

    @Transactional
    public String reissue(String refreshToken) {
        jwtUtil.validateToken(refreshToken);

        String identifier = jwtUtil.getUserInfoFromToken(refreshToken).getSubject();
        String saved = refreshTokenRepository.get(identifier);

        if (saved == null) {
            throw ResourceNotFoundException.EXCEPTION;
        }

        if (!saved.equals(refreshToken)) {
            throw InvalidRefreshTokenException.EXCEPTION;
        }

        return jwtUtil.createAccessToken(identifier, List.of(UserRole.USER.getAuthority()));
    }

    @Transactional
    public void logout(String refreshToken) {
        jwtUtil.validateToken(refreshToken);   // 만료되었으면 예외 던짐

        String identifier = jwtUtil.getUserInfoFromToken(refreshToken).getSubject();
        refreshTokenRepository.delete(identifier);   // 리프레시 토큰 삭제
    }
}