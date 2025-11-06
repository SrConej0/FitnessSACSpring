package com.FitnessSACSpring.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Faltas")
public class Falta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FaltaID")
    private int faltaId;

    @ManyToOne
    @JoinColumn(name = "UsuarioID", nullable = false)
    private Usuario usuario;

    @Column(name = "Cantidad", nullable = false)
    private int cantidad;

    @Column(name = "UltimaFalta")
    private LocalDateTime ultimaFalta;

    // ======== Getters y Setters ========

    public int getFaltaId() {
        return faltaId;
    }

    public void setFaltaId(int faltaId) {
        this.faltaId = faltaId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getUltimaFalta() {
        return ultimaFalta;
    }

    public void setUltimaFalta(LocalDateTime ultimaFalta) {
        this.ultimaFalta = ultimaFalta;
    }
}
