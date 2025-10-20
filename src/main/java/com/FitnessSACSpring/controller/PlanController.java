package com.FitnessSACSpring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.FitnessSACSpring.entity.Plan;
import com.FitnessSACSpring.repository.PlanRepository;

@Controller
@RequestMapping("/planes")
public class PlanController {

    @Autowired
    private PlanRepository planRepository;

    @GetMapping("/listar")
    public String listarPlanes(Model model) {
        List<Plan> listaPlanes = planRepository.findAll();
        model.addAttribute("listaPlanes", listaPlanes);
        return "plan/listar_plan";
    }
}
