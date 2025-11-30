/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

/**
 *
 * @author riosr
 */
public class RecompenzaDTO {
    private String idRecompenza;
    private String nombreRecompenza;
    private int puntosNecesarios;
    
    public RecompenzaDTO() {}

    public RecompenzaDTO(String idRecompenza, String nombreRecompenza, int puntosNecesarios) {
        this.idRecompenza = idRecompenza;
        this.nombreRecompenza = nombreRecompenza;
        this.puntosNecesarios = puntosNecesarios;
    }
    
    public RecompenzaDTO(String nombreRecompenza, int puntosNecesarios){
        this.nombreRecompenza = nombreRecompenza;
        this.puntosNecesarios = puntosNecesarios;
    }

    public String getIdRecompenza() {
        return idRecompenza;
    }

    public void setId(String id) {
        this.idRecompenza = id;
    }

    public String getNombreRecompenza() {
        return nombreRecompenza;
    }

    public void setNombreRecompenza(String nombreRecompenza) {
        this.nombreRecompenza = nombreRecompenza;
    }

    public int getPuntosNecesarios() {
        return puntosNecesarios;
    }

    public void setPuntosNecesarios(int puntosNecesarios) {
        this.puntosNecesarios = puntosNecesarios;
    }
    
}
