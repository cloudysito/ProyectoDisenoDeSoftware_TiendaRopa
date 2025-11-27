/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

/**
 *
 * @author garfi
 */
public class RopaDTO {
    private String idRopa;
    private String nombreArticulo;
    private double precio;
    private String descripcion;
    private String Temporada;
    private String Marca;
    private  String Material;
    
    public RopaDTO() {
        
    }

    public RopaDTO(String idRopa, String nombreArticulo, double precio, String descripcion, String Temporada, String Marca, String Material) {
        this.idRopa = idRopa;
        this.nombreArticulo = nombreArticulo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.Temporada = Temporada;
        this.Marca = Marca;
        this.Material = Material;
    }

    public RopaDTO(String nombreArticulo, double precio, String descripcion, String Temporada, String Marca, String Material) {
        this.nombreArticulo = nombreArticulo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.Temporada = Temporada;
        this.Marca = Marca;
        this.Material = Material;
    }

    
    
    public String getIdRopa() {
        return idRopa;
    }

    public void setIdRopa(String idRopa) {
        this.idRopa = idRopa;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTemporada() {
        return Temporada;
    }

    public void setTemporada(String Temporada) {
        this.Temporada = Temporada;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String Material) {
        this.Material = Material;
    }
    
    
}
