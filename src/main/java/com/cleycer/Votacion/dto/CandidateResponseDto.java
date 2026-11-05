package com.cleycer.Votacion.dto;

import java.time.LocalDateTime;

public class CandidateResponseDto {
    private Long codCandidate;
    private String name;
    private String description;
    private Integer orderTicket;
    private String imgUrl;
    private LocalDateTime timestamp;
    private Long codElection;

    public CandidateResponseDto() {
    }

    public CandidateResponseDto(Long codCandidate, String name, String description, Integer orderTicket,
                                String imgUrl, LocalDateTime timestamp, Long codElection) {
        this.codCandidate = codCandidate;
        this.name = name;
        this.description = description;
        this.orderTicket = orderTicket;
        this.imgUrl = imgUrl;
        this.timestamp = timestamp;
        this.codElection = codElection;
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

    public Long getCodElection() {
        return codElection;
    }

    public void setCodElection(Long codElection) {
        this.codElection = codElection;
    }
}
