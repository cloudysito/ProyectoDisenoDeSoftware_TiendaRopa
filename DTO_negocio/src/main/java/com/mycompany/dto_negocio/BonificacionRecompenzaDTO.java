/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

/**
 *
 * @author riosr
 */
public class BonificacionRecompenzaDTO {
    private String id;
    private EmpleadoDTO nombreEmpleado;
    private BonificacionDTO nombreBonificacion;
    private RecompenzaDTO nombreRecompenza;
    
    public BonificacionRecompenzaDTO() {}

    public BonificacionRecompenzaDTO(String id, EmpleadoDTO nombreEmpleado, BonificacionDTO nombreBonificacion, RecompenzaDTO nombreRecompenza) {
        this.id = id;
        this.nombreEmpleado = nombreEmpleado;
        this.nombreBonificacion = nombreBonificacion;
        this.nombreRecompenza = nombreRecompenza;
    }
    
    public BonificacionRecompenzaDTO(EmpleadoDTO nombreEmpleado, BonificacionDTO nombreBonificacion, RecompenzaDTO nombreRecompenza) {
        this.nombreEmpleado = nombreEmpleado;
        this.nombreBonificacion = nombreBonificacion;
        this.nombreRecompenza = nombreRecompenza;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EmpleadoDTO getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(EmpleadoDTO nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public BonificacionDTO getNombreBonificacion() {
        return nombreBonificacion;
    }

    public void setNombreBonificacion(BonificacionDTO nombreBonificacion) {
        this.nombreBonificacion = nombreBonificacion;
    }

    public RecompenzaDTO getNombreRecompenza() {
        return nombreRecompenza;
    }

    public void setNombreRecompenza(RecompenzaDTO nombreRecompenza) {
        this.nombreRecompenza = nombreRecompenza;
    }
    
}
