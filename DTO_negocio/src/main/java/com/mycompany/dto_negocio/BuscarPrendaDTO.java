/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

/**
 *
 * @author santi
 */
public class BuscarPrendaDTO {
    private String temporada;
    private String material;
    private String marca;
    private Double precio;
    private String nombreTalla;

    public BuscarPrendaDTO(String temporada, String material, String marca, Double precio, String nombreTalla) {
        this.temporada = temporada;
        this.material = material;
        this.marca = marca;
        this.precio = precio;
        this.nombreTalla = nombreTalla;
    }

    public BuscarPrendaDTO() {
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getNombreTalla() {
        return nombreTalla;
    }

    public void setNombreTalla(String nombreTalla) {
        this.nombreTalla = nombreTalla;
    }
    
    
}
