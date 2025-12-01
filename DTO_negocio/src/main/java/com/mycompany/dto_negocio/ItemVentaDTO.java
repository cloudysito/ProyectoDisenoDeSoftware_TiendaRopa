/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

/**
 *
 * @author emiim
 */
public class ItemVentaDTO {
    private RopaTallaDTO ropaTalla;
    
    private double precioUnitario;
    private int cantidadComprada;

    public ItemVentaDTO() {}

    public RopaTallaDTO getRopaTalla() {
        return ropaTalla;
    }

    public void setRopaTalla(RopaTallaDTO ropaTalla) {
        this.ropaTalla = ropaTalla;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }
}
