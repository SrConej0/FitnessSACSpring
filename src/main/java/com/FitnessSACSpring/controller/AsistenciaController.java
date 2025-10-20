package com.FitnessSACSpring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.FitnessSACSpring.entity.Asistencia;
import com.FitnessSACSpring.repository.AsistenciaRepository;

@Controller
@RequestMapping("/asistencias")
public class AsistenciaController {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    @GetMapping("/listar")
    public String listarAsistencias(Model model) {
        List<Asistencia> listaAsistencias = asistenciaRepository.findAll();
        model.addAttribute("listaAsistencias", listaAsistencias);
        return "asistencia/listar_asistencia";
    }
}
