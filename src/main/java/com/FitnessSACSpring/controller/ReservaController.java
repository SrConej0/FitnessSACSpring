package com.FitnessSACSpring.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.FitnessSACSpring.entity.Reserva;
import com.FitnessSACSpring.entity.Usuario;
import com.FitnessSACSpring.entity.Sesion;
import com.FitnessSACSpring.repository.ReservaRepository;
import com.FitnessSACSpring.repository.UsuarioRepository;
import com.FitnessSACSpring.repository.SesionRepository;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SesionRepository sesionRepository;

    // Listar reservas
    @GetMapping("/listar")
    public String listarReservas(Model model) {
        List<Reserva> reservas = reservaRepository.findAll();
        model.addAttribute("reservas", reservas);
        return "reserva/listar_reserva"; // Thymeleaf HTML que creamos antes
    }

    // Formulario para nueva reserva
    @GetMapping("/nuevo")
    public String nuevaReserva(Model model) {
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("sesiones", sesionRepository.findAll());
        return "reserva/form_reserva";
    }

    // Formulario para editar reserva
    @GetMapping("/editar/{id}")
    public String editarReserva(@PathVariable("id") int id, Model model, RedirectAttributes ra) {
        Reserva reserva = reservaRepository.findReservaByReservaId(id);
        if (reserva == null) {
            ra.addFlashAttribute("error", "Reserva no encontrada");
            return "redirect:/reservas/listar";
        }
        model.addAttribute("reserva", reserva);
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("sesiones", sesionRepository.findAll());
        return "reserva/form_reserva";
    }

    // Guardar reserva (nuevo o edición)
    @PostMapping("/guardar")
    public String guardarReserva(@ModelAttribute Reserva reserva,
                                 @RequestParam("usuarioId") int usuarioId,
                                 @RequestParam("sesionId") int sesionId,
                                 RedirectAttributes ra) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        Sesion sesion = sesionRepository.findById(sesionId).orElse(null);
        if (usuario == null || sesion == null) {
            ra.addFlashAttribute("error", "Usuario o Sesión no válidos");
            return "redirect:/reservas/listar";
        }

        reserva.setUsuario(usuario);
        reserva.setSesion(sesion);

        // Fecha de registro si es nueva
        if (reserva.getReservaId() == 0) {
            reserva.setFechaReserva(LocalDateTime.now());
        }

        reservaRepository.save(reserva);
        ra.addFlashAttribute("msg", "Reserva guardada correctamente");
        return "redirect:/reservas/listar";
    }

    // Eliminar reserva
    @GetMapping("/eliminar/{id}")
    public String eliminarReserva(@PathVariable("id") int id, RedirectAttributes ra) {
        try {
            reservaRepository.deleteById(id);
            ra.addFlashAttribute("msg", "Reserva eliminada correctamente");
        } catch (Exception ex) {
            ra.addFlashAttribute("error", "No se pudo eliminar la reserva: " + ex.getMessage());
        }
        return "redirect:/reservas/listar";
    }
}
