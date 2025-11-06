package com.FitnessSACSpring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.FitnessSACSpring.entity.Lugar;
import com.FitnessSACSpring.repository.LugarRepository;

@Controller
@RequestMapping("/lugares")
public class LugarController {

    @Autowired
    private LugarRepository lugarRepository;

    @GetMapping("/listar")
    public String listarLugares(@RequestParam(value = "q", required = false) String q, Model model) {
        List<Lugar> listaLugares;
        if (q != null && !q.trim().isEmpty()) {
            // Búsqueda por nombre o dirección
            listaLugares = lugarRepository.findByNombreContainingIgnoreCaseOrDireccionContainingIgnoreCase(q, q);
            model.addAttribute("q", q);
        } else {
            listaLugares = lugarRepository.findAll();
        }
        model.addAttribute("listaLugares", listaLugares);
        return "lugar/listar_lugares";
    }

    @GetMapping("/nuevo")
    public String nuevoLugar(Model model) {
        model.addAttribute("lugar", new Lugar());
        return "lugar/form_lugares";
    }

    @GetMapping("/editar/{id}")
    public String editarLugar(@PathVariable("id") int id, Model model) {
        Lugar lugar = lugarRepository.findById(id).orElse(null);
        if (lugar == null) {
            return "redirect:/lugares/listar";
        }
        model.addAttribute("lugar", lugar);
        return "lugar/form_lugares";
    }

    @PostMapping("/guardar")
    public String guardarLugar(@ModelAttribute Lugar lugar, RedirectAttributes ra) {
        lugarRepository.save(lugar);
        ra.addFlashAttribute("msg", "Lugar guardado correctamente");
        return "redirect:/lugares/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarLugar(@PathVariable("id") int id, RedirectAttributes ra) {
        try {
            lugarRepository.deleteById(id);
            ra.addFlashAttribute("msg", "Lugar eliminado correctamente");
        } catch (Exception ex) {
            ra.addFlashAttribute("error", "No se pudo eliminar el lugar: " + ex.getMessage());
        }
        return "redirect:/lugares/listar";
    }
}