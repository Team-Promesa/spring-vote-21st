package com.ceos21.vote.domain.auth.dto;

import com.ceos21.vote.common.security.UserRole;
import com.ceos21.vote.domain.member.domain.Member;
import com.ceos21.vote.domain.member.domain.PartType;
import com.ceos21.vote.domain.member.domain.TeamType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignupRequest {
    @NotBlank(message = "이름은 필수입니다.")
    public String name;

    @NotNull(message = "파트를 선택해주세요.")
    @Enumerated(EnumType.STRING)
    public PartType part;

    @NotNull(message = "팀을 선택해주세요.")
    @Enumerated(EnumType.STRING)
    public TeamType team;

    @NotBlank(message = "이메일은 필수입니다.")
    public String email;

    @NotBlank(message = "아이디는 필수입니다.")
    public String identifier;

    @NotBlank(message = "비밀번호는 필수입니다.")
    public String password;

    public Member toEntity(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .name(name)
                .email(email)
                .identifier(identifier)
                .password(passwordEncoder.encode(password))
                .part(part)
                .team(team)
                .role(UserRole.USER)
                .build();
    }
}