package com.FitnessSACSpring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.FitnessSACSpring.entity.Plan;
import com.FitnessSACSpring.repository.PlanRepository;

/**
 * Controlador de planes.
 * CRUD: listar, buscar, nuevo, editar y eliminar.
 */
@Controller
@RequestMapping("/planes")
public class PlanController {

    @Autowired
    private PlanRepository planRepository;

    /**
     * Lista todos los planes o busca por nombre.
     * GET "/planes/listar" y "/planes/buscar?q=...".
     */
    @GetMapping({"/listar", "/buscar"})
    public String listarPlanes(@RequestParam(value = "q", required = false) String q, Model model) {
        List<Plan> listaPlanes = (q == null || q.isBlank())
                ? planRepository.findAll()
                : List.of(planRepository.findByNombre(q)).stream().filter(p -> p != null).toList();
        model.addAttribute("listaPlanes", listaPlanes);
        model.addAttribute("q", q);
        return "plan/listar_plan";
    }

    /**
     * Muestra formulario para crear un nuevo plan.
     */
    @GetMapping("/nuevo")
    public String nuevoPlan(Model model) {
        model.addAttribute("plan", new Plan());
        return "plan/form_plan";
    }

    /**
     * Muestra formulario para editar un plan existente.
     */
    @GetMapping("/editar/{id}")
    public String editarPlan(@PathVariable("id") int id, Model model, RedirectAttributes ra) {
        Plan plan = planRepository.findById(id).orElse(null);
        if (plan == null) {
            ra.addFlashAttribute("error", "El plan no existe");
            return "redirect:/planes/listar";
        }
        model.addAttribute("plan", plan);
        return "plan/form_plan";
    }

    /**
     * Guarda un plan (crear/actualizar).
     */
    @PostMapping("/guardar")
    public String guardarPlan(@ModelAttribute("plan") Plan plan, RedirectAttributes ra) {
        planRepository.save(plan);
        ra.addFlashAttribute("exito", "Plan guardado correctamente");
        return "redirect:/planes/listar";
    }

    /**
     * Elimina un plan por ID.
     */
    @PostMapping("/eliminar/{id}")
    public String eliminarPlan(@PathVariable("id") int id, RedirectAttributes ra) {
        if (planRepository.existsById(id)) {
            planRepository.deleteById(id);
            ra.addFlashAttribute("exito", "Plan eliminado");
        } else {
            ra.addFlashAttribute("error", "El plan no existe");
        }
        return "redirect:/planes/listar";
    }
}
