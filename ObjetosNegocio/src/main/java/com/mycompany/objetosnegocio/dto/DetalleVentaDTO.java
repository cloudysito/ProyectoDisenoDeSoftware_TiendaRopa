/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objetosnegocio.dto;

/**
 *
 * @author santi
 */
public class DetalleVentaDTO {
    private int idDetalleVenta;
    private String ropaTalla;
    private int cantidadVendida;
    private int subtotal;

    public DetalleVentaDTO() {}

    public DetalleVentaDTO(int idDetalleVenta, String ropaTalla, int cantidadVendida, int subtotal) {
        this.idDetalleVenta = idDetalleVenta;
        this.ropaTalla = ropaTalla;
        this.cantidadVendida = cantidadVendida;
        this.subtotal = subtotal;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public String getRopaTalla() {
        return ropaTalla;
    }

    public void setRopaTalla(String ropaTalla) {
        this.ropaTalla = ropaTalla;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    
}
