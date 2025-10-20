package com.FitnessSACSpring.controller;

import java.util.List;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.FitnessSACSpring.entity.Usuario;
import com.FitnessSACSpring.entity.Rol;
import com.FitnessSACSpring.entity.Reserva;
import com.FitnessSACSpring.entity.Asistencia;
import com.FitnessSACSpring.entity.Membresia;
import com.FitnessSACSpring.entity.Falta;
import com.FitnessSACSpring.entity.Sancion;
import com.FitnessSACSpring.entity.Trainer;
import com.FitnessSACSpring.entity.Sesion;
import com.FitnessSACSpring.entity.InformeSesion;

import com.FitnessSACSpring.repository.UsuarioRepository;
import com.FitnessSACSpring.repository.RolRepository;
import com.FitnessSACSpring.repository.ReservaRepository;
import com.FitnessSACSpring.repository.AsistenciaRepository;
import com.FitnessSACSpring.repository.MembresiaRepository;
import com.FitnessSACSpring.repository.FaltaRepository;
import com.FitnessSACSpring.repository.SancionRepository;
import com.FitnessSACSpring.repository.TrainerRepository;
import com.FitnessSACSpring.repository.SesionRepository;
import com.FitnessSACSpring.repository.InformeSesionRepository;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired private ReservaRepository reservaRepository;
    @Autowired private AsistenciaRepository asistenciaRepository;
    @Autowired private MembresiaRepository membresiaRepository;
    @Autowired private FaltaRepository faltaRepository;
    @Autowired private SancionRepository sancionRepository;
    @Autowired private TrainerRepository trainerRepository;
    @Autowired private SesionRepository sesionRepository;
    @Autowired private InformeSesionRepository informeSesionRepository;

    @GetMapping("/listar")
    public String listarUsuarios(@RequestParam(value = "q", required = false) String q, Model model) {
        List<Usuario> listaUsuarios;
        if (q != null && !q.trim().isEmpty()) {
            listaUsuarios = usuarioRepository.findByNombreContainingIgnoreCaseOrEmailContainingIgnoreCase(q, q);
            model.addAttribute("q", q);
        } else {
            listaUsuarios = usuarioRepository.findAll();
        }
        model.addAttribute("listaUsuarios", listaUsuarios);
        return "usuario/listar_usuario";
    }

    @GetMapping("/nuevo")
    public String nuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", rolRepository.findAll());
        return "usuario/form_usuario";
    }

    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable("id") int id, Model model) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null) {
            return "redirect:/usuarios/listar";
        }
        model.addAttribute("usuario", usuario);
        model.addAttribute("roles", rolRepository.findAll());
        return "usuario/form_usuario";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario, @RequestParam("rolId") int rolId, RedirectAttributes ra) {
        Rol rol = rolRepository.findById(rolId).orElse(null);
        usuario.setRol(rol);
        if (usuario.getUsuarioId() != 0) {
            Usuario existente = usuarioRepository.findById(usuario.getUsuarioId()).orElse(null);
            if (existente != null) {
                // Fecha debe ser actual en edición
                usuario.setFechaRegistro(LocalDateTime.now());
                // Mantener password si llega vacía
                if (usuario.getPasswordHash() == null || usuario.getPasswordHash().isBlank()) {
                    usuario.setPasswordHash(existente.getPasswordHash());
                }
            }
        } else {
            usuario.setFechaRegistro(LocalDateTime.now());
        }
        usuarioRepository.save(usuario);
        ra.addFlashAttribute("msg", "Usuario guardado correctamente");
        return "redirect:/usuarios/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuarioGet(@PathVariable("id") int id, RedirectAttributes ra) {
        try {
            // 1) Eliminar reservas y asistencias del usuario
            List<Reserva> reservasUsuario = reservaRepository.findByUsuarioUsuarioId(id);
            for (Reserva r : reservasUsuario) {
                List<Asistencia> asistencias = asistenciaRepository.findByReservaReservaId(r.getReservaId());
                for (Asistencia a : asistencias) {
                    asistenciaRepository.deleteById(a.getAsistenciaId());
                }
                reservaRepository.deleteById(r.getReservaId());
            }

            // 2) Eliminar membresías del usuario
            List<Membresia> membresias = membresiaRepository.findByUsuarioUsuarioId(id);
            for (Membresia m : membresias) {
                membresiaRepository.deleteById(m.getMembresiaId());
            }

            // 3) Eliminar sanción y falta del usuario (si existen)
            Sancion sancion = sancionRepository.findByUsuarioUsuarioId(id);
            if (sancion != null) {
                sancionRepository.deleteById(sancion.getSancionId());
            }
            Falta falta = faltaRepository.findByUsuarioUsuarioId(id);
            if (falta != null) {
                faltaRepository.deleteById(falta.getFaltaId());
            }

            // 4) Si el usuario es trainer, eliminar sus sesiones, reservas relacionadas e informes
            List<Trainer> trainers = trainerRepository.findByUsuarioUsuarioId(id);
            for (Trainer t : trainers) {
                List<Sesion> sesiones = sesionRepository.findByTrainerTrainerId(t.getTrainerId());
                for (Sesion s : sesiones) {
                    // Informes de la sesión
                    List<InformeSesion> informes = informeSesionRepository.findBySesionSesionId(s.getSesionId());
                    for (InformeSesion inf : informes) {
                        informeSesionRepository.deleteById(inf.getInformeId());
                    }
                    // Reservas de la sesión y sus asistencias
                    List<Reserva> reservasSesion = reservaRepository.findBySesionSesionId(s.getSesionId());
                    for (Reserva r : reservasSesion) {
                        List<Asistencia> asistenciasSesion = asistenciaRepository.findByReservaReservaId(r.getReservaId());
                        for (Asistencia a : asistenciasSesion) {
                            asistenciaRepository.deleteById(a.getAsistenciaId());
                        }
                        reservaRepository.deleteById(r.getReservaId());
                    }
                    // Eliminar la sesión
                    sesionRepository.deleteById(s.getSesionId());
                }
                // Eliminar el trainer
                trainerRepository.deleteById(t.getTrainerId());
            }

            // 5) Finalmente, eliminar el usuario
            usuarioRepository.deleteById(id);
            ra.addFlashAttribute("msg", "Usuario eliminado");
        } catch (Exception ex) {
            ra.addFlashAttribute("error", "No se pudo eliminar el usuario: " + ex.getMessage());
        }
        return "redirect:/usuarios/listar";
    }
}
