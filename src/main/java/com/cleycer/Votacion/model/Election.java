package com.cleycer.Votacion.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Election {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codElection;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String state;
    private LocalDateTime timestamp;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_user")
    private Users userCreate;

    public Election(){}

    public Election(Long codElection, String title, String description, LocalDate startDate, LocalDate endDate, String state, LocalDateTime timestamp, Users userCreate) {
        this.codElection = codElection;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = state;
        this.timestamp = timestamp;
        this.userCreate = userCreate;
    }

    public Long getCodElection() {
        return codElection;
    }

    public void setCodElection(Long codElection) {
        this.codElection = codElection;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @PrePersist
    public void prePersist() {
        if (this.timestamp == null) {
            this.timestamp = LocalDateTime.now();
        }
    }

    public Long getUserCreate() {
        return userCreate.getCodUser();
    }

    public void setUserCreate(Users userCreate) {
        this.userCreate = userCreate;
    }
}
