package com.cleycer.Votacion.service;

import com.cleycer.Votacion.model.Users;
import com.cleycer.Votacion.repository.ItfUsersRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService implements ItfUsersService {

    private final ItfUsersRespository userRepo;

    public UsersService(ItfUsersRespository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<Users> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public Users searchUser(Long codUser) {
        return userRepo.findById(codUser).orElse(null);
    }

    @Override
    public Users createUser(Users userData) {
        if (userData==null)
        {
            return null;
        }

        //valida si algun dato del objeto es null de ser asi no pasa
        boolean valido = this.validateDataUSer(userData);
        if(valido == false)
        {
            return null;
        }

        //por si depues de guardar el dato se necesita el id para unaventana nueva
        return userRepo.save(userData) ;
    }

    @Override
    public Users editUser(Long codUsers, Users userData)  {
        Users userExisting = searchUser(codUsers);
        //valida si el objeto en si es null
        if (userExisting==null){
            return null;
        }
        //valida si algun dato del objeto es null de ser asi no pasa
        boolean valido = this.validateDataUSer(userData);
        if(valido == false)
        {
            return null;
        }

        userExisting.setEmail(userData.getEmail());
        userExisting.setUsername(userData.getUsername());

        return  userRepo.save(userExisting);
    }

    @Override
    public boolean deleteUser(Long codUser) {

        Users userExisting = searchUser(codUser);

        if (userExisting == null)
        {
        return false;
        }
        userRepo.delete(userExisting);
        return true;
    }

    public boolean validateDataUSer(Users userData)
    {
        if (userData.getUsername()==null || userData.getUsername().isBlank())
        {
            return false;
        }

        if (userData.getEmail()==null || userData.getEmail().isBlank())
        {
            return false;
        }

        if (userData.getPassword()==null || userData.getPassword().isBlank())
        {
            return false;
        }

        if (userData.getRol()==null || userData.getRol().isBlank())
        {
            return false;
        }
        return true;
    }
}
