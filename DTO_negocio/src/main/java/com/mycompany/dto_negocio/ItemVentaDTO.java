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
    private String idRopaTalla;
    private String nombrePrenda;
    private String talla;
    private double precioUnitario;
    private int cantidadComprada;

    public ItemVentaDTO() {
    }

    public ItemVentaDTO(String idRopaTalla, String nombrePrenda, String talla, double precioUnitario, int cantidadComprada) {
        this.idRopaTalla = idRopaTalla;
        this.nombrePrenda = nombrePrenda;
        this.talla = talla;
        this.precioUnitario = precioUnitario;
        this.cantidadComprada = cantidadComprada;
    }

    public String getIdRopaTalla() { return idRopaTalla; }
    public void setIdRopaTalla(String idRopaTalla) { this.idRopaTalla = idRopaTalla; }

    public String getNombrePrenda() { return nombrePrenda; }
    public void setNombrePrenda(String nombrePrenda) { this.nombrePrenda = nombrePrenda; }

    public String getTalla() { return talla; }
    public void setTalla(String talla) { this.talla = talla; }

    public double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(double precioUnitario) { this.precioUnitario = precioUnitario; }

    public int getCantidadComprada() { return cantidadComprada; }
    public void setCantidadComprada(int cantidadComprada) { this.cantidadComprada = cantidadComprada; }
}
