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
 * Representa los puntos asignados a un artículo de ropa.
 */
public class PuntosDTO {

    private String idPuntos;
    private RopaDTO nombreArticulo;
    private int puntosIndividuales;

    /**
     * Constructor vacío.
     */
    public PuntosDTO() {}

    /**
     * Constructor que inicializa el artículo y los puntos asignados.
     *
     * @param nombreArticulo Artículo de ropa al que pertenecen los puntos.
     * @param puntosIndividuales Cantidad de puntos asignados al artículo.
     */
    public PuntosDTO(RopaDTO nombreArticulo, int puntosIndividuales){
        this.nombreArticulo = nombreArticulo;
        this.puntosIndividuales = puntosIndividuales;
    }

    /**
     * Constructor que inicializa todos los atributos.
     *
     * @param idPuntos Identificador único del registro de puntos.
     * @param nombreArticulo Artículo de ropa asociado.
     * @param puntosIndividuales Cantidad de puntos asignados al artículo.
     */
    public PuntosDTO(String idPuntos, RopaDTO nombreArticulo, int puntosIndividuales){
        this.idPuntos = idPuntos;
        this.nombreArticulo = nombreArticulo;
        this.puntosIndividuales = puntosIndividuales;
    }

    /**
     * Obtiene el identificador del registro de puntos.
     *
     * @return ID de los puntos.
     */
    public String getIdPuntos() {
        return idPuntos;
    }

    /**
     * Establece el identificador del registro de puntos.
     *
     * @param idPuntos Nuevo ID de los puntos.
     */
    public void setIdPuntos(String idPuntos) {
        this.idPuntos = idPuntos;
    }

    /**
     * Obtiene el artículo de ropa asociado.
     *
     * @return Artículo de ropa.
     */
    public RopaDTO getNombreArticulo() {
        return nombreArticulo;
    }

    /**
     * Establece el artículo de ropa asociado.
     *
     * @param nombreArticulo Nuevo artículo de ropa.
     */
    public void setNombreArticulo(RopaDTO nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    /**
     * Obtiene la cantidad de puntos individuales asignados al artículo.
     *
     * @return Puntos individuales.
     */
    public int getPuntosIndividuales() {
        return puntosIndividuales;
    }

    /**
     * Establece la cantidad de puntos individuales asignados al artículo.
     *
     * @param puntosIndividuales Nueva cantidad de puntos.
     */
    public void setPuntosIndividuales(int puntosIndividuales) {
        this.puntosIndividuales = puntosIndividuales;
    }

}
