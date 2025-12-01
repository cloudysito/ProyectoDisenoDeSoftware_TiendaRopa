/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

/**
 *
 * @author riosr
 */
public class TemaCapacitacionDTO {
    private String idTemaCapacitacion;
    private String temaCapacitacion;
    
    public TemaCapacitacionDTO() {}
    
    public TemaCapacitacionDTO(String idTemaCapacitacion, String temaCapacitacion){
        this.idTemaCapacitacion = idTemaCapacitacion;
        this.temaCapacitacion = temaCapacitacion;
    }
    
    public TemaCapacitacionDTO(String temaCapacitacion){
        this.temaCapacitacion = temaCapacitacion;
    }

    public String getIdTemaCapacitacion() {
        return idTemaCapacitacion;
    }

    public void setIdTemaCapacitacion(String idTemaCapacitacion) {
        this.idTemaCapacitacion = idTemaCapacitacion;
    }

    public String getTemaCapacitacion() {
        return temaCapacitacion;
    }

    public void setTemaCapacitacion(String temaCapacitacion) {
        this.temaCapacitacion = temaCapacitacion;
    }
    
}
