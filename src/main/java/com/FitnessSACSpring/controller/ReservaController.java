package com.FitnessSACSpring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.FitnessSACSpring.entity.Reserva;
import com.FitnessSACSpring.repository.ReservaRepository;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping("/listar")
    public String listarReservas(Model model) {
        List<Reserva> listaReservas = reservaRepository.findAll();
        model.addAttribute("listaReservas", listaReservas);
        return "reserva/listar_reserva";
    }
}
