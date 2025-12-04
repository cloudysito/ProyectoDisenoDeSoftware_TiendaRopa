/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

/**
 *
 * @author riosr
 */
/**
 * Representa una recompensa que puede ser obtenida mediante puntos acumulados.
 */
public class RecompensaDTO {

    private String idRecompensa;
    private String nombreRecompensa;
    private int puntosNecesarios;

    /**
     * Constructor vacío.
     */
    public RecompensaDTO() {}

    /**
     * Constructor que inicializa todos los atributos.
     *
     * @param idRecompensa Identificador único de la recompensa.
     * @param nombreRecompensa Nombre de la recompensa.
     * @param puntosNecesarios Puntos requeridos para obtener la recompensa.
     */
    public RecompensaDTO(String idRecompensa, String nombreRecompensa, int puntosNecesarios) {
        this.idRecompensa = idRecompensa;
        this.nombreRecompensa = nombreRecompensa;
        this.puntosNecesarios = puntosNecesarios;
    }

    /**
     * Constructor que inicializa la recompensa sin ID.
     *
     * @param nombreRecompensa Nombre de la recompensa.
     * @param puntosNecesarios Puntos requeridos para obtener la recompensa.
     */
    public RecompensaDTO(String nombreRecompensa, int puntosNecesarios){
        this.nombreRecompensa = nombreRecompensa;
        this.puntosNecesarios = puntosNecesarios;
    }

    /**
     * Obtiene el identificador de la recompensa.
     *
     * @return ID de la recompensa.
     */
    public String getIdRecompensa() {
        return idRecompensa;
    }

    /**
     * Establece el identificador de la recompensa.
     *
     * @param idRecompensa Nuevo ID de la recompensa.
     */
    public void setIdRecompensa(String idRecompensa) {
        this.idRecompensa = idRecompensa;
    }

    /**
     * Obtiene el nombre de la recompensa.
     *
     * @return Nombre de la recompensa.
     */
    public String getNombreRecompensa() {
        return nombreRecompensa;
    }

    /**
     * Establece el nombre de la recompensa.
     *
     * @param nombreRecompensa Nuevo nombre de la recompensa.
     */
    public void setNombreRecompensa(String nombreRecompensa) {
        this.nombreRecompensa = nombreRecompensa;
    }

    /**
     * Obtiene los puntos necesarios para obtener la recompensa.
     *
     * @return Puntos requeridos.
     */
    public int getPuntosNecesarios() {
        return puntosNecesarios;
    }

    /**
     * Establece los puntos necesarios para obtener la recompensa.
     *
     * @param puntosNecesarios Nuevos puntos requeridos.
     */
    public void setPuntosNecesarios(int puntosNecesarios) {
        this.puntosNecesarios = puntosNecesarios;
    }

}
