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
    private EmpleadoDTO nombreEmpleado;
    private TemaCapacitacionDTO temaCapacitacion;
    private String estado;
    
    public CapacitacionDTO() {}
    
    public CapacitacionDTO(String idCapacitacion, EmpleadoDTO nombreEmpleado, TemaCapacitacionDTO temaCapacitacion, String estado){
        this.idCapacitacion = idCapacitacion;
        this.nombreEmpleado = nombreEmpleado;
        this.temaCapacitacion = temaCapacitacion;
        this.estado = estado;
    }
    
    public CapacitacionDTO(EmpleadoDTO nombreEmpleado, TemaCapacitacionDTO temaCapacitacion, String estado){
        this.nombreEmpleado = nombreEmpleado;
        this.temaCapacitacion = temaCapacitacion;
        this.estado = estado;
    }

    public String getIdCapacitacion() {
        return idCapacitacion;
    }

    public void setIdCapacitacion(String idCapacitacion) {
        this.idCapacitacion = idCapacitacion;
    }

    public EmpleadoDTO getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(EmpleadoDTO nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public TemaCapacitacionDTO getTemaCapacitacion() {
        return temaCapacitacion;
    }

    public void setTemaCapacitacion(TemaCapacitacionDTO temaCapacitacion) {
        this.temaCapacitacion = temaCapacitacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
