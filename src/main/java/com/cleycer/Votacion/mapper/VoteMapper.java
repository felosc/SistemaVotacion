package com.cleycer.Votacion.mapper;

import com.cleycer.Votacion.dto.VoteResponseDto;
import com.cleycer.Votacion.model.Votes;

public class VoteMapper {
    private VoteMapper() {
    }

    public static VoteResponseDto toDto(Votes vote) {
        if (vote == null) {
            return null;
        }
        Long codUser = null;
        if (vote.getUserVote() != null) {
            codUser = vote.getUserVote().getCodUser();
        }
        Long codCandidate = null;
        if (vote.getCandidateVote() != null) {
            codCandidate = vote.getCandidateVote().getCodCandidate();
        }
        Long codElection = null;
        if (vote.getElectionVote() != null) {
            codElection = vote.getElectionVote().getCodElection();
        }
        return new VoteResponseDto(
                vote.getCodVote(),
                codUser,
                codCandidate,
                codElection,
                vote.getTimestamp()
        );
    }
}
