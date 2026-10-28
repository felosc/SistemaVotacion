package com.cleycer.Votacion.dto;

import jakarta.validation.constraints.NotNull;

public class VoteRequestDto {
    @NotNull(message = "codUser is required")
    private Long codUser;

    @NotNull(message = "codCandidate is required")
    private Long codCandidate;

    public VoteRequestDto() {
    }

    public VoteRequestDto(Long codUser, Long codCandidate) {
        this.codUser = codUser;
        this.codCandidate = codCandidate;
    }

    public Long getCodUser() {
        return codUser;
    }

    public void setCodUser(Long codUser) {
        this.codUser = codUser;
    }

    public Long getCodCandidate() {
        return codCandidate;
    }

    public void setCodCandidate(Long codCandidate) {
        this.codCandidate = codCandidate;
    }
}
