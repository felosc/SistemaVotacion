package com.cleycer.Votacion.controller;

import com.cleycer.Votacion.model.Votes;
import com.cleycer.Votacion.service.ItfVotesService;
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
    public ResponseEntity<?> createVote(@RequestBody Votes voteData) {
        Votes newVote = votesService.createVote(voteData);
        if (newVote == null) {
            return ResponseEntity.badRequest().body("Error Creating new Vote, verify the data send data \n"
                    + voteData.getUserVote() + " " +
                    voteData.getCandidateVote());
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
