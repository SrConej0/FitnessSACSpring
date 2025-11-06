package com.FitnessSACSpring.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "InformesSesiones")
public class InformeSesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InformeID")
    private int informeId;

    @ManyToOne
    @JoinColumn(name = "SesionID", nullable = false)
    private Sesion sesion;

    @ManyToOne
    @JoinColumn(name = "TrainerID", nullable = false)
    private Trainer trainer;

    @Column(name = "Contenido", columnDefinition = "nvarchar(max)")
    private String contenido;

    @Column(name = "FechaRegistro")
    private LocalDateTime fechaRegistro;

    // ======== Getters y Setters ========

    public int getInformeId() {
        return informeId;
    }

    public void setInformeId(int informeId) {
        this.informeId = informeId;
    }

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

}
