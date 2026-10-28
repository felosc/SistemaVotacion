package com.cleycer.Votacion.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"cod_user", "cod_election"}))
public class Votes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codVote;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_user")
    private Users userVote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_election")
    private Election electionVote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_candidate")
    private Candidate candidateVote;
    private LocalDateTime timestamp;

    public Votes() {
    }

    public Votes(Long codVote, Users userVote, Candidate candidateVote, Election electionVote, LocalDateTime timestamp) {
        this.codVote = codVote;
        this.userVote = userVote;
        this.candidateVote = candidateVote;
        this.electionVote = electionVote;
        this.timestamp = timestamp;
    }

    public Long getCodVote() {
        return codVote;
    }

    public void setCodVote(Long codVote) {
        this.codVote = codVote;
    }

    public Users getUserVote() {
        return userVote;
    }

    public void setUserVote(Users userVote) {
        this.userVote = userVote;
    }

    public Candidate getCandidateVote() {
        return candidateVote;
    }

    public void setCandidateVote(Candidate candidateVote) {
        this.candidateVote = candidateVote;
    }

    public Election getElectionVote() {
        return electionVote;
    }

    public void setElectionVote(Election electionVote) {
        this.electionVote = electionVote;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
