/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objetosnegocio.dto;

/**
 *
 * @author santi
 */
public class ProductoDTO {
    private int idRopa;
    private String nombreArticulo;
    private String talla;
    private int cantidadDisponible;

    public ProductoDTO() {}

    public ProductoDTO(int idRopa, String nombreArticulo, String talla, int cantidadDisponible) {
        this.idRopa = idRopa;
        this.nombreArticulo = nombreArticulo;
        this.talla = talla;
        this.cantidadDisponible = cantidadDisponible;
    }

    public int getIdRopa() { return idRopa; }
    public void setIdRopa(int idRopa) { this.idRopa = idRopa; }

    public String getNombreArticulo() { return nombreArticulo; }
    public void setNombreArticulo(String nombreArticulo) { this.nombreArticulo = nombreArticulo; }

    public String getTalla() { return talla; }
    public void setTalla(String talla) { this.talla = talla; }

    public int getCantidadDisponible() { return cantidadDisponible; }
    public void setCantidadDisponible(int cantidadDisponible) { this.cantidadDisponible = cantidadDisponible; }
}

