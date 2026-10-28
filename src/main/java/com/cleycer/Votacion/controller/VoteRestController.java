package com.cleycer.Votacion.controller;

import com.cleycer.Votacion.dto.VoteRequestDto;
import com.cleycer.Votacion.model.Votes;
import com.cleycer.Votacion.service.ItfVotesService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Vote")
public class VoteRestController {

    private final ItfVotesService votesService;

    public VoteRestController(ItfVotesService votesService) {
        this.votesService = votesService;
    }

    @GetMapping
    public List<Votes> getUVotes() {
        return votesService.getVotes();
    }

    @GetMapping("/{codVote}")
    public ResponseEntity<?> searchVote(@PathVariable Long codVote) {
        Votes vote = votesService.searchVote(codVote);
        if (vote == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vote not Found");
        }
        return ResponseEntity.ok(vote);
    }

    @PostMapping
    public ResponseEntity<?> createVote(@Valid @RequestBody VoteRequestDto voteRequestDto) {
        Votes newVote = votesService.createVote(voteRequestDto);
        if (newVote == null) {
            return ResponseEntity.badRequest().body("Error creating vote. Verify user, candidate, election status, dates or if user already voted in this election");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(newVote);
    }

    @PostMapping("/entity")
    public ResponseEntity<?> createVoteEntity(@RequestBody Votes voteData) {
        Votes newVote = votesService.createVote(voteData);
        if (newVote == null) {
            return ResponseEntity.badRequest().body("Error creating vote. Verify user, candidate, election status, dates or if user already voted in this election");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(newVote);
    }

    @PutMapping("/{codVote}")
    public ResponseEntity<?> editVote() {
        return ResponseEntity.badRequest().body("The votes don have option to edit \n");
    }

    @DeleteMapping("/{codVote}")
    public ResponseEntity<?> deleteVote(@PathVariable Long codVote) {
        boolean deleted = votesService.deleteVote(codVote);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vote not Found");
        }
        return ResponseEntity.ok("Vote deleted successfully");
    }

}
