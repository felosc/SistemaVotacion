package com.cleycer.Votacion.service;

import com.cleycer.Votacion.model.Candidate;
import com.cleycer.Votacion.model.Users;
import com.cleycer.Votacion.model.Votes;
import com.cleycer.Votacion.repository.ItfCandidateRepository;
import com.cleycer.Votacion.repository.ItfUsersRepository;
import com.cleycer.Votacion.repository.ItfVotesRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VotesService implements ItfVotesService {

    private final ItfVotesRepository votesRepo;
    private final ItfUsersRepository usersRepo;
    private final ItfCandidateRepository candidateRepo;

    public VotesService(ItfVotesRepository votesRepo, ItfUsersRepository usersRepo,
            ItfCandidateRepository candidateRepo) {
        this.votesRepo = votesRepo;
        this.usersRepo = usersRepo;
        this.candidateRepo = candidateRepo;
    }

    @Override
    public List<Votes> getVotes() {
        return votesRepo.findAll();
    }

    @Override
    public List<Votes> getVotesUser(Long codUser) {
        return votesRepo.findAll().stream().filter(vote -> vote.getUserVote().equals(codUser))
                .collect(Collectors.toList());
    }

    @Override
    public List<Votes> getVotesCandidate(Long codCandidate) {
        return votesRepo.findAll().stream()
                .filter(vote -> vote.getCandidateVote().equals(codCandidate))
                .collect(Collectors.toList());
    }

    @Override
    public Votes searchVote(Long codVote) {
        return votesRepo.findById(codVote).orElse(null);
    }

    @Override
    public Votes createVote(Votes voteData) {
        Long codUserVote = voteData.getUserVote();
        Long codCandidateVote = voteData.getCandidateVote();
        if (codUserVote == null || codCandidateVote == null) {
            return null;
        }
        var verifyUser = usersRepo.findById(codUserVote).orElse(null);
        var verifyCandidate = candidateRepo.findById(codCandidateVote).orElse(null);
        if (verifyUser == null || verifyCandidate == null) {
            return null;
        }
        voteData.setUserVote(verifyUser);
        voteData.setCandidateVote(verifyCandidate);
        return votesRepo.save(voteData);
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
        Long codUserVote = voteData.getUserVote();
        Long codCandidateVote = voteData.getCandidateVote();
        if (codUserVote == null || codCandidateVote == null) {
            return false;
        }
        Users verifyUser = usersRepo.findById(codUserVote).orElse(null);
        Candidate verifyCandidate = candidateRepo.findById(codCandidateVote).orElse(null);
        if (verifyUser == null || verifyCandidate == null) {
            return false;
        }
        return true;
    }
}
