package com.cleycer.Votacion.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRequestDto {
    @NotBlank(message = "username is required")
    private String username;
    @NotBlank(message = "email is required")
    @Email
    @Size(min=8)
    private String email;
    @NotBlank(message = "password is required")
    private String password;
    @NotBlank(message = "rol is required")
    private String rol;



    public UserRequestDto() {
    }

    public UserRequestDto(String username, String email, String password, String rol) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.rol = rol;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
