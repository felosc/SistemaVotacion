package com.cleycer.Votacion.dto;

import java.time.LocalDateTime;

public class UserResponseDto {
    private Long codUser;
    private String username;
    private String email;
    private String rol;
    private LocalDateTime timestamp;

    public UserResponseDto() {
    }

    public UserResponseDto(Long codUser, String username, String email, String rol, LocalDateTime timestamp) {
        this.codUser = codUser;
        this.username = username;
        this.email = email;
        this.rol = rol;
        this.timestamp = timestamp;
    }

    public Long getCodUser() {
        return codUser;
    }

    public void setCodUser(Long codUser) {
        this.codUser = codUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
