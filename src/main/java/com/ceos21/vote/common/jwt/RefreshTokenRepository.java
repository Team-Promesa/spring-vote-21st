package com.ceos21.vote.common.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
@RequiredArgsConstructor
public class RefreshTokenRepository {
    private final RedisTemplate<String, Object> redisTemplate;

    private final long REFRESH_TOEKN_TTL = 1000 * 60 * 60 * 24 * 7L; // 7일

    public void save(String identifier, String refreshToken) {
        redisTemplate.opsForValue().set(
                "refresh:" + identifier,
                refreshToken, REFRESH_TOEKN_TTL,
                TimeUnit.MILLISECONDS
        );
    }

    public String get(String identifier) {
        return (String) redisTemplate.opsForValue().get("refresh:" + identifier);
    }

    public void delete(String identifier) {
        redisTemplate.delete("refresh:" + identifier);
    }
}