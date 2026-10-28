package com.cleycer.Votacion.service;

import com.cleycer.Votacion.dto.ElectionRequestDto;
import com.cleycer.Votacion.model.Election;


import java.util.List;

public interface ItfElectionService {

    List<Election> getElections();

    Election searchElection(Long codElection);
    //create Election
    Election createElection(Election ElectionData);
    Election createElection(ElectionRequestDto electionRequestDto);
    //edit Election
    Election editElection(Long codElection, Election ElectionData);
    Election editElection(Long codElection, ElectionRequestDto electionRequestDto);
    //delete Election
    boolean deleteElection(Long codElection);
}
