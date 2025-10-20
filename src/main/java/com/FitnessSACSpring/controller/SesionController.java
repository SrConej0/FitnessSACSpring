package com.FitnessSACSpring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.FitnessSACSpring.entity.Sesion;
import com.FitnessSACSpring.repository.SesionRepository;

@Controller
@RequestMapping("/sesiones")
public class SesionController {

    @Autowired
    private SesionRepository sesionRepository;

    @GetMapping("/listar")
    public String listarSesiones(Model model) {
        List<Sesion> listaSesiones = sesionRepository.findAll();
        model.addAttribute("listaSesiones", listaSesiones);
        return "sesion/listar_sesion";
    }
}
