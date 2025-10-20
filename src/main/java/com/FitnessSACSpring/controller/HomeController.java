package com.FitnessSACSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.FitnessSACSpring.entity.*;
import com.FitnessSACSpring.repository.*;

/**
 * Controlador de Home: agrupa vistas de gestión para entidades del sistema.
 * Base path: "/home". Carga datos de repositorios y renderiza templates Thymeleaf
 * ubicados bajo "gestion/*".
 */
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
    /**
     * Lista usuarios y muestra la vista de gestión de usuarios.
     * GET "/home/gestionUsuarios".
     */
    @GetMapping("/gestionUsuarios")
    public String mostrarGestionUsuarios(Model model) {
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        model.addAttribute("listaUsuarios", listaUsuarios);
        return "gestion/gestionUsuarios";
    }

    // ============ TRAINERS ============
    /**
     * Lista trainers y muestra la vista de gestión de trainers.
     * GET "/home/gestionTrainers".
     */
    @GetMapping("/gestionTrainers")
    public String mostrarGestionTrainers(Model model) {
        List<Trainer> listaTrainers = trainerRepository.findAll();
        model.addAttribute("listaTrainers", listaTrainers);
        return "gestion/gestionTrainers";
    }

    // ============ SESIONES ============
    /**
     * Lista sesiones y muestra la vista de gestión de sesiones.
     * GET "/home/gestionSesiones".
     */
    @GetMapping("/gestionSesiones")
    public String mostrarGestionSesiones(Model model) {
        List<Sesion> listaSesiones = sesionRepository.findAll();
        model.addAttribute("listaSesiones", listaSesiones);
        return "gestion/gestionSesiones";
    }

    // ============ SANCIONES ============
    /**
     * Lista sanciones y muestra la vista de gestión de sanciones.
     * GET "/home/gestionSanciones".
     */
    @GetMapping("/gestionSanciones")
    public String mostrarGestionSanciones(Model model) {
        List<Sancion> listaSanciones = sancionRepository.findAll();
        model.addAttribute("listaSanciones", listaSanciones);
        return "gestion/gestionSanciones";
    }

    // ============ ROLES ============
    /**
     * Lista roles y muestra la vista de gestión de roles.
     * GET "/home/gestionRoles".
     */
    @GetMapping("/gestionRoles")
    public String mostrarGestionRoles(Model model) {
        List<Rol> listaRoles = rolRepository.findAll();
        model.addAttribute("listaRoles", listaRoles);
        return "gestion/gestionRoles";
    }

    // ============ RESERVAS ============
    /**
     * Lista reservas y muestra la vista de gestión de reservas.
     * GET "/home/gestionReservas".
     */
    @GetMapping("/gestionReservas")
    public String mostrarGestionReservas(Model model) {
        List<Reserva> listaReservas = reservaRepository.findAll();
        model.addAttribute("listaReservas", listaReservas);
        return "gestion/gestionReservas";
    }

    // ============ PLANES ============
    /**
     * Lista planes y muestra la vista de gestión de planes.
     * GET "/home/gestionPlanes".
     */
    @GetMapping("/gestionPlanes")
    public String mostrarGestionPlanes(Model model) {
        List<Plan> listaPlanes = planRepository.findAll();
        model.addAttribute("listaPlanes", listaPlanes);
        return "gestion/gestionPlanes";
    }

    // ============ MEMBRESIAS ============
    /**
     * Lista membresías y muestra la vista de gestión de membresías.
     * GET "/home/gestionMembresias".
     */
    @GetMapping("/gestionMembresias")
    public String mostrarGestionMembresias(Model model) {
        List<Membresia> listaMembresias = membresiaRepository.findAll();
        model.addAttribute("listaMembresias", listaMembresias);
        return "gestion/gestionMembresias";
    }

    // ============ LUGARES ============
    /**
     * Lista lugares y muestra la vista de gestión de lugares.
     * GET "/home/gestionLugares".
     */
    @GetMapping("/gestionLugares")
    public String mostrarGestionLugares(Model model) {
        List<Lugar> listaLugares = lugarRepository.findAll();
        model.addAttribute("listaLugares", listaLugares);
        return "gestion/gestionLugares";
    }

    // ============ INFORMES DE SESIONES ============
    /**
     * Lista informes de sesión y muestra la vista de gestión de informes.
     * GET "/home/gestionInformes".
     */
    @GetMapping("/gestionInformes")
    public String mostrarGestionInformes(Model model) {
        List<InformeSesion> listaInformes = informeSesionRepository.findAll();
        model.addAttribute("listaInformes", listaInformes);
        return "gestion/gestionInformes";
    }

    // ============ FALTAS ============
    /**
     * Lista faltas y muestra la vista de gestión de faltas.
     * GET "/home/gestionFaltas".
     */
    @GetMapping("/gestionFaltas")
    public String mostrarGestionFaltas(Model model) {
        List<Falta> listaFaltas = faltaRepository.findAll();
        model.addAttribute("listaFaltas", listaFaltas);
        return "gestion/gestionFaltas";
    }

    // ============ ASISTENCIAS ============
    /**
     * Lista asistencias y muestra la vista de gestión de asistencias.
     * GET "/home/gestionAsistencias".
     */
    @GetMapping("/gestionAsistencias")
    public String mostrarGestionAsistencias(Model model) {
        List<Asistencia> listaAsistencias = asistenciaRepository.findAll();
        model.addAttribute("listaAsistencias", listaAsistencias);
        return "gestion/gestionAsistencias";
    }
}

