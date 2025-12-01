/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

/**
 *
 * @author riosr
 */
public class PuntosDTO {
    private String idPuntos;
    private RopaDTO nombreArticulo;
    private int puntosIndividuales;
    
    public PuntosDTO() {}
    
    public PuntosDTO(RopaDTO nombreArticulo, int puntosIndividuales){
        this.nombreArticulo = nombreArticulo;
        this.puntosIndividuales = puntosIndividuales;
    }
    
    public PuntosDTO(String idPuntos, RopaDTO nombreArticulo, int puntosIndividuales){
        this.idPuntos = idPuntos;
        this.nombreArticulo = nombreArticulo;
        this.puntosIndividuales = puntosIndividuales;
    }

    public String getIdPuntos() {
        return idPuntos;
    }

    public void setIdPuntos(String idPuntos) {
        this.idPuntos = idPuntos;
    }

    public RopaDTO getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(RopaDTO nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public int getPuntosIndividuales() {
        return puntosIndividuales;
    }

    public void setPuntosIndividuales(int puntosIndividuales) {
        this.puntosIndividuales = puntosIndividuales;
    }

}
