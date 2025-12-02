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
    private ObjectId idCapacitacion;
    private Empleado nombreEmpleado;
    private TemaCapacitacion temaCapacitacion;
    private String estado;
    
    
    public Capacitacion() {}
    
    public Capacitacion(Empleado nombreEmpleado, TemaCapacitacion temaCapacitacion, String estado){
        this.nombreEmpleado = nombreEmpleado;
        this.temaCapacitacion = temaCapacitacion;
        this.estado = estado;
    }

    public Capacitacion(ObjectId idCapacitacion, Empleado nombreEmpleado, TemaCapacitacion temaCapacitacion, String estado) {
        this.idCapacitacion = idCapacitacion;
        this.nombreEmpleado = nombreEmpleado;
        this.temaCapacitacion = temaCapacitacion;
        this.estado = estado;
    }

    public ObjectId getIdCapacitacion() {
        return idCapacitacion;
    }

    public void setIdCapacitacion(ObjectId idCapacitacion) {
        this.idCapacitacion = idCapacitacion;
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
