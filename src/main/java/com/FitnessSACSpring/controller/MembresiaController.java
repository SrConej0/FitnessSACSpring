package com.FitnessSACSpring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.FitnessSACSpring.entity.Membresia;
import com.FitnessSACSpring.repository.MembresiaRepository;

@Controller
@RequestMapping("/membresias")
public class MembresiaController {

    @Autowired
    private MembresiaRepository membresiaRepository;

    @GetMapping("/listar")
    public String listarMembresias(Model model) {
        List<Membresia> listaMembresias = membresiaRepository.findAll();
        model.addAttribute("listaMembresias", listaMembresias);
        return "membresia/listar_membresia";
    }
}
