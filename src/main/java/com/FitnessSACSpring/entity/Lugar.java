package com.FitnessSACSpring.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Lugares")
public class Lugar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LugarID")
    private int lugarId;

    @Column(name = "Nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "Tipo", nullable = false, length = 20)
    private String tipo;

    @Column(name = "Direccion", length = 250)
    private String direccion;

    @Column(name = "CapacidadMax")
    private Integer capacidadMax;

    // ======== Getters y Setters ========

    public int getLugarId() {
        return lugarId;
    }

    public void setLugarId(int lugarId) {
        this.lugarId = lugarId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(Integer capacidadMax) {
        this.capacidadMax = capacidadMax;
    }
}
