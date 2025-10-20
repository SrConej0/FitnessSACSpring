package com.FitnessSACSpring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.FitnessSACSpring.entity.Sancion;
import com.FitnessSACSpring.repository.SancionRepository;

@Controller
@RequestMapping("/sanciones")
public class SancionController {

    @Autowired
    private SancionRepository sancionRepository;

    @GetMapping("/listar")
    public String listarSanciones(Model model) {
        List<Sancion> listaSanciones = sancionRepository.findAll();
        model.addAttribute("listaSanciones", listaSanciones);
        return "sancion/listar_sancion";
    }
}
