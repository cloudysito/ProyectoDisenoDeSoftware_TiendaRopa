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
public class BonificacionRecompenza {
    private ObjectId id;
    private Empleado nombreEmpleado;
    private Bonificacion nombreBonificacion;
    private Recompenza nombreRecompenza;
    
    public BonificacionRecompenza() {}
    
    public BonificacionRecompenza(Empleado nombreEmpleado, Bonificacion nombreBonificacion, Recompenza nombreRecompenza){
        this.nombreEmpleado = nombreEmpleado;
        this.nombreBonificacion = nombreBonificacion;
        this.nombreRecompenza = nombreRecompenza;
    }
    
    public BonificacionRecompenza(ObjectId id, Empleado nombreEmpleado, Bonificacion nombreBonificacion, Recompenza nombreRecompenza){
        this.id = id;
        this.nombreEmpleado = nombreEmpleado;
        this.nombreBonificacion = nombreBonificacion;
        this.nombreRecompenza = nombreRecompenza;
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

    public Bonificacion getNombreBonificacion() {
        return nombreBonificacion;
    }

    public void setNombreBonificacion(Bonificacion nombreBonificacion) {
        this.nombreBonificacion = nombreBonificacion;
    }

    public Recompenza getNombreRecompenza() {
        return nombreRecompenza;
    }

    public void setNombreRecompenza(Recompenza nombreRecompenza) {
        this.nombreRecompenza = nombreRecompenza;
    }
    
}
