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
    private int idProducto;
    private String talla;
    private int cantidadVendida;
    private int subtotal;

    public DetalleVentaDTO() {}

    public DetalleVentaDTO(int idProducto, String talla, int cantidadVendida, int subtotal) {
        this.idProducto = idProducto;
        this.talla = talla;
        this.cantidadVendida = cantidadVendida;
        this.subtotal = subtotal;
    }

    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    public String getTalla() { return talla; }
    public void setTalla(String talla) { this.talla = talla; }

    public int getCantidadVendida() { return cantidadVendida; }
    public void setCantidadVendida(int cantidadVendida) { this.cantidadVendida = cantidadVendida; }

    public int getSubtotal() { return subtotal; }
    public void setSubtotal(int subtotal) { this.subtotal = subtotal; }
}
