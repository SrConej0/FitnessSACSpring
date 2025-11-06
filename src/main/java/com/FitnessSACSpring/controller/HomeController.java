package com.FitnessSACSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.FitnessSACSpring.entity.*;
import com.FitnessSACSpring.repository.*;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private SesionRepository sesionRepository;

    @Autowired
    private SancionRepository sancionRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private MembresiaRepository membresiaRepository;

    @Autowired
    private LugarRepository lugarRepository;

    @Autowired
    private InformeSesionRepository informeSesionRepository;

    @Autowired
    private FaltaRepository faltaRepository;

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    // ============ USUARIOS ============
    @GetMapping("/gestionUsuarios")
    public String mostrarGestionUsuarios(Model model) {
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        model.addAttribute("listaUsuarios", listaUsuarios);
        return "gestion/gestionUsuarios";
    }

    // ============ TRAINERS ============
    @GetMapping("/gestionTrainers")
    public String mostrarGestionTrainers(Model model) {
        List<Trainer> listaTrainers = trainerRepository.findAll();
        model.addAttribute("listaTrainers", listaTrainers);
        return "gestion/gestionTrainers";
    }

    // ============ SESIONES ============
    @GetMapping("/gestionSesiones")
    public String mostrarGestionSesiones(Model model) {
        List<Sesion> listaSesiones = sesionRepository.findAll();
        model.addAttribute("listaSesiones", listaSesiones);
        return "gestion/gestionSesiones";
    }

    // ============ SANCIONES ============
    @GetMapping("/gestionSanciones")
    public String mostrarGestionSanciones(Model model) {
        List<Sancion> listaSanciones = sancionRepository.findAll();
        model.addAttribute("listaSanciones", listaSanciones);
        return "gestion/gestionSanciones";
    }

    // ============ ROLES ============
    @GetMapping("/gestionRoles")
    public String mostrarGestionRoles(Model model) {
        List<Rol> listaRoles = rolRepository.findAll();
        model.addAttribute("listaRoles", listaRoles);
        return "gestion/gestionRoles";
    }

    // ============ RESERVAS ============
    @GetMapping("/gestionReservas")
    public String mostrarGestionReservas(Model model) {
        List<Reserva> listaReservas = reservaRepository.findAll();
        model.addAttribute("listaReservas", listaReservas);
        return "gestion/gestionReservas";
    }

    // ============ PLANES ============
    @GetMapping("/gestionPlanes")
    public String mostrarGestionPlanes(Model model) {
        List<Plan> listaPlanes = planRepository.findAll();
        model.addAttribute("listaPlanes", listaPlanes);
        return "gestion/gestionPlanes";
    }

    // ============ MEMBRESIAS ============
    @GetMapping("/gestionMembresias")
    public String mostrarGestionMembresias(Model model) {
        List<Membresia> listaMembresias = membresiaRepository.findAll();
        model.addAttribute("listaMembresias", listaMembresias);
        return "gestion/gestionMembresias";
    }

    // ============ LUGARES ============
    @GetMapping("/gestionLugares")
    public String mostrarGestionLugares(Model model) {
        List<Lugar> listaLugares = lugarRepository.findAll();
        model.addAttribute("listaLugares", listaLugares);
        return "gestion/gestionLugares";
    }

    // ============ INFORMES DE SESIONES ============
    @GetMapping("/gestionInformes")
    public String mostrarGestionInformes(Model model) {
        List<InformeSesion> listaInformes = informeSesionRepository.findAll();
        model.addAttribute("listaInformes", listaInformes);
        return "gestion/gestionInformes";
    }

    // ============ FALTAS ============
    @GetMapping("/gestionFaltas")
    public String mostrarGestionFaltas(Model model) {
        List<Falta> listaFaltas = faltaRepository.findAll();
        model.addAttribute("listaFaltas", listaFaltas);
        return "gestion/gestionFaltas";
    }

    // ============ ASISTENCIAS ============
    @GetMapping("/gestionAsistencias")
    public String mostrarGestionAsistencias(Model model) {
        List<Asistencia> listaAsistencias = asistenciaRepository.findAll();
        model.addAttribute("listaAsistencias", listaAsistencias);
        return "gestion/gestionAsistencias";
    }
}

