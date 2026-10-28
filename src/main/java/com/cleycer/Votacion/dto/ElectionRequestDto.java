package com.cleycer.Votacion.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ElectionRequestDto {
    @NotBlank(message = "title is required")
    private String title;
    @NotBlank(message = "description is required")
    private String description;
    @NotNull(message = "startDate is required")
    private LocalDate startDate;
    @NotNull(message = "endDate is required")
    private LocalDate endDate;
    @NotBlank(message = "state is required")
// (Ojo con el typo en tu JSON si dice endDate)
    private String state;
    @NotNull(message = "userCreate is required")
    private Long userCreate; // ¡Aquí sí va como Long, para recibir el 3!

    public ElectionRequestDto() {
    }

    public ElectionRequestDto(String title, String description, LocalDate startDate, LocalDate endDate, String state, Long userCreate) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = state;
        this.userCreate = userCreate;
    }

    // Getters y Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public Long getUserCreate() { return userCreate; }
    public void setUserCreate(Long userCreate) { this.userCreate = userCreate; }
}
