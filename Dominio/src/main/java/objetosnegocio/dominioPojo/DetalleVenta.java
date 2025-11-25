/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio.dominioPojo;

import org.bson.types.ObjectId;

public class DetalleVenta {

    private ObjectId id; 
    
    private RopaTalla ropaTalla;
    private int cantidadVendida;
    private double subtotal;

    public DetalleVenta() {}

    public DetalleVenta(RopaTalla ropaTalla, int cantidadVendida, double subtotal) {
        this.ropaTalla = ropaTalla;
        this.cantidadVendida = cantidadVendida;
        this.subtotal = subtotal;
    }
    
    public ObjectId getId() { return id; }
    public void setId(ObjectId id) { this.id = id; }
    public RopaTalla getRopaTalla() { return ropaTalla; }
    public void setRopaTalla(RopaTalla ropaTalla) { this.ropaTalla = ropaTalla; }
    public int getCantidadVendida() { return cantidadVendida; }
    public void setCantidadVendida(int cantidadVendida) { this.cantidadVendida = cantidadVendida; }
    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
}