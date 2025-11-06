package com.FitnessSACSpring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.FitnessSACSpring.entity.InformeSesion;
import com.FitnessSACSpring.repository.InformeSesionRepository;

@Controller
@RequestMapping("/informes")
public class InformeSesionController {

    @Autowired
    private InformeSesionRepository informeSesionRepository;

    @GetMapping("/listar")
    public String listarInformes(Model model) {
        List<InformeSesion> listaInformes = informeSesionRepository.findAll();
        model.addAttribute("listaInformes", listaInformes);
        return "informe/listar_informe";
    }
}
