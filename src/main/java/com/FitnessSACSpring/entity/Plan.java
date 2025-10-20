package com.FitnessSACSpring.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Planes")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PlanID")
    private int planId;

    @Column(name = "Nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "Categoria", length = 50)
    private String categoria;

    @Column(name = "DuracionDias", nullable = false)
    private int duracionDias;

    @Column(name = "EntrenamientosMes")
    private Integer entrenamientosMes;

    @Column(name = "EntrenamientosGrupales")
    private Integer entrenamientosGrupales;

    @Column(name = "EntrenamientosPersonales")
    private Integer entrenamientosPersonales;

    @Column(name = "Precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "DiasAvisoVencimiento")
    private Integer diasAvisoVencimiento;

    // ======== Getters y Setters ========

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getDuracionDias() {
        return duracionDias;
    }

    public void setDuracionDias(int duracionDias) {
        this.duracionDias = duracionDias;
    }

    public Integer getEntrenamientosMes() {
        return entrenamientosMes;
    }

    public void setEntrenamientosMes(Integer entrenamientosMes) {
        this.entrenamientosMes = entrenamientosMes;
    }

    public Integer getEntrenamientosGrupales() {
        return entrenamientosGrupales;
    }

    public void setEntrenamientosGrupales(Integer entrenamientosGrupales) {
        this.entrenamientosGrupales = entrenamientosGrupales;
    }

    public Integer getEntrenamientosPersonales() {
        return entrenamientosPersonales;
    }

    public void setEntrenamientosPersonales(Integer entrenamientosPersonales) {
        this.entrenamientosPersonales = entrenamientosPersonales;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getDiasAvisoVencimiento() {
        return diasAvisoVencimiento;
    }

    public void setDiasAvisoVencimiento(Integer diasAvisoVencimiento) {
        this.diasAvisoVencimiento = diasAvisoVencimiento;
    }
}
