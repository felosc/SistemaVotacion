package com.cleycer.Votacion.service;

import com.cleycer.Votacion.dto.CandidateRequestDto;
import com.cleycer.Votacion.model.Candidate;

import java.util.List;

public interface ItfCandidateService {

    List<Candidate> getCandidates();

    Candidate searchCandidate(Long codCandidate);

    Candidate createCandidate(Candidate candidateData);

    Candidate createCandidate(CandidateRequestDto candidateRequestDto);

    Candidate editCandidate(Long codCandidate, Candidate CandidateData);

    Candidate editCandidate(Long codCandidate, CandidateRequestDto candidateRequestDto);

    boolean deleteCandidate(Long codCandidate);

}
