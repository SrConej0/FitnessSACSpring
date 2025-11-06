package com.FitnessSACSpring.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RolID")
    private int rolId;

    @Column(name = "Nombre", nullable = false, length = 50)
    private String nombre;

    // ======== Getters y Setters ========

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
