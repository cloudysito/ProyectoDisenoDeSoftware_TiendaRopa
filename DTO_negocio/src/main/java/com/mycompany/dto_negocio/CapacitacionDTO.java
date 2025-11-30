/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

/**
 *
 * @author riosr
 */
public class CapacitacionDTO {
    private String idCapacitacion;
    private String temaCapacitacion;
    private String estado;
    
    public CapacitacionDTO() {}
    
    public CapacitacionDTO(String idCapacitacion, String temaCapacitacion, String estado){
        this.idCapacitacion = idCapacitacion;
        this.temaCapacitacion = temaCapacitacion;
        this.estado = estado;
    }
    
    public CapacitacionDTO(String temaCapacitacion, String estado){
        this.idCapacitacion = temaCapacitacion;
        this.estado = estado;
    }

    public String getIdCapacitacion() {
        return idCapacitacion;
    }

    public void setIdCapacitacion(String idCapacitacion) {
        this.idCapacitacion = idCapacitacion;
    }

    public String getTemaCapacitacion() {
        return temaCapacitacion;
    }

    public void setTemaCapacitacion(String temaCapacitacion) {
        this.temaCapacitacion = temaCapacitacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
