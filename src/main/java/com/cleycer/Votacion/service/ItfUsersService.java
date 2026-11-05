package com.cleycer.Votacion.service;

import com.cleycer.Votacion.dto.UserRequestDto;
import com.cleycer.Votacion.dto.UserResponseDto;
import com.cleycer.Votacion.model.Users;

import java.util.List;

public interface ItfUsersService {
    //all user
    List<UserResponseDto> getUsers();
    // one user
    UserResponseDto searchUserDto(Long codUser);
    Users searchUser(Long codUser);
    //create user
    Users createUser(Users userData);
    UserResponseDto createUser(UserRequestDto userRequestDto);
    //edit user
    Users editUser(Long codUsers, Users userData);
    UserResponseDto editUser(Long codUsers, UserRequestDto userRequestDto);
    //delete user
    boolean deleteUser(Long codUser);
}
