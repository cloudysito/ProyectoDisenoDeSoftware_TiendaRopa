/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio.dominioPojo;

import org.bson.types.ObjectId;

/**
 *
 * @author riosr
 */
public class Capacitacion {
    private ObjectId id;
    private Empleado nombreEmpleado;
    private TemaCapacitacion temaCapacitacion;
    private String estado;
    
    
    public Capacitacion() {}
    
    public Capacitacion(Empleado nombreEmpleado, TemaCapacitacion temaCapacitacion, String estado){
        this.nombreEmpleado = nombreEmpleado;
        this.temaCapacitacion = temaCapacitacion;
        this.estado = estado;
    }

    public Capacitacion(ObjectId id, Empleado nombreEmpleado, TemaCapacitacion temaCapacitacion, String estado) {
        this.id = id;
        this.nombreEmpleado = nombreEmpleado;
        this.temaCapacitacion = temaCapacitacion;
        this.estado = estado;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Empleado getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(Empleado nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public TemaCapacitacion getTemaCapacitacion() {
        return temaCapacitacion;
    }

    public void setTemaCapacitacion(TemaCapacitacion temaCapacitacion) {
        this.temaCapacitacion = temaCapacitacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
