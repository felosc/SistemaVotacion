package com.cleycer.Votacion.service;

import com.cleycer.Votacion.dto.ElectionRequestDto;
import com.cleycer.Votacion.dto.ElectionResponseDto;
import com.cleycer.Votacion.model.Election;


import java.util.List;

public interface ItfElectionService {

    List<ElectionResponseDto> getElections();

    ElectionResponseDto searchElectionDto(Long codElection);
    Election searchElection(Long codElection);
    //create Election
    Election createElection(Election ElectionData);
    ElectionResponseDto createElection(ElectionRequestDto electionRequestDto);
    //edit Election
    Election editElection(Long codElection, Election ElectionData);
    ElectionResponseDto editElection(Long codElection, ElectionRequestDto electionRequestDto);
    //delete Election
    boolean deleteElection(Long codElection);
}
