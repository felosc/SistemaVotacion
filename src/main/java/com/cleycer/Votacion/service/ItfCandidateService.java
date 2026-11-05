package com.cleycer.Votacion.service;

import com.cleycer.Votacion.dto.CandidateRequestDto;
import com.cleycer.Votacion.dto.CandidateResponseDto;
import com.cleycer.Votacion.model.Candidate;

import java.util.List;

public interface ItfCandidateService {

    List<CandidateResponseDto> getCandidates();

    CandidateResponseDto searchCandidateDto(Long codCandidate);
    Candidate searchCandidate(Long codCandidate);

    Candidate createCandidate(Candidate candidateData);

    CandidateResponseDto createCandidate(CandidateRequestDto candidateRequestDto);

    Candidate editCandidate(Long codCandidate, Candidate CandidateData);

    CandidateResponseDto editCandidate(Long codCandidate, CandidateRequestDto candidateRequestDto);

    boolean deleteCandidate(Long codCandidate);

}
