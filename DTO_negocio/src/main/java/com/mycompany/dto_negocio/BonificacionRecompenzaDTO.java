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
    private String idBonificacionRecompenza;
    private EmpleadoDTO nombreEmpleado;
    private BonificacionDTO nombreBonificacion;
    private RecompenzaDTO nombreRecompenza;
    
    public BonificacionRecompenzaDTO() {}

    public BonificacionRecompenzaDTO(String idBonificacionRecompenza, EmpleadoDTO nombreEmpleado, BonificacionDTO nombreBonificacion, RecompenzaDTO nombreRecompenza) {
        this.idBonificacionRecompenza = idBonificacionRecompenza;
        this.nombreEmpleado = nombreEmpleado;
        this.nombreBonificacion = nombreBonificacion;
        this.nombreRecompenza = nombreRecompenza;
    }
    
    public BonificacionRecompenzaDTO(EmpleadoDTO nombreEmpleado, BonificacionDTO nombreBonificacion, RecompenzaDTO nombreRecompenza) {
        this.nombreEmpleado = nombreEmpleado;
        this.nombreBonificacion = nombreBonificacion;
        this.nombreRecompenza = nombreRecompenza;
    }

    public String getIdBonificacionRecompenza() {
        return idBonificacionRecompenza;
    }

    public void setIdBonificacionRecompenza(String id) {
        this.idBonificacionRecompenza = idBonificacionRecompenza;
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
