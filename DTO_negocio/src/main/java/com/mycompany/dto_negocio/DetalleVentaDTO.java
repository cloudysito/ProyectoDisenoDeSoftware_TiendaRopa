/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author santi
 */
public class DetalleVentaDTO {
    private String idDetalleVenta;
    private RopaTallaDTO ropaTalla;
    private int cantidadVendida;
    private double subtotal;

    public DetalleVentaDTO() {}
    
    private List<ItemVentaDTO> itemsComprados = new ArrayList<>();

    public DetalleVentaDTO(String idDetalleVenta, RopaTallaDTO ropaTalla, int cantidadVendida, double subtotal) {
        this.idDetalleVenta = idDetalleVenta;
        this.ropaTalla = ropaTalla;
        this.cantidadVendida = cantidadVendida;
        this.subtotal = subtotal;
    }

    public DetalleVentaDTO(RopaTallaDTO ropaTalla, int cantidadVendida, double subtotal) {
        this.ropaTalla = ropaTalla;
        this.cantidadVendida = cantidadVendida;
        this.subtotal = subtotal;
    }

    public String getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(String idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public RopaTallaDTO getRopaTalla() {
        return ropaTalla;
    }

    public void setRopaTalla(RopaTallaDTO ropaTalla) {
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

    public List<ItemVentaDTO> getItemsComprados() { 
        return itemsComprados; 
    }
    
    public void setItemsComprados(List<ItemVentaDTO> itemsComprados) { 
        this.itemsComprados = itemsComprados; 
    }
    
}
