package com.FitnessSACSpring.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Sesiones")
public class Sesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SesionID")
    private int sesionId;

    @Column(name = "Titulo", length = 150)
    private String titulo;

    @Column(name = "Tipo", nullable = false, length = 20)
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "LugarID", nullable = false)
    private Lugar lugar;

    @ManyToOne
    @JoinColumn(name = "TrainerID", nullable = false)
    private Trainer trainer;

    @Column(name = "FechaInicio", nullable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "FechaFin", nullable = false)
    private LocalDateTime fechaFin;

    @Column(name = "Capacidad")
    private Integer capacidad;

    @Column(name = "TiempoDesinfeccionMin")
    private Integer tiempoDesinfeccionMin;

    @Column(name = "Estado", length = 20)
    private String estado;

    // ======== Getters y Setters ========

    public int getSesionId() {
        return sesionId;
    }

    public void setSesionId(int sesionId) {
        this.sesionId = sesionId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getTiempoDesinfeccionMin() {
        return tiempoDesinfeccionMin;
    }

    public void setTiempoDesinfeccionMin(Integer tiempoDesinfeccionMin) {
        this.tiempoDesinfeccionMin = tiempoDesinfeccionMin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
