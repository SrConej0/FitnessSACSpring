package com.FitnessSACSpring.controller;

import com.FitnessSACSpring.entity.Sancion;
import com.FitnessSACSpring.entity.Usuario;
import com.FitnessSACSpring.repository.SancionRepository;
import com.FitnessSACSpring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/sanciones")
public class SancionController {

    @Autowired
    private SancionRepository sancionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/listar")
    public String listarSanciones(Model model) {
        List<Sancion> listaSanciones = sancionRepository.findAll();
        model.addAttribute("listaSanciones", listaSanciones);
        return "sancion/listar_sancion";
    }

    @GetMapping("/nuevo")
    public String nuevaSancion(Model model) {
        model.addAttribute("sancion", new Sancion());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "sancion/form_sancion";
    }

    @GetMapping("/editar/{id}")
    public String editarSancion(@PathVariable("id") int id, Model model, RedirectAttributes ra) {
        Sancion sancion = sancionRepository.findById(id).orElse(null);
        if (sancion == null) {
            ra.addFlashAttribute("error", "La sanción no existe");
            return "redirect:/sanciones/listar";
        }
        model.addAttribute("sancion", sancion);
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "sancion/form_sancion";
    }

    @PostMapping("/guardar")
    public String guardarSancion(
            @ModelAttribute Sancion sancion,
            @RequestParam("usuarioId") int usuarioId,
            RedirectAttributes ra) {

        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        sancion.setUsuario(usuario);

        // Validación de fechas
        if (sancion.getFechaInicio() == null) {
            sancion.setFechaInicio(LocalDateTime.now());
        }
        if (sancion.getFechaFin() == null || sancion.getFechaFin().isBefore(sancion.getFechaInicio())) {
            sancion.setFechaFin(sancion.getFechaInicio().plusDays(7)); // sanción de ejemplo de 7 días
        }

        sancionRepository.save(sancion);
        ra.addFlashAttribute("msg", "Sanción guardada correctamente");
        return "redirect:/sanciones/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarSancion(@PathVariable("id") int id, RedirectAttributes ra) {
        try {
            sancionRepository.deleteById(id);
            ra.addFlashAttribute("msg", "Sanción eliminada correctamente");
        } catch (Exception e) {
            ra.addFlashAttribute("error", "No se pudo eliminar la sanción: " + e.getMessage());
        }
        return "redirect:/sanciones/listar";
    }
}
