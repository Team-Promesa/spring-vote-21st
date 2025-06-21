package com.ceos21.vote.domain.vote.api;

import com.ceos21.vote.common.security.UserDetailsImpl;
import com.ceos21.vote.domain.candidate.domain.VoteType;
import com.ceos21.vote.domain.member.domain.Member;
import com.ceos21.vote.domain.vote.application.VoteService;
import com.ceos21.vote.domain.vote.dto.VoteRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("vote")
@RequiredArgsConstructor
public class VoteController {
    private final VoteService voteService;

    @PostMapping("/{voteType}")
    public ResponseEntity<?> vote(@PathVariable VoteType voteType,
                                   @RequestBody VoteRequest request,
                                   @AuthenticationPrincipal UserDetailsImpl userDetails) {
        log.info("로그인한 사용자: {}", userDetails.getUser().getName());
        Member member = userDetails.getUser();
        return ResponseEntity.ok(voteService.vote(member, request.getCandidateId(), voteType));
    }
}
