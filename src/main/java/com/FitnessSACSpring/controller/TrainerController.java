package com.FitnessSACSpring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.FitnessSACSpring.entity.Trainer;
import com.FitnessSACSpring.repository.TrainerRepository;

@Controller
@RequestMapping("/trainers")
public class TrainerController {

    @Autowired
    private TrainerRepository trainerRepository;

    @GetMapping("/listar")
    public String listarTrainers(Model model) {
        List<Trainer> listaTrainers = trainerRepository.findAll();
        model.addAttribute("listaTrainers", listaTrainers);
        return "trainer/listar_trainer";
    }
}
