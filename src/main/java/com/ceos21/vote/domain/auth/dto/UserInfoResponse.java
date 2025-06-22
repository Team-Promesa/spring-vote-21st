package com.ceos21.vote.domain.auth.dto;

import com.ceos21.vote.domain.member.domain.Member;

public record UserInfoResponse(
        String identifier,
        String part,
        String team,
        String name
) {
    public static UserInfoResponse from(Member member) {
        return new UserInfoResponse(
                member.getIdentifier(),
                member.getPart().name(),
                member.getTeam().name(),
                member.getName()
        );
    }
}

