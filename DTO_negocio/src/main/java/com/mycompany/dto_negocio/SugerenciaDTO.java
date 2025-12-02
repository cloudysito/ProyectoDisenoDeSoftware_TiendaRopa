/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

import java.util.Date;

/**
 *
 * @author santi
 */
public class SugerenciaDTO {
    private String id;
    private EmpleadoDTO empleado;
    private String descripcion;
    private String estado;
    private Date fechaPublicacion;

    public SugerenciaDTO(String id, EmpleadoDTO empleado, String descripcion, String estado, Date fechaPublicacion) {
        this.id = id;
        this.empleado = empleado;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaPublicacion = fechaPublicacion;
    }

    public SugerenciaDTO() {
    }

    public SugerenciaDTO(EmpleadoDTO empleado, String descripcion, String estado, Date fechaPublicacion) {
        this.empleado = empleado;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EmpleadoDTO getEmpleadoDTO() {
        return empleado;
    }

    public void setEmpleadoDTO(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    
    
    
}
