package com.cleycer.Votacion.dto;

import java.time.LocalDate;

public class ElectionCreateDto {
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endtDate; // (Ojo con el typo en tu JSON si dice endtDate)
    private String state;
    private LocalDate timestamp;
    private Long userCreate; // ¡Aquí sí va como Long, para recibir el 3!

    // Getters y Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndtDate() { return endtDate; }
    public void setEndtDate(LocalDate endtDate) { this.endtDate = endtDate; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public LocalDate getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDate timestamp) { this.timestamp = timestamp; }
    public Long getUserCreate() { return userCreate; }
    public void setUserCreate(Long userCreate) { this.userCreate = userCreate; }
}
