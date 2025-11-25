/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objetosnegocio.dominio;

/**
 *
 * @author santi
 */
public class DetalleVenta {
    private int  id;
    private RopaTalla ropaTalla;
    private int cantidadVendida;
    private double subtotal;

    public DetalleVenta() {}

    public DetalleVenta(RopaTalla ropaTalla, int cantidadVendida) {
        this.ropaTalla = ropaTalla;
        this.cantidadVendida = cantidadVendida;
        this.subtotal = ropaTalla.getRopa().getPrecio() * this.cantidadVendida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public RopaTalla getRopaTalla() { return ropaTalla; }
    public void setRopaTalla(RopaTalla ropaTalla) { this.ropaTalla = ropaTalla; }

    public int getCantidadVendida() { return cantidadVendida; }
    public void setCantidadVendida(int cantidadVendida) { this.cantidadVendida = cantidadVendida; }

    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }

    @Override
    public String toString() {
        return ropaTalla.toString() + " x" + cantidadVendida + " = $" + subtotal;
    }
}

