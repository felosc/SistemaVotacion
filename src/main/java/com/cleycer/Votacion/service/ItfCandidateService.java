package com.cleycer.Votacion.service;

import com.cleycer.Votacion.model.Candidate;

import java.util.List;

public interface ItfCandidateService {

    List<Candidate> getCandidates();

    Candidate searchCandidate(Long codCandidate);
    Candidate createCandidate(Candidate candidateData);
    Candidate editCandidate(Long codCandidate,Candidate CandidateData);
    boolean deleteCandidate(Long codCandidate);

}
