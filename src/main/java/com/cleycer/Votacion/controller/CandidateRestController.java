package com.cleycer.Votacion.controller;

import com.cleycer.Votacion.dto.CandidateRequestDto;
import com.cleycer.Votacion.model.Candidate;
import com.cleycer.Votacion.service.ItfCandidateService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Candidate")
public class CandidateRestController {

    private final ItfCandidateService CandidateService;

    public CandidateRestController(ItfCandidateService candidateService) {
        CandidateService = candidateService;
    }

    @GetMapping
    public List<Candidate> getCandidates() {
        return CandidateService.getCandidates();
    }

    @GetMapping("/{codCandidate}")
    public ResponseEntity<?> searchCandidate(@PathVariable Long codCandidate) {
        Candidate candidate = CandidateService.searchCandidate(codCandidate);
        if (candidate == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Candidate not Found");
        }
        return ResponseEntity.ok(candidate);
    }

    @PostMapping
    public ResponseEntity<?> createCandidate(@Valid @RequestBody CandidateRequestDto candidateRequestDto) {
        Candidate newCandidate = CandidateService.createCandidate(candidateRequestDto);
        if (newCandidate == null) {
            return ResponseEntity.badRequest().body("Error Creating new Candidate, verify the data send data");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(newCandidate);
    }

    @PostMapping("/entity")
    public ResponseEntity<?> createCandidateEntity(@RequestBody Candidate candidateData) {
        Candidate newCandidate = CandidateService.createCandidate(candidateData);
        if (newCandidate == null) {
            return ResponseEntity.badRequest().body("Error Creating new Candidate, verify the data send data");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(newCandidate);
    }

    @PutMapping("/{codCandidate}")
    public ResponseEntity<?> editCandidate(@PathVariable Long codCandidate,
            @Valid @RequestBody CandidateRequestDto candidateRequestDto) {
        Candidate editCandidate = CandidateService.editCandidate(codCandidate, candidateRequestDto);
        if (editCandidate == null) {
            return ResponseEntity.badRequest().body("Error editing this Candidate, verify the data send data");
        }
        return ResponseEntity.ok(editCandidate);
    }

    @PutMapping("/{codCandidate}/entity")
    public ResponseEntity<?> editCandidateEntity(@PathVariable Long codCandidate,
            @RequestBody Candidate candidateEditData) {
        Candidate editCandidate = CandidateService.editCandidate(codCandidate, candidateEditData);
        if (editCandidate == null) {
            return ResponseEntity.badRequest().body("Error editing this Candidate, verify the data send data");
        }
        return ResponseEntity.ok(editCandidate);
    }

    @DeleteMapping("/{codCandidate}")
    public ResponseEntity<String> deleteElection(@PathVariable Long codCandidate) {
        boolean delete = CandidateService.deleteCandidate(codCandidate);
        if (delete == false) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Candidate " + codCandidate + " Not Found");
        }
        return ResponseEntity.ok("Candidate Deleted");
    }

}
