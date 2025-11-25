/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objetosnegocio.dominioPojo;

import java.io.Serializable;

/**
 *
 * @author emiim
 */
public class Talla implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private int idTalla;
    private String nombreTalla;
    private String descripcion;

    public Talla() {}

    public Talla(int idTalla, String nombreTalla, String descripcion) {
        this.idTalla = idTalla;
        this.nombreTalla = nombreTalla;
        this.descripcion = descripcion;
    }

    public Talla(String nombreTalla, String descripcion) {
        this.nombreTalla = nombreTalla;
        this.descripcion = descripcion;
    }

    public int getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(int idTalla) {
        this.idTalla = idTalla;
    }

    public String getNombreTalla() {
        return nombreTalla;
    }

    public void setNombreTalla(String nombreTalla) {
        this.nombreTalla = nombreTalla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return nombreTalla; 
    }   
}
