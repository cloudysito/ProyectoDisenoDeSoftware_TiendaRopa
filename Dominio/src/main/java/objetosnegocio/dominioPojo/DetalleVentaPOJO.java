/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio.dominioPojo;

import java.io.Serializable;

public class DetalleVentaPOJO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id; 
    
    private RopaTallaPOJO ropaTalla;
    private int cantidadVendida;
    private double subtotal;

    public DetalleVentaPOJO() {}

    public DetalleVentaPOJO(RopaTallaPOJO ropaTalla, int cantidadVendida, double subtotal) {
        this.ropaTalla = ropaTalla;
        this.cantidadVendida = cantidadVendida;
        this.subtotal = subtotal;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public RopaTallaPOJO getRopaTalla() { return ropaTalla; }
    public void setRopaTalla(RopaTallaPOJO ropaTalla) { this.ropaTalla = ropaTalla; }
    public int getCantidadVendida() { return cantidadVendida; }
    public void setCantidadVendida(int cantidadVendida) { this.cantidadVendida = cantidadVendida; }
    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
}