package com.FitnessSACSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.FitnessSACSpring.entity.Usuario;
import com.FitnessSACSpring.repository.UsuarioRepository;

/**
 * Controlador de autenticación básica.
 * Gestiona validación de usuarios en la ruta base "/login".
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Valida credenciales de usuario por email y password.
     * POST "/login/validarUsuario".
     * @param email correo del usuario
     * @param password contraseña en texto plano (ejemplo)
     * @return nombre del template Thymeleaf ("index" si falla, "principal" si éxito)
     */
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
