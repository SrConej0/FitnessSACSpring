package com.FitnessSACSpring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.FitnessSACSpring.entity.Membresia;
import com.FitnessSACSpring.entity.Plan;
import com.FitnessSACSpring.entity.Usuario;
import com.FitnessSACSpring.repository.MembresiaRepository;
import com.FitnessSACSpring.repository.PlanRepository;
import com.FitnessSACSpring.repository.UsuarioRepository;

@Controller
@RequestMapping("/membresias")
public class MembresiaController {

    @Autowired
    private MembresiaRepository membresiaRepository;
    @Autowired private UsuarioRepository usuarioRepository;
    @Autowired private PlanRepository planRepository;

    /**
     * Lista todas las membresías o filtra por usuarioId/estado.
     */
    @GetMapping({"/listar", "/buscar"})
    public String listarMembresias(
            @RequestParam(value = "usuarioId", required = false) Integer usuarioId,
            @RequestParam(value = "estado", required = false) String estado,
            Model model) {
        List<Membresia> listaMembresias;
        if (usuarioId != null) {
            listaMembresias = membresiaRepository.findByUsuarioUsuarioId(usuarioId);
        } else if (estado != null && !estado.isBlank()) {
            // Si existe método por estado lo usamos; si no, filtramos en memoria.
            listaMembresias = membresiaRepository.findAll().stream()
                    .filter(m -> estado.equalsIgnoreCase(m.getEstado()))
                    .toList();
        } else {
            listaMembresias = membresiaRepository.findAll();
        }
        model.addAttribute("listaMembresias", listaMembresias);
        model.addAttribute("usuarioId", usuarioId);
        model.addAttribute("estado", estado);
        return "membresia/listar_membresia";
    }

    /** Muestra formulario de nueva membresía. */
    @GetMapping("/nuevo")
    public String nuevaMembresia(Model model) {
        model.addAttribute("membresia", new Membresia());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("planes", planRepository.findAll());
        return "membresia/form_membresia";
    }

    /** Muestra formulario de edición. */
    @GetMapping("/editar/{id}")
    public String editarMembresia(@PathVariable("id") int id, Model model, RedirectAttributes ra) {
        Membresia m = membresiaRepository.findById(id).orElse(null);
        if (m == null) {
            ra.addFlashAttribute("error", "La membresía no existe");
            return "redirect:/membresias/listar";
        }
        model.addAttribute("membresia", m);
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("planes", planRepository.findAll());
        return "membresia/form_membresia";
    }

    /** Guarda membresía (crear/actualizar). */
    @PostMapping("/guardar")
    public String guardarMembresia(@ModelAttribute("membresia") Membresia membresia,
                                   @RequestParam("usuarioId") int usuarioId,
                                   @RequestParam("planId") int planId,
                                   RedirectAttributes ra) {
        Usuario u = usuarioRepository.findById(usuarioId).orElse(null);
        Plan p = planRepository.findById(planId).orElse(null);
        if (u == null || p == null) {
            ra.addFlashAttribute("error", "Usuario o Plan inválido");
            return "redirect:/membresias/listar";
        }
        membresia.setUsuario(u);
        membresia.setPlan(p);
        membresiaRepository.save(membresia);
        ra.addFlashAttribute("exito", "Membresía guardada correctamente");
        return "redirect:/membresias/listar";
    }

    /** Elimina membresía. */
    @PostMapping("/eliminar/{id}")
    public String eliminarMembresia(@PathVariable("id") int id, RedirectAttributes ra) {
        if (membresiaRepository.existsById(id)) {
            membresiaRepository.deleteById(id);
            ra.addFlashAttribute("exito", "Membresía eliminada");
        } else {
            ra.addFlashAttribute("error", "La membresía no existe");
        }
        return "redirect:/membresias/listar";
    }
}
