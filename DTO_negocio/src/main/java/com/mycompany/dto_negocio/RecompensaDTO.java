/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

/**
 *
 * @author riosr
 */
public class RecompensaDTO {
    private String idRecompensa;
    private String nombreRecompensa;
    private int puntosNecesarios;
    
    public RecompensaDTO() {}

    public RecompensaDTO(String idRecompensa, String nombreRecompensa, int puntosNecesarios) {
        this.idRecompensa = idRecompensa;
        this.nombreRecompensa = nombreRecompensa;
        this.puntosNecesarios = puntosNecesarios;
    }
    
    public RecompensaDTO(String nombreRecompensa, int puntosNecesarios){
        this.nombreRecompensa = nombreRecompensa;
        this.puntosNecesarios = puntosNecesarios;
    }

    public String getIdRecompensa() {
        return idRecompensa;
    }

    public void setIdRecompensa(String idRecompensa) {
        this.idRecompensa = idRecompensa;
    }

    public String getNombreRecompensa() {
        return nombreRecompensa;
    }

    public void setNombreRecompensa(String nombreRecompensa) {
        this.nombreRecompensa = nombreRecompensa;
    }

    public int getPuntosNecesarios() {
        return puntosNecesarios;
    }

    public void setPuntosNecesarios(int puntosNecesarios) {
        this.puntosNecesarios = puntosNecesarios;
    }

}
