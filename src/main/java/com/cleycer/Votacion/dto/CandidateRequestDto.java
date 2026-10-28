package com.cleycer.Votacion.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CandidateRequestDto {
    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "description is required")
    private String description;
    @NotNull(message = "orderTicket is required")
    @Min(1)
    private Integer orderTicket;
    @NotBlank(message = "imgUrl is required")
    private String imgUrl;
    @NotNull(message = "codElection is required")
    private Long codElection;


    public CandidateRequestDto() {
    }

    public CandidateRequestDto(String name, String description, Integer orderTicket, String imgUrl, Long codElection) {
        this.name = name;
        this.description = description;
        this.orderTicket = orderTicket;
        this.imgUrl = imgUrl;
        this.codElection = codElection;
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

    public Long getCodElection() {
        return codElection;
    }

    public void setCodElection(Long codElection) {
        this.codElection = codElection;
    }
}
