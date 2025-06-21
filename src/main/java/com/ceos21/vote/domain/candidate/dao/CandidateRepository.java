package com.ceos21.vote.domain.candidate.dao;

import com.ceos21.vote.domain.candidate.domain.Candidate;
import com.ceos21.vote.domain.candidate.domain.VoteType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    Optional<Candidate> findByIdAndVoteType(Long id, VoteType voteType);

    List<Candidate> findByVoteType(VoteType voteType);

    List<Candidate> findByVoteTypeOrderByVoteCountDesc(VoteType voteType);
}
