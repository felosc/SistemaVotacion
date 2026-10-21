package com.cleycer.Votacion.model;


import jakarta.persistence.*;

@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codCandidate;
    private String name;
    private String description;
    private int orderTicket;
    private String imgUrl;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_election")
    private Election electionCandidate ;

    public Candidate(){}

    public Candidate(Long codCandidate, String name, String description, int orderTicket, String imgUrl, Election electionCandidate) {

        this.codCandidate = codCandidate;
        this.name = name;
        this.description = description;
        this.orderTicket = orderTicket;
        this.imgUrl = imgUrl;
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

    public int getOrderTicket() {
        return orderTicket;
    }

    public void setOrderTicket(int orderTicket) {
        this.orderTicket = orderTicket;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getElectionCandidate() {
        return electionCandidate.getCodElection();
    }

    public void setElectionCandidate(Election electionCandidate) {
        this.electionCandidate = electionCandidate;
    }
}
