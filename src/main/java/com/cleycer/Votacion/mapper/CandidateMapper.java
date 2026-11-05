package com.cleycer.Votacion.mapper;

import com.cleycer.Votacion.dto.CandidateResponseDto;
import com.cleycer.Votacion.model.Candidate;

public class CandidateMapper {
    private CandidateMapper() {
    }

    public static CandidateResponseDto toDto(Candidate candidate) {
        if (candidate == null) {
            return null;
        }
        Long codElection = null;
        if (candidate.getElectionCandidate() != null) {
            codElection = candidate.getElectionCandidate().getCodElection();
        }
        return new CandidateResponseDto(
                candidate.getCodCandidate(),
                candidate.getName(),
                candidate.getDescription(),
                candidate.getOrderTicket(),
                candidate.getImgUrl(),
                candidate.getTimestamp(),
                codElection
        );
    }
}
