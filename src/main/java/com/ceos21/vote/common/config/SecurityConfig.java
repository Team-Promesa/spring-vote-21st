package com.ceos21.vote.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http.csrf().disable() // csrf 보안 설정 사용 X
                .logout().disable() // 로그아웃 사용 X
                .formLogin().disable() // 폼 로그인 사용 X

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/login", "/signup").permitAll()
                        .requestMatchers("/oauth/loginInfo").authenticated()

                        .requestMatchers("/",
                                "/index.html",
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/swagger-resources/**"
                        ).permitAll()
                        .anyRequest().authenticated()
                )

                .build();
    }
}