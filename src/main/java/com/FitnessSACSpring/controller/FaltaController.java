package com.FitnessSACSpring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.FitnessSACSpring.entity.Falta;
import com.FitnessSACSpring.repository.FaltaRepository;

@Controller
@RequestMapping("/faltas")
public class FaltaController {

    @Autowired
    private FaltaRepository faltaRepository;

    @GetMapping("/listar")
    public String listarFaltas(Model model) {
        List<Falta> listaFaltas = faltaRepository.findAll();
        model.addAttribute("listaFaltas", listaFaltas);
        return "falta/listar_falta";
    }
}
