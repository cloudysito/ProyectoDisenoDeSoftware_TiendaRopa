/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objetosnegocio.dominio;

/**
 *
 * @author santi
 */
public class Talla {
    private int idTalla;
    private String nombreTalla;
    private String descripcion;

    public Talla() {}

    public Talla( String nombreTalla, String descripcion) {
        this.nombreTalla = nombreTalla;
        this.descripcion = descripcion;
    }

    public int getIdTalla() { return idTalla; }
    public void setIdTalla(int idTalla) { this.idTalla = idTalla; }

    public String getNombreTalla() { return nombreTalla; }
    public void setNombreTalla(String nombreTalla) { this.nombreTalla = nombreTalla; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    @Override
    public String toString() {
        return nombreTalla;
    }
}

