/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objetosnegocio.dto;

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

    public RopaDTO(String id, String nombreArticulo, double precio, String descripcion, String Temporada, String Marca, String Material) {
        this.idRopa = id;
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

    public void setIdRopa(String id) {
        this.idRopa = id;
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
