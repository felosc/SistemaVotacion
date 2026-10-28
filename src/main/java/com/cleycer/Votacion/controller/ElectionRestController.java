package com.cleycer.Votacion.controller;

import com.cleycer.Votacion.dto.ElectionRequestDto;
import com.cleycer.Votacion.model.Election;
import com.cleycer.Votacion.service.ItfElectionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Election")
public class ElectionRestController {
    private final ItfElectionService ElectionService;

    public ElectionRestController(ItfElectionService electionService) {
        ElectionService = electionService;
    }

    @GetMapping
    public List<Election> getElections() {
        return ElectionService.getElections();
    }

    @GetMapping("/{codElection}")
    public ResponseEntity<?> searchElection(@PathVariable Long codElection) {
        Election election = ElectionService.searchElection(codElection);
        if (election == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Election not Found");
        }
        return ResponseEntity.ok(election);
    }

    @PostMapping
    public ResponseEntity<?> createElection(@Valid @RequestBody ElectionRequestDto electionRequestDto) {
        Election newElection = ElectionService.createElection(electionRequestDto);
        if (newElection == null) {
            return ResponseEntity.badRequest().body("Error Creating new Election, verify the data send data");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(newElection);
    }

    @PostMapping("/entity")
    public ResponseEntity<?> createElectionEntity(@RequestBody Election electionData) {
        Election newElection = ElectionService.createElection(electionData);
        if (newElection == null) {
            return ResponseEntity.badRequest().body("Error Creating new Election, verify the data send data");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(newElection);
    }

    @PutMapping("/{codElection}")
    public ResponseEntity<?> editElection(@PathVariable Long codElection,
            @Valid @RequestBody ElectionRequestDto electionRequestDto) {
        Election editElection = ElectionService.editElection(codElection, electionRequestDto);
        if (editElection == null) {
            return ResponseEntity.badRequest().body("Error Editing this Election");
        }
        return ResponseEntity.ok(editElection);
    }

    @PutMapping("/{codElection}/entity")
    public ResponseEntity<?> editElectionEntity(@PathVariable Long codElection,
            @RequestBody Election electionEditData) {
        Election editElection = ElectionService.editElection(codElection, electionEditData);
        if (editElection == null) {
            return ResponseEntity.badRequest().body("Error Editing this Election");
        }
        return ResponseEntity.ok(editElection);
    }
    @DeleteMapping("/{codElection}")
    public ResponseEntity<String> deleteElection(@PathVariable Long codElection){
        boolean delete = ElectionService.deleteElection(codElection);
        if (delete==false){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Election "+codElection+" Not Found");
        }
        return ResponseEntity.ok("Election Deleted");
    }

}
