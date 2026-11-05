package com.cleycer.Votacion.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ElectionResponseDto {
    private Long codElection;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String state;
    private LocalDateTime timestamp;
    private Long codUserCreate;

    public ElectionResponseDto() {
    }

    public ElectionResponseDto(Long codElection, String title, String description, LocalDate startDate,
                               LocalDate endDate, String state, LocalDateTime timestamp, Long codUserCreate) {
        this.codElection = codElection;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = state;
        this.timestamp = timestamp;
        this.codUserCreate = codUserCreate;
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

    public Long getCodUserCreate() {
        return codUserCreate;
    }

    public void setCodUserCreate(Long codUserCreate) {
        this.codUserCreate = codUserCreate;
    }
}
