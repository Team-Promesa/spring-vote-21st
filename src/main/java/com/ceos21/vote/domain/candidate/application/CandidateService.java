package com.ceos21.vote.domain.candidate.application;

import com.ceos21.vote.domain.candidate.dao.CandidateRepository;
import com.ceos21.vote.domain.candidate.domain.VoteType;
import com.ceos21.vote.domain.candidate.dto.CandidateListResponse;
import com.ceos21.vote.domain.candidate.dto.CandidateResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateService {
    private final CandidateRepository candidateRepository;

    // 전체 후보 목록 조회 (득표수 숨김)
    public List<CandidateListResponse> getAllCandidates(VoteType voteType) {
        return candidateRepository.findByVoteType(voteType).stream()
                .map(CandidateListResponse::from)
                .toList();
    }

    // 결과 조회 (득표수 포함 + 득표순 정렬)
    public List<CandidateResultResponse> getResult(VoteType voteType) {
        return candidateRepository.findByVoteTypeOrderByVoteCountDesc(voteType).stream()
                .map(CandidateResultResponse::from)
                .toList();
    }
}
