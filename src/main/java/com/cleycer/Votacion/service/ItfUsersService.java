package com.cleycer.Votacion.service;

import com.cleycer.Votacion.model.Users;

import java.util.List;

public interface ItfUsersService {
    //all user
    List<Users> getUsers();
    // one user
    Users searchUser(Long codUser);
    //create user
    Users createUser(Users userData);
    //edit user
    Users editUser(Long codUsers,Users userData);
    //delete user
    boolean deleteUser(Long codUser);
}
