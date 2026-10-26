package com.cleycer.Votacion.service;

import com.cleycer.Votacion.model.Votes;
import java.util.List;

public interface ItfVotesService {

    List<Votes> getVotes();

    List<Votes> getVotesUser(Long codUser);

    List<Votes> getVotesCandidate(Long codCandidate);

    Votes searchVote(Long codVote);

    Votes createVote(Votes voteData);

    Votes editVote(Long codVote, Votes voteData);

    boolean deleteVote(Long codVote);

}
