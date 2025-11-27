/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

/**
 *
 * @author garfi
 */
public class TallaDTO {
    private String idTalla;
    private String nombreTalla;
    private String descripcion;

    public TallaDTO() {
    }

    public TallaDTO(String idTalla, String nombreTalla, String descripcion) {
        this.idTalla = idTalla;
        this.nombreTalla = nombreTalla;
        this.descripcion = descripcion;
    }

    public TallaDTO(String nombreTalla, String descripcion) {
        this.nombreTalla = nombreTalla;
        this.descripcion = descripcion;
    }

    
    
    public String getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(String idTalla) {
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
    
    
}
