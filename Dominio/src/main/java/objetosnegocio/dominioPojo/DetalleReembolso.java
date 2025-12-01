/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio.dominioPojo;

import org.bson.types.ObjectId;

/**
 *
 * @author emiim
 */
public class DetalleReembolso {
    private ObjectId id; 
    private RopaTalla ropaTalla; 
    
    private int cantidadDevuelta;
    private double subtotalReembolsado;

    public DetalleReembolso() {
        this.id = new ObjectId();
    }

    public DetalleReembolso(RopaTalla ropaTalla, int cantidadDevuelta, double subtotalReembolsado) {
        this.id = new ObjectId();
        this.ropaTalla = ropaTalla;
        this.cantidadDevuelta = cantidadDevuelta;
        this.subtotalReembolsado = subtotalReembolsado;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public RopaTalla getRopaTalla() {
        return ropaTalla;
    }

    public void setRopaTalla(RopaTalla ropaTalla) {
        this.ropaTalla = ropaTalla;
    }

    public int getCantidadDevuelta() {
        return cantidadDevuelta;
    }

    public void setCantidadDevuelta(int cantidadDevuelta) {
        this.cantidadDevuelta = cantidadDevuelta;
    }

    public double getSubtotalReembolsado() {
        return subtotalReembolsado;
    }

    public void setSubtotalReembolsado(double subtotalReembolsado) {
        this.subtotalReembolsado = subtotalReembolsado;
    }
}
