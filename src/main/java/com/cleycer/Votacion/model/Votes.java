package com.cleycer.Votacion.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Votes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codVote;
    @ManyToOne
    @JoinColumn(name = "cod_user")
    private Users userVote;

    @ManyToOne
    @JoinColumn(name = "cod_candidate")
    private Candidate candidateVote;
    private LocalDate timestamp;

    public Votes() {
    }

    public Votes(Long codVote, Users userVote, Candidate candidateVote, LocalDate timestamp) {
        this.codVote = codVote;
        this.userVote = userVote;
        this.candidateVote = candidateVote;
        this.timestamp = timestamp;
    }

    public Long getCodVote() {
        return codVote;
    }

    public void setCodVote(Long codVote) {
        this.codVote = codVote;
    }

    public Long getUserVote() {
        return userVote.getCodUser();
    }

    public void setUserVote(Users userVote) {
        this.userVote = userVote;
    }

    public Long getCandidateVote() {
        return candidateVote.getCodCandidate();
    }

    public void setCandidateVote(Candidate candidateVote) {
        this.candidateVote = candidateVote;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

}
