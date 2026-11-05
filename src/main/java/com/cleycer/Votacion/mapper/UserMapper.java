package com.cleycer.Votacion.mapper;

import com.cleycer.Votacion.dto.UserResponseDto;
import com.cleycer.Votacion.model.Users;

public class UserMapper {
    private UserMapper() {
    }

    public static UserResponseDto toDto(Users user) {
        if (user == null) {
            return null;
        }
        return new UserResponseDto(
                user.getCodUser(),
                user.getUsername(),
                user.getEmail(),
                user.getRol(),
                user.getTimestamp()
        );
    }
}
