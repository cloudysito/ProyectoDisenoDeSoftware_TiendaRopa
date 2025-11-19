/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objetosnegocio.dominio;

/**
 *
 * @author santi
 */
public class Ropa {
    private int idRopa;
    private String nombreArticulo;
    private double precio;
    private String descripcion;
    private String Temporada;
    private String Marca;
    private  String Material;

    public Ropa() {}

    public Ropa( String nombreArticulo, String descripcion, String Temporada, String Marca, String Material, double precio) {

        this.nombreArticulo = nombreArticulo;
        this.descripcion = descripcion;
        this.Temporada = Temporada;
        this.Marca = Marca;
        this.Material = Material;
        this.precio = precio;
    }

    
    public int getIdRopa() { return idRopa; }
    public void setIdRopa(int idRopa) { this.idRopa = idRopa; }

    public String getNombreArticulo() { return nombreArticulo; }
    public void setNombreArticulo(String nombreArticulo) { this.nombreArticulo = nombreArticulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecio() {
        return precio;
    }

    public String getTemporada() {
        return Temporada;
    }

    public String getMarca() {
        return Marca;
    }

    public String getMaterial() {
        return Material;
    }

    
    @Override
    public String toString() {
        return nombreArticulo;
    }
}
