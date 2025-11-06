package com.FitnessSACSpring.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Asistencias")
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AsistenciaID")
    private int asistenciaId;

    @ManyToOne
    @JoinColumn(name = "ReservaID", nullable = false)
    private Reserva reserva;

    @Column(name = "Marca", nullable = false, length = 20)
    private String marca;

    @Column(name = "Observaciones", length = 500)
    private String observaciones;

    @Column(name = "FechaRegistro")
    private LocalDateTime fechaRegistro;

    // ======== Getters y Setters ========

    public int getAsistenciaId() {
        return asistenciaId;
    }

    public void setAsistenciaId(int asistenciaId) {
        this.asistenciaId = asistenciaId;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

   
}
