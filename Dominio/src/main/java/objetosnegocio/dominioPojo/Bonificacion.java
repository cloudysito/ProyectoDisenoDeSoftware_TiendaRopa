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
public class Bonificacion {
    private ObjectId idBonificacion;
    private Empleado nombreEmpleado;
    private int puntosTotales;
    private Recompensa nombreRecompensa;
    
    public Bonificacion() {}
    
    public Bonificacion(Empleado nombreEmpleado, int puntosTotales, Recompensa nombreRecompensa){
        this.nombreEmpleado = nombreEmpleado;
        this.puntosTotales = puntosTotales;
        this.nombreRecompensa = nombreRecompensa;
        
    }
    
    public Bonificacion(ObjectId id, Empleado nombreEmpleado, int puntosTotales, Recompensa nombreRecompensa){
        this.idBonificacion = idBonificacion;
        this.nombreEmpleado = nombreEmpleado;
        this.puntosTotales = puntosTotales;
        this.nombreRecompensa = nombreRecompensa;
    }

    public ObjectId getIdBonificacion() {
        return idBonificacion;
    }

    public void setIdBonificacion(ObjectId idBonificacion) {
        this.idBonificacion = idBonificacion;
    }

    public Empleado getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(Empleado nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public void setPuntosTotales(int puntosTotales) {
        this.puntosTotales = puntosTotales;
    }

    public Recompensa getNombreRecompensa() {
        return nombreRecompensa;
    }

    public void setNombreRecompensa(Recompensa nombreRecompensa) {
        this.nombreRecompensa = nombreRecompensa;
    }


    
}
