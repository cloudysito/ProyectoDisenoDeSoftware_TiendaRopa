/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

/**
 *
 * @author emiim
 */
public class DetalleReembolsoDTO {
    private RopaTallaDTO ropaTalla;
    
    private int cantidadDevuelta;
    private double subtotalReembolsado;

    public DetalleReembolsoDTO() {}

    public RopaTallaDTO getRopaTalla() {
        return ropaTalla;
    }

    public void setRopaTalla(RopaTallaDTO ropaTalla) {
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
    
    public String getNombrePrenda() {
        if (ropaTalla != null && ropaTalla.getRopa() != null) {
            return ropaTalla.getRopa().getNombreArticulo();
        }
        return "Desconocido";
    }
}
