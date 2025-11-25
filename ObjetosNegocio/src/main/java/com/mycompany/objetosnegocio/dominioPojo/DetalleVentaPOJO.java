/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objetosnegocio.dominioPojo;

import com.mycompany.objetosnegocio.dominio.RopaTalla;
import java.io.Serializable;

/**
 *
 * @author emiim
 */
public class DetalleVentaPOJO implements Serializable {
    private static final long serialVersionUID = 1L; 

    private int id;
    private RopaTalla ropaTalla;
    private int cantidadVendida;
    private double subtotal;
    private VentaPOJO venta;

    public DetalleVentaPOJO(){}
    
    public DetalleVentaPOJO (int id, RopaTalla ropaTalla, int cantidadVendida, double subtotal) {
        this.id = id;
        this.ropaTalla = ropaTalla;
        this.cantidadVendida = cantidadVendida;
        this.subtotal = subtotal;
    }

    public DetalleVentaPOJO(RopaTalla ropaTalla, int cantidadVendida) {
        this.ropaTalla = ropaTalla;
        this.cantidadVendida = cantidadVendida;
        if (ropaTalla != null && ropaTalla.getRopa() != null) {
            this.subtotal = ropaTalla.getRopa().getPrecio() * cantidadVendida;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RopaTalla getRopaTalla() {
        return ropaTalla;
    }

    public void setRopaTalla(RopaTalla ropaTalla) {
        this.ropaTalla = ropaTalla;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public VentaPOJO getVenta() {
        return venta;
    }

    public void setVenta(VentaPOJO venta) {
        this.venta = venta;
    }
  
    @Override
    public String toString() {
        return "DetalleVenta{" + "id=" + id + ", cantidad=" + cantidadVendida + ", subtotal=" + subtotal + '}';
    }
}
