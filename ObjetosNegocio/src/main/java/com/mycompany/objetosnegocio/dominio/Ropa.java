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
    private String descripcion;

    public Ropa() {}

    public Ropa(int idRopa, String nombreArticulo, String descripcion) {
        this.idRopa = idRopa;
        this.nombreArticulo = nombreArticulo;
        this.descripcion = descripcion;
    }

    public int getIdRopa() { return idRopa; }
    public void setIdRopa(int idRopa) { this.idRopa = idRopa; }

    public String getNombreArticulo() { return nombreArticulo; }
    public void setNombreArticulo(String nombreArticulo) { this.nombreArticulo = nombreArticulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    @Override
    public String toString() {
        return nombreArticulo;
    }
}
