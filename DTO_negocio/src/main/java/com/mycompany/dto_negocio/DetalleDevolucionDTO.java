/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

public class DetalleDevolucionDTO {
    
    private String idRopaTalla;
    private String nombrePrenda;
    private String talla;
    private int cantidadDevuelta;
    private double subtotalReembolsado;

    public DetalleDevolucionDTO() {
    }

    public DetalleDevolucionDTO(String idRopaTalla, String nombrePrenda, String talla, int cantidadDevuelta, double subtotalReembolsado) {
        this.idRopaTalla = idRopaTalla;
        this.nombrePrenda = nombrePrenda;
        this.talla = talla;
        this.cantidadDevuelta = cantidadDevuelta;
        this.subtotalReembolsado = subtotalReembolsado;
    }

    public String getIdRopaTalla() {
        return idRopaTalla;
    }

    public void setIdRopaTalla(String idRopaTalla) {
        this.idRopaTalla = idRopaTalla;
    }

    public String getNombrePrenda() {
        return nombrePrenda;
    }

    public void setNombrePrenda(String nombrePrenda) {
        this.nombrePrenda = nombrePrenda;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
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
