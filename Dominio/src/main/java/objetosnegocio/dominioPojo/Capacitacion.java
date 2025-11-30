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
    private String temaCapacitacion;
    private String estado;
    
    public Capacitacion() {}
    
    public Capacitacion(String temaCapacitacion, String estado){
        this.temaCapacitacion = temaCapacitacion;
        this.estado = estado;
    }
    
    public Capacitacion(ObjectId id, String temaCapacitacion, String estado){
        this.id = id;
        this.temaCapacitacion = temaCapacitacion;
        this.estado = estado;
    }
    
    public ObjectId getId() {
        return id;
    }
    
    public void setId(ObjectId id) {
        this.id = id;
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
