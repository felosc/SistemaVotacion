package com.cleycer.Votacion.service;

import com.cleycer.Votacion.dto.VoteRequestDto;
import com.cleycer.Votacion.model.Candidate;
import com.cleycer.Votacion.model.Election;
import com.cleycer.Votacion.model.Users;
import com.cleycer.Votacion.model.Votes;
import com.cleycer.Votacion.repository.ItfCandidateRepository;
import com.cleycer.Votacion.repository.ItfElectionRepository;
import com.cleycer.Votacion.repository.ItfUsersRepository;
import com.cleycer.Votacion.repository.ItfVotesRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VotesService implements ItfVotesService {

    private final ItfVotesRepository votesRepo;
    private final ItfUsersRepository usersRepo;
    private final ItfCandidateRepository candidateRepo;
    private final ItfElectionRepository electionRepo;

    public VotesService(ItfVotesRepository votesRepo, ItfUsersRepository usersRepo,
            ItfCandidateRepository candidateRepo, ItfElectionRepository electionRepo) {
        this.votesRepo = votesRepo;
        this.usersRepo = usersRepo;
        this.candidateRepo = candidateRepo;
        this.electionRepo = electionRepo;
    }

    @Override
    public List<Votes> getVotes() {
        return votesRepo.findAll();
    }

    @Override
    public List<Votes> getVotesUser(Long codUser) {
        return votesRepo.findByUserVote_CodUser(codUser);
    }

    @Override
    public List<Votes> getVotesCandidate(Long codCandidate) {
        List<Votes> allVotes = votesRepo.findAll();
        return allVotes.stream()
                .filter(vote -> vote.getCandidateVote() != null
                        && vote.getCandidateVote().getCodCandidate().equals(codCandidate))
                .collect(Collectors.toList());
    }

    @Override
    public Votes searchVote(Long codVote) {
        return votesRepo.findById(codVote).orElse(null);
    }

    @Override
    public Votes createVote(Votes voteData) {
        if (voteData == null) {
            return null;
        }

        Users userVoteRef = voteData.getUserVote();
        Candidate candidateVoteRef = voteData.getCandidateVote();

        if (userVoteRef == null || userVoteRef.getCodUser() == null || candidateVoteRef == null
                || candidateVoteRef.getCodCandidate() == null) {
            return null;
        }

        Users verifyUser = usersRepo.findById(userVoteRef.getCodUser()).orElse(null);
        Candidate verifyCandidate = candidateRepo.findById(candidateVoteRef.getCodCandidate()).orElse(null);

        if (verifyUser == null || verifyCandidate == null) {
            return null;
        }

        Long electionFromCandidate = verifyCandidate.getElectionCandidate().getCodElection();
        if (electionFromCandidate == null || electionFromCandidate == null) {
            return null;
        }

        Election verifyElection = electionRepo.findById(electionFromCandidate).orElse(null);
        if (verifyElection == null) {
            return null;
        }

        if (votesRepo.existsByUserVote_CodUserAndElectionVote_CodElection(verifyUser.getCodUser(),
                verifyElection.getCodElection())) {
            return null;
        }

        String state = verifyElection.getState();
        if (state != null && ("off".equalsIgnoreCase(state) || "ended".equalsIgnoreCase(state))) {
            return null;
        }

        LocalDate now = LocalDate.now();
        if (verifyElection.getStartDate() != null && now.isBefore(verifyElection.getStartDate())) {
            return null;
        }
        if (verifyElection.getEndDate() != null && now.isAfter(verifyElection.getEndDate())) {
            return null;
        }

        voteData.setUserVote(verifyUser);
        voteData.setCandidateVote(verifyCandidate);
        voteData.setElectionVote(verifyElection);
        if (voteData.getTimestamp() == null) {
            voteData.setTimestamp(LocalDateTime.now());
        }

        return votesRepo.save(voteData);
    }

    @Override
    public Votes createVote(VoteRequestDto voteRequestDto) {
        if (voteRequestDto == null) {
            return null;
        }
        if (voteRequestDto.getCodUser() == null || voteRequestDto.getCodCandidate() == null) {
            return null;
        }

        Users verifyUser = usersRepo.findById(voteRequestDto.getCodUser()).orElse(null);
        Candidate verifyCandidate = candidateRepo.findById(voteRequestDto.getCodCandidate()).orElse(null);

        if (verifyUser == null || verifyCandidate == null) {
            return null;
        }

        Election electionFromCandidate = verifyCandidate.getElectionCandidate();
        if (electionFromCandidate == null || electionFromCandidate.getCodElection() == null) {
            return null;
        }

        Election verifyElection = electionRepo.findById(electionFromCandidate.getCodElection()).orElse(null);
        if (verifyElection == null) {
            return null;
        }

        if (votesRepo.existsByUserVote_CodUserAndElectionVote_CodElection(verifyUser.getCodUser(),
                verifyElection.getCodElection())) {
            return null;
        }

        String state = verifyElection.getState();
        if (state != null && ("FINALIZADA".equalsIgnoreCase(state) || "CANCELADA".equalsIgnoreCase(state))) {
            return null;
        }

        LocalDate now = LocalDate.now();
        if (verifyElection.getStartDate() != null && now.isBefore(verifyElection.getStartDate())) {
            return null;
        }
        if (verifyElection.getEndDate() != null && now.isAfter(verifyElection.getEndDate())) {
            return null;
        }

        Votes vote = new Votes();
        vote.setUserVote(verifyUser);
        vote.setCandidateVote(verifyCandidate);
        vote.setElectionVote(verifyElection);
        vote.setTimestamp(LocalDateTime.now());

        return votesRepo.save(vote);
    }

    @Override
    public Votes editVote(Long codVote, Votes voteData) {
        /*
         * Votes voteExisting = searchVote(codVote);
         * if (voteExisting == null) {
         * return null;
         * }
         * Long codUserVote = voteData.getUserVote();
         * Long codCandidateVote = voteData.getCandidateVote();
         * if (codUserVote == null || codCandidateVote == null) {
         * return null;
         * }
         * Users verifyUser = usersRepo.findById(codUserVote).orElse(null);
         * Candidate verifyCandidate =
         * candidateRepo.findById(codCandidateVote).orElse(null);
         * if (verifyUser == null || verifyCandidate == null) {
         * return null;
         * }
         * voteExisting.setUserVote(verifyUser);
         * voteExisting.setCandidateVote(verifyCandidate);
         * return votesRepo.save(voteExisting);
         */
        return null; // Placeholder return statement to avoid compilation error
    }

    @Override
    public boolean deleteVote(Long codVote) {
        Votes voteExisting = searchVote(codVote);
        if (voteExisting == null) {
            return false;
        }
        votesRepo.delete(voteExisting);
        return true;
    }

    public boolean validateDataVote(Votes voteData) {
        if (voteData == null) {
            return false;
        }
        Users userVoteRef = voteData.getUserVote();
        Candidate candidateVoteRef = voteData.getCandidateVote();
        if (userVoteRef == null || userVoteRef.getCodUser() == null || candidateVoteRef == null
                || candidateVoteRef.getCodCandidate() == null) {
            return false;
        }
        Users verifyUser = usersRepo.findById(userVoteRef.getCodUser()).orElse(null);
        Candidate verifyCandidate = candidateRepo.findById(candidateVoteRef.getCodCandidate()).orElse(null);
        if (verifyUser == null || verifyCandidate == null) {
            return false;
        }
        if (verifyCandidate.getElectionCandidate() == null) {
            return false;
        }
        return true;
    }
}
