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
public class TemaCapacitacion {
    private ObjectId idTemaCapacitacion;
    private String temaCapacitacion;
    
    public TemaCapacitacion() {}

    public TemaCapacitacion(String temaCapacitacion){
        this.temaCapacitacion = temaCapacitacion;
    }
    public TemaCapacitacion(ObjectId idTemaCapacitacion, String temaCapacitacion) {
        this.idTemaCapacitacion = idTemaCapacitacion;
        this.temaCapacitacion = temaCapacitacion;
    }

    public ObjectId getIdTemaCapacitacion() {
        return idTemaCapacitacion;
    }

    public void setIdTemaCapacitacion(ObjectId idTemaCapacitacion) {
        this.idTemaCapacitacion = idTemaCapacitacion;
    }

    public String getTemaCapacitacion() {
        return temaCapacitacion;
    }

    public void setTemaCapacitacion(String temaCapacitacion) {
        this.temaCapacitacion = temaCapacitacion;
    }
    
    
}
