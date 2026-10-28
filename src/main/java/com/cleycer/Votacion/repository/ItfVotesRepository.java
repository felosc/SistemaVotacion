package com.cleycer.Votacion.repository;

import com.cleycer.Votacion.model.Votes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItfVotesRepository extends JpaRepository<Votes, Long> {
    boolean existsByUserVote_CodUserAndElectionVote_CodElection(Long codUser, Long codElection);

    List<Votes> findByElectionVote_CodElection(Long codElection);

    List<Votes> findByUserVote_CodUser(Long codUser);
}
