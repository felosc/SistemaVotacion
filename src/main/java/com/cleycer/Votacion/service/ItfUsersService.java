package com.cleycer.Votacion.service;

import com.cleycer.Votacion.dto.UserRequestDto;
import com.cleycer.Votacion.model.Users;

import java.util.List;

public interface ItfUsersService {
    //all user
    List<Users> getUsers();
    // one user
    Users searchUser(Long codUser);
    //create user
    Users createUser(Users userData);
    Users createUser(UserRequestDto userRequestDto);
    //edit user
    Users editUser(Long codUsers,Users userData);
    Users editUser(Long codUsers, UserRequestDto userRequestDto);
    //delete user
    boolean deleteUser(Long codUser);
}
