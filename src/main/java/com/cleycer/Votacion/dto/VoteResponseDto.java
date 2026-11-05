package com.cleycer.Votacion.dto;

import java.time.LocalDateTime;

public class VoteResponseDto {
    private Long codVote;
    private Long codUser;
    private Long codCandidate;
    private Long codElection;
    private LocalDateTime timestamp;

    public VoteResponseDto() {
    }

    public VoteResponseDto(Long codVote, Long codUser, Long codCandidate, Long codElection,
                           LocalDateTime timestamp) {
        this.codVote = codVote;
        this.codUser = codUser;
        this.codCandidate = codCandidate;
        this.codElection = codElection;
        this.timestamp = timestamp;
    }

    public Long getCodVote() {
        return codVote;
    }

    public void setCodVote(Long codVote) {
        this.codVote = codVote;
    }

    public Long getCodUser() {
        return codUser;
    }

    public void setCodUser(Long codUser) {
        this.codUser = codUser;
    }

    public Long getCodCandidate() {
        return codCandidate;
    }

    public void setCodCandidate(Long codCandidate) {
        this.codCandidate = codCandidate;
    }

    public Long getCodElection() {
        return codElection;
    }

    public void setCodElection(Long codElection) {
        this.codElection = codElection;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
