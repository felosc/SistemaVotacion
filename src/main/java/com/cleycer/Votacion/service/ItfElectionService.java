package com.cleycer.Votacion.service;

import com.cleycer.Votacion.model.Election;


import java.util.List;

public interface ItfElectionService {

    List<Election> getElections();

    Election searchElection(Long codElection);
    //create Election
    Election createElection(Election ElectionData);
    //edit Election
    Election editElection(Long codElection,Election ElectionData);
    //delete Election
    boolean deleteElection(Long codElection);
}
