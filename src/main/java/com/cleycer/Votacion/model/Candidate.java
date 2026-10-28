package com.cleycer.Votacion.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codCandidate;
    private String name;
    private String description;
    private Integer orderTicket;
    private String imgUrl;
    private LocalDateTime timestamp;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_election")
    private Election electionCandidate;

    public Candidate() {
    }

    public Candidate(Long codCandidate, String name, String description, Integer orderTicket, String imgUrl,
            LocalDateTime timestamp, Election electionCandidate) {

        this.codCandidate = codCandidate;
        this.name = name;
        this.description = description;
        this.orderTicket = orderTicket;
        this.imgUrl = imgUrl;
        this.timestamp = timestamp;
        this.electionCandidate = electionCandidate;
    }

    public Long getCodCandidate() {
        return codCandidate;
    }

    public void setCodCandidate(Long codCandidate) {
        this.codCandidate = codCandidate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrderTicket() {
        return orderTicket;
    }

    public void setOrderTicket(Integer orderTicket) {
        this.orderTicket = orderTicket;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Election getElectionCandidate() {
        return electionCandidate;
    }

    public void setElectionCandidate(Election electionCandidate) {
        this.electionCandidate = electionCandidate;
    }

    @PrePersist
    public void prePersist() {
        if (this.timestamp == null) {
            this.timestamp = LocalDateTime.now();
        }
    }
}
