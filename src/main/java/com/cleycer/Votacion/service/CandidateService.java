package com.cleycer.Votacion.service;

import com.cleycer.Votacion.model.Candidate;
import com.cleycer.Votacion.model.Election;
import com.cleycer.Votacion.repository.ItfCandidateRepository;
import com.cleycer.Votacion.repository.ItfElectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService implements ItfCandidateService {

    private final ItfCandidateRepository candidateRepo;
    private final ItfElectionRepository ElectionRepo;

    public CandidateService(ItfCandidateRepository candidateRepo, ItfElectionRepository electionRepo) {
        this.candidateRepo = candidateRepo;
        ElectionRepo = electionRepo;
    }

    @Override
    public List<Candidate> getCandidates() {
        return candidateRepo.findAll();
    }

    @Override
    public Candidate searchCandidate(Long codCandidate) {
        return candidateRepo.findById(codCandidate).orElse(null);
    }

    @Override
    public Candidate createCandidate(Candidate candidateData) {
        Long codElectionCandidate = candidateData.getElectionCandidate();
        Election codeElection = ElectionRepo.getReferenceById(codElectionCandidate);
        candidateData.setElectionCandidate(codeElection);
        boolean valido = this.validateDataCandidate(candidateData);
        if (valido == false) {
            return null;
        }
        return candidateRepo.save(candidateData);
    }

    @Override
    public Candidate editCandidate(Long codCandidate, Candidate CandidateData) {
        Candidate CandidateExisting = searchCandidate(codCandidate);
        if (CandidateExisting == null) {
            return null;
        }
        boolean valido = this.validateDataCandidate(CandidateData);
        if (valido == false) {
            return null;
        }
        CandidateExisting.setName(CandidateData.getName());
        CandidateExisting.setImgUrl(CandidateData.getImgUrl());
        CandidateExisting.setDescription(CandidateData.getDescription());
        CandidateExisting.setOrderTicket(CandidateData.getOrderTicket());

        return candidateRepo.save(CandidateExisting);
    }

    @Override
    public boolean deleteCandidate(Long codCandidate) {
        Candidate CandidateExisting = searchCandidate(codCandidate);

        if (CandidateExisting == null) {
            return false;
        }
        candidateRepo.delete(CandidateExisting);
        return true;
    }

    public boolean validateDataCandidate(Candidate candidateData) {
        if (candidateData.getName() == null || candidateData.getName().isBlank()) {
            return false;
        }

        if (candidateData.getDescription() == null || candidateData.getDescription().isBlank()) {
            return false;
        }

        if (candidateData.getImgUrl() == null || candidateData.getImgUrl().isBlank()) {
            return false;
        }

        if (candidateData.getOrderTicket() == 0 || candidateData.getOrderTicket() <= 0) {
            return false;
        }

        if (candidateData.getElectionCandidate() == null || candidateData.getElectionCandidate().toString().isBlank()) {
            return false;
        }

        return true;
    }
}
