package com.FitnessSACSpring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.FitnessSACSpring.entity.Lugar;
import com.FitnessSACSpring.repository.LugarRepository;

@Controller
@RequestMapping("/lugares")
public class LugarController {

    @Autowired
    private LugarRepository lugarRepository;

    @GetMapping("/listar")
    public String listarLugares(Model model) {
        List<Lugar> listaLugares = lugarRepository.findAll();
        model.addAttribute("listaLugares", listaLugares);
        return "lugar/listar_lugar";
    }
}
