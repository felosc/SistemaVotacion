package com.cleycer.Votacion.service;

import com.cleycer.Votacion.dto.VoteRequestDto;
import com.cleycer.Votacion.dto.VoteResponseDto;
import com.cleycer.Votacion.model.Votes;
import java.util.List;

public interface ItfVotesService {

    List<VoteResponseDto> getVotes();

    List<VoteResponseDto> getVotesUser(Long codUser);

    List<VoteResponseDto> getVotesCandidate(Long codCandidate);

    VoteResponseDto searchVoteDto(Long codVote);
    Votes searchVote(Long codVote);

    Votes createVote(Votes voteData);

    VoteResponseDto createVote(VoteRequestDto voteRequestDto);

    Votes editVote(Long codVote, Votes voteData);

    boolean deleteVote(Long codVote);

}
