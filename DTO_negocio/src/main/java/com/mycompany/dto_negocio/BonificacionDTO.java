/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

/**
 *
 * @author riosr
 */
public class BonificacionDTO {
    private String idBonificacion;
    private EmpleadoDTO nombreEmpleado;
    private int puntosTotales;
    private RecompensaDTO nombreRecompensa;

    public BonificacionDTO() {}
    
    public BonificacionDTO(String idBonificacion, EmpleadoDTO nombreEmpleado, int puntosTotales, RecompensaDTO nombreRecompensa) {
        this.idBonificacion = idBonificacion;
        this.nombreEmpleado = nombreEmpleado;
        this.puntosTotales = puntosTotales;
        this.nombreRecompensa = nombreRecompensa;
    }
    
    public BonificacionDTO(EmpleadoDTO nombreEmpleado, int puntosTotales, RecompensaDTO nombreRecompensa){
        this.nombreEmpleado = nombreEmpleado;
        this.puntosTotales = puntosTotales;
        this.nombreRecompensa = nombreRecompensa;
    }

    public String getIdBonificacion() {
        return idBonificacion;
    }

    public void setIdBonificacion(String idBonificacion) {
        this.idBonificacion = idBonificacion;
    }

    public EmpleadoDTO getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(EmpleadoDTO nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public void setPuntosTotales(int puntosTotales) {
        this.puntosTotales = puntosTotales;
    }

    public RecompensaDTO getNombreRecompensa() {
        return nombreRecompensa;
    }

    public void setNombreRecompensa(RecompensaDTO nombreRecompensa) {
        this.nombreRecompensa = nombreRecompensa;
    }
    
}
