package com.FitnessSACSpring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.FitnessSACSpring.entity.Rol;
import com.FitnessSACSpring.repository.RolRepository;

@Controller
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolRepository rolRepository;

    @GetMapping("/listar")
    public String listarRoles(Model model) {
        List<Rol> listaRoles = rolRepository.findAll();
        model.addAttribute("listaRoles", listaRoles);
        return "rol/listar_rol";
    }
}
