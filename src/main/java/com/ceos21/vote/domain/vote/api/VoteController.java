package com.ceos21.vote.domain.vote.api;

import com.ceos21.vote.common.security.UserDetailsImpl;
import com.ceos21.vote.domain.candidate.application.CandidateService;
import com.ceos21.vote.domain.candidate.domain.VoteType;
import com.ceos21.vote.domain.candidate.dto.CandidateListResponse;
import com.ceos21.vote.domain.candidate.dto.CandidateResultResponse;
import com.ceos21.vote.domain.member.domain.Member;
import com.ceos21.vote.domain.vote.application.VoteService;
import com.ceos21.vote.domain.vote.dto.VoteRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("vote")
@RequiredArgsConstructor
public class VoteController {
    private final VoteService voteService;
    private final CandidateService candidateService;

    // 후보 목록 조회
    @GetMapping("/{voteType}")
    public ResponseEntity<List<CandidateListResponse>> getAllCandidates(@PathVariable VoteType voteType) {
        return ResponseEntity.ok(candidateService.getAllCandidates(voteType));
    }

    // 투표하기
    @PostMapping("/{voteType}")
    public ResponseEntity<?> vote(@PathVariable VoteType voteType,
                                   @RequestBody VoteRequest request,
                                   @AuthenticationPrincipal UserDetailsImpl userDetails) {
        log.info("로그인한 사용자: {}", userDetails.getUser().getName());
        Member member = userDetails.getUser();
        return ResponseEntity.ok(voteService.vote(member, request.getCandidateId(), voteType));
    }

    // 투표 결과 조회
    @GetMapping("/{voteType}/result")
    public ResponseEntity<List<CandidateResultResponse>> getResult(@PathVariable VoteType voteType) {
        return ResponseEntity.ok(candidateService.getResult(voteType));
    }
}
