package com.cleycer.Votacion.controller;

import com.cleycer.Votacion.model.Users;
import com.cleycer.Votacion.service.ItfUsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Users")
public class UserRestController {
    private final ItfUsersService UserService;

    public UserRestController(ItfUsersService userService) {
        UserService = userService;
    }

    //traer todos los usuarios
    @GetMapping
    public List<Users> getUsesrs (){
        return UserService.getUsers();
    }

    //traer un solo producto
    @GetMapping("/{codUser}")
    //el "?" indica que la respuesta puede ser el usuario o un null se llama  "opcional"
    public ResponseEntity<?>
    searchUser(@PathVariable Long codUser){
        Users user = UserService.searchUser(codUser);
        if (user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not Found");
        }
        return ResponseEntity.ok(user);
    }

    //crear usuario
    @PostMapping
    public ResponseEntity<?>
    createUser(@RequestBody Users userData){
        Users newUser = UserService.createUser(userData);

        if (newUser == null){
            return ResponseEntity.badRequest().body("the data no are valid");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    //editar usuario
    @PutMapping("/{codUser}")
    public ResponseEntity<?>
    editUser(@PathVariable Long codUser, @RequestBody Users UserEditData){
        Users editUser = UserService.editUser(codUser,UserEditData);
        if (editUser == null){
            return ResponseEntity.badRequest().body("Error to edit User");
        }
        return ResponseEntity.ok(editUser);
    }

    //borrar usuario "mala practica"
    @DeleteMapping("/{codUser}")
    public ResponseEntity<String> deleteUser (@PathVariable Long codUser){
        boolean delete = UserService.deleteUser(codUser);
        if (delete == false){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UserId: " + codUser + " not Found");
        }
        return ResponseEntity.ok("User Deleted");
    }

}
