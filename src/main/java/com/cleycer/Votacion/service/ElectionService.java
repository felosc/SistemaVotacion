package com.cleycer.Votacion.service;

import com.cleycer.Votacion.model.Election;
import com.cleycer.Votacion.model.Users;
import com.cleycer.Votacion.repository.ItfElectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectionService implements ItfElectionService {

    private final ItfElectionRepository ElectionRepo;
    private final ItfUsersService userRepo;

    public ElectionService(ItfElectionRepository electionRepo, ItfUsersService userRepo) {
        ElectionRepo = electionRepo;
        this.userRepo = userRepo;
    }

    @Override
    public List<Election> getElections() {
        return ElectionRepo.findAll();
    }

    @Override
    public Election searchElection(Long codElection) {
        return ElectionRepo.findById(codElection).orElse(null);
    }

    @Override
    public Election createElection(Election ElectionData) {

        Long codUserCreate = ElectionData.getUserCreate();
        Users userCreateElection = userRepo.searchUser(codUserCreate);
        ElectionData.setUserCreate(userCreateElection);
        boolean valido = this.validateDataElection(ElectionData);
        if (valido == false) {
            return null;
        }
        return ElectionRepo.save(ElectionData);

    }

    @Override
    public Election editElection(Long codElection, Election ElectionData) {
        Election ElectionExisting = searchElection(codElection);
        if (ElectionExisting == null) {
            return null;
        }

        boolean valido = this.validateDataElection(ElectionData);
        if (valido == false) {
            return null;
        }
        ElectionExisting.setTitle(ElectionData.getTitle());
        ElectionExisting.setDescription(ElectionData.getDescription());
        ElectionExisting.setStartDate(ElectionData.getStartDate());
        ElectionExisting.setEndDate(ElectionData.getEndDate());
        ElectionExisting.setState(ElectionData.getState());
        ElectionExisting.setTimestamp(ElectionData.getTimestamp());

        return ElectionRepo.save(ElectionExisting);
    }

    @Override
    public boolean deleteElection(Long codElection) {
        Election ElectionExiting = searchElection(codElection);

        if (ElectionExiting == null) {
            return false;
        }
        ElectionRepo.delete(ElectionExiting);
        return true;
    }

    public boolean validateDataElection(Election ElecionData) {
        if (ElecionData.getTitle() == null || ElecionData.getTitle().isBlank()) {
            return false;
        }

        if (ElecionData.getDescription() == null || ElecionData.getDescription().isBlank()) {
            return false;
        }

        if (ElecionData.getState() == null || ElecionData.getState().isBlank()) {
            return false;
        }

        if (ElecionData.getStartDate() == null) {
            return false;
        }

        if (ElecionData.getEndDate() == null) {
            return false;
        }

        if (ElecionData.getUserCreate() == null || ElecionData.getUserCreate().toString().isBlank()) {
            return false;
        }

        if (ElecionData.getTimestamp() == null) {
            return false;
        }
        return true;
    }

}
