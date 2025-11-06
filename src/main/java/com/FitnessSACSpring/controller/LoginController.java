package com.FitnessSACSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.FitnessSACSpring.entity.Usuario;
import com.FitnessSACSpring.repository.UsuarioRepository;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/validarUsuario")
    public String validarUsuario(@RequestParam("email") String email,
                                 @RequestParam("password") String password) {

        Usuario usuario = usuarioRepository.findByEmailAndPasswordHash(email, password);

        if (usuario == null) {
            return "index"; // usuario no encontrado
        } else {
            return "principal"; // acceso exitoso
        }
    }
}
