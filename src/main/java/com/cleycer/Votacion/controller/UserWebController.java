package com.cleycer.Votacion.controller;
import com.cleycer.Votacion.model.Users;
import com.cleycer.Votacion.service.ItfUsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UserWebController {

    //esta vista esta generada con  Thymeleaf
    private final ItfUsersService UserService;

    public UserWebController(ItfUsersService userService) {
        UserService = userService;
    }

    //trae la lista de usuarios
    @GetMapping
    public String traerUsuarios (Model model){
        model.addAttribute(
                "usuarios",
                UserService.getUsers()
        );
        return "usuarios/lista";
    }

    //trae el formulario para crear un usuario
    @GetMapping("/nuevo")
    public String mostrarFormulario (Model model)
    {
        model.addAttribute("usuario", new Users());
        model.addAttribute("titulo","Resgistrar Nuevo Usuario");

        return "usuarios/formulario";
    }
    @PostMapping("/crear")
    public String cerarUsuario (@ModelAttribute Users usuario,Model model){
        Users datoUsuario;

        if (usuario.getCodUser()==null){
            datoUsuario = UserService.createUser(usuario);
        }else {
            datoUsuario = UserService.editUser(usuario.getCodUser(),usuario);
        }
        if (datoUsuario == null){
            model.addAttribute("usuario",usuario);
            //si el codigo es null el titulo dira Registrar usuario, si no es null dira Editar usuario
            model.addAttribute("titulo",usuario.getCodUser()==null?"Registrar usuario":"Editar usuario");
            model.addAttribute("error","Revisar que los datos esten diligenciados Correctamente");
            return "usuarios/formulario";

        }
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{codUsuario}")
    public String mostrarFormularioEditar(
            @PathVariable Long codUsuario,Model model){
        Users datosUsuario = UserService.searchUser(codUsuario);
        if (datosUsuario==null)
        {
            return "redirect:/usuarios";
        }
        model.addAttribute("usuario",datosUsuario);
        model.addAttribute("titulo","Editar usuario");

        return "usuarios/formulario";

    }
    @PostMapping("/eliminar/{codUsuario}")
    public String eliminarUsuario(@PathVariable Long codUsuario){
        UserService.deleteUser(codUsuario);
        return "redirect:/usuarios";
    }
}
