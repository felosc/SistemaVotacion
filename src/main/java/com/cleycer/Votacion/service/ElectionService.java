package com.cleycer.Votacion.service;

import com.cleycer.Votacion.dto.ElectionRequestDto;
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
    public List<com.cleycer.Votacion.dto.ElectionResponseDto> getElections() {
        return ElectionRepo.findAll().stream().map(com.cleycer.Votacion.mapper.ElectionMapper::toDto)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public com.cleycer.Votacion.dto.ElectionResponseDto searchElectionDto(Long codElection) {
        Election election = ElectionRepo.findById(codElection).orElse(null);
        return com.cleycer.Votacion.mapper.ElectionMapper.toDto(election);
    }

    @Override
    public Election searchElection(Long codElection) {
        return ElectionRepo.findById(codElection).orElse(null);
    }

    @Override
    public Election createElection(Election ElectionData) {

        Long codUserCreate = ElectionData.getUserCreate();
        if (codUserCreate == null) {
            return null;
        }
        Users userCreateElection = userRepo.searchUser(codUserCreate);
        if (userCreateElection == null) {
            return null;
        }
        ElectionData.setUserCreate(userCreateElection);
        boolean valido = this.validateDataElection(ElectionData);
        if (valido == false) {
            return null;
        }
        return ElectionRepo.save(ElectionData);

    }

    @Override
    public com.cleycer.Votacion.dto.ElectionResponseDto createElection(ElectionRequestDto electionRequestDto) {
        if (electionRequestDto == null) {
            return null;
        }
        if (electionRequestDto.getUserCreate() == null) {
            return null;
        }
        Users userCreateElection = userRepo.searchUser(electionRequestDto.getUserCreate());
        if (userCreateElection == null) {
            return null;
        }

        Election election = new Election();
        election.setTitle(electionRequestDto.getTitle());
        election.setDescription(electionRequestDto.getDescription());
        election.setStartDate(electionRequestDto.getStartDate());
        election.setEndDate(electionRequestDto.getEndDate());
        election.setState(electionRequestDto.getState());
        election.setUserCreate(userCreateElection);

        boolean valido = this.validateDataElection(election);
        if (valido == false) {
            return null;
        }
        Election saved = ElectionRepo.save(election);
        return com.cleycer.Votacion.mapper.ElectionMapper.toDto(saved);
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
    public com.cleycer.Votacion.dto.ElectionResponseDto editElection(Long codElection, ElectionRequestDto electionRequestDto) {
        if (electionRequestDto == null) {
            return null;
        }
        Election ElectionExisting = searchElection(codElection);
        if (ElectionExisting == null) {
            return null;
        }
        if (electionRequestDto.getUserCreate() == null) {
            return null;
        }
        Users userCreateElection = userRepo.searchUser(electionRequestDto.getUserCreate());
        if (userCreateElection == null) {
            return null;
        }

        Election election = new Election();
        election.setTitle(electionRequestDto.getTitle());
        election.setDescription(electionRequestDto.getDescription());
        election.setStartDate(electionRequestDto.getStartDate());
        election.setEndDate(electionRequestDto.getEndDate());
        election.setState(electionRequestDto.getState());
        election.setUserCreate(userCreateElection);

        boolean valido = this.validateDataElection(election);
        if (valido == false) {
            return null;
        }

        ElectionExisting.setTitle(election.getTitle());
        ElectionExisting.setDescription(election.getDescription());
        ElectionExisting.setStartDate(election.getStartDate());
        ElectionExisting.setEndDate(election.getEndDate());
        ElectionExisting.setState(election.getState());
        ElectionExisting.setUserCreate(userCreateElection);

        Election saved = ElectionRepo.save(ElectionExisting);
        return com.cleycer.Votacion.mapper.ElectionMapper.toDto(saved);
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

        if (ElecionData.getUserCreate() == null) {
            return false;
        }

        if (ElecionData.getStartDate() != null && ElecionData.getEndDate() != null
                && ElecionData.getEndDate().isBefore(ElecionData.getStartDate())) {
            return false;
        }

        return true;
    }

}
