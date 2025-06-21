package com.ceos21.vote.domain.vote.application;

import com.ceos21.vote.domain.candidate.dao.CandidateRepository;
import com.ceos21.vote.domain.candidate.domain.Candidate;
import com.ceos21.vote.domain.candidate.domain.VoteType;
import com.ceos21.vote.domain.candidate.exception.CandidateNotFoundException;
import com.ceos21.vote.domain.member.dao.MemberRepository;
import com.ceos21.vote.domain.member.domain.Member;
import com.ceos21.vote.domain.member.exception.AlreadyVotedException;
import com.ceos21.vote.domain.member.exception.MemberNotFoundException;
import com.ceos21.vote.domain.vote.dto.VoteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final CandidateRepository candidateRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public VoteResponse vote(Member member, Long candidateId, VoteType voteType) {
        // 투표 가능 여부 검증
        if(member.hasVotedFor(voteType)) {
            throw AlreadyVotedException.EXCEPTION;
        }

        // 투표 처리
        Candidate candidate = candidateRepository.findByIdAndVoteType(candidateId,voteType)
                .orElseThrow(()-> CandidateNotFoundException.EXCEPTION);

        candidate.addVote();

        // DB에 반영
        Member managedMember = memberRepository.findById(member.getId())
                        .orElseThrow(()-> MemberNotFoundException.EXCEPTION);

        managedMember.markVoted(voteType);

        return VoteResponse.from(voteType,candidateId);
    }
}
