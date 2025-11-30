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
    private ObjectId id;
    private String descripcion;
    private int cantidadVenta;
    
    public Bonificacion() {}
    
    public Bonificacion(String descripcion,int cantidadVenta){
        this.descripcion = descripcion;
        this.cantidadVenta = cantidadVenta;
    }
    
    public Bonificacion(ObjectId id, String descripcion, int cantidadVenta){
        this.id = id;
        this.descripcion = descripcion;
        this.cantidadVenta = cantidadVenta;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadVenta() {
        return cantidadVenta;
    }

    public void setCantidadVenta(int cantidadVenta) {
        this.cantidadVenta = cantidadVenta;
    }
    
}
