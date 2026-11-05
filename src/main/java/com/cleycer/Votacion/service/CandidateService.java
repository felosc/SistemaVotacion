package com.cleycer.Votacion.service;

import com.cleycer.Votacion.dto.CandidateRequestDto;
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
    public List<com.cleycer.Votacion.dto.CandidateResponseDto> getCandidates() {
        return candidateRepo.findAll().stream().map(com.cleycer.Votacion.mapper.CandidateMapper::toDto)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public com.cleycer.Votacion.dto.CandidateResponseDto searchCandidateDto(Long codCandidate) {
        Candidate candidate = candidateRepo.findById(codCandidate).orElse(null);
        return com.cleycer.Votacion.mapper.CandidateMapper.toDto(candidate);
    }

    @Override
    public Candidate searchCandidate(Long codCandidate) {
        return candidateRepo.findById(codCandidate).orElse(null);
    }

    @Override
    public Candidate createCandidate(Candidate candidateData) {
        if (candidateData == null) {
            return null;
        }
        Election electionCandidateRef = candidateData.getElectionCandidate();
        if (electionCandidateRef == null || electionCandidateRef.getCodElection() == null) {
            return null;
        }
        Election codeElection = ElectionRepo.findById(electionCandidateRef.getCodElection()).orElse(null);
        if (codeElection == null) {
            return null;
        }
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
    public com.cleycer.Votacion.dto.CandidateResponseDto createCandidate(CandidateRequestDto candidateRequestDto) {
        if (candidateRequestDto == null) {
            return null;
        }
        if (candidateRequestDto.getCodElection() == null) {
            return null;
        }
        Election codeElection = ElectionRepo.findById(candidateRequestDto.getCodElection()).orElse(null);
        if (codeElection == null) {
            return null;
        }

        Candidate candidate = new Candidate();
        candidate.setName(candidateRequestDto.getName());
        candidate.setDescription(candidateRequestDto.getDescription());
        candidate.setOrderTicket(candidateRequestDto.getOrderTicket());
        candidate.setImgUrl(candidateRequestDto.getImgUrl());
        candidate.setElectionCandidate(codeElection);

        boolean valido = this.validateDataCandidate(candidate);
        if (valido == false) {
            return null;
        }
        Candidate saved = candidateRepo.save(candidate);
        return com.cleycer.Votacion.mapper.CandidateMapper.toDto(saved);
    }

    @Override
    public com.cleycer.Votacion.dto.CandidateResponseDto editCandidate(Long codCandidate,
            CandidateRequestDto candidateRequestDto) {
        if (candidateRequestDto == null) {
            return null;
        }
        Candidate CandidateExisting = searchCandidate(codCandidate);
        if (CandidateExisting == null) {
            return null;
        }
        if (candidateRequestDto.getCodElection() == null) {
            return null;
        }
        Election codeElection = ElectionRepo.findById(candidateRequestDto.getCodElection()).orElse(null);
        if (codeElection == null) {
            return null;
        }

        Candidate candidate = new Candidate();
        candidate.setName(candidateRequestDto.getName());
        candidate.setDescription(candidateRequestDto.getDescription());
        candidate.setOrderTicket(candidateRequestDto.getOrderTicket());
        candidate.setImgUrl(candidateRequestDto.getImgUrl());
        candidate.setElectionCandidate(codeElection);

        boolean valido = this.validateDataCandidate(candidate);
        if (valido == false) {
            return null;
        }

        CandidateExisting.setName(candidate.getName());
        CandidateExisting.setImgUrl(candidate.getImgUrl());
        CandidateExisting.setDescription(candidate.getDescription());
        CandidateExisting.setOrderTicket(candidate.getOrderTicket());
        CandidateExisting.setElectionCandidate(codeElection);

        Candidate saved = candidateRepo.save(CandidateExisting);
        return com.cleycer.Votacion.mapper.CandidateMapper.toDto(saved);
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

        if (candidateData.getOrderTicket() == null || candidateData.getOrderTicket() <= 0) {
            return false;
        }

        if (candidateData.getElectionCandidate() == null || candidateData.getElectionCandidate().getCodElection() == null) {
            return false;
        }

        return true;
    }
}
