/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

/**
 *
 * @author garfi
 */
/**
 * Representa una talla con su identificador, nombre y descripción.
 */
public class TallaDTO {

    private String idTalla;
    private String nombreTalla;
    private String descripcion;

    /**
     * Constructor vacío para inicialización por defecto.
     */
    public TallaDTO() {
    }

    /**
     * Constructor completo que inicializa todos los atributos.
     *
     * @param idTalla Identificador único de la talla.
     * @param nombreTalla Nombre asignado a la talla.
     * @param descripcion Descripción general de la talla.
     */
    public TallaDTO(String idTalla, String nombreTalla, String descripcion) {
        this.idTalla = idTalla;
        this.nombreTalla = nombreTalla;
        this.descripcion = descripcion;
    }

    /**
     * Constructor que inicializa únicamente el nombre y la descripción.
     *
     * @param nombreTalla Nombre asignado a la talla.
     * @param descripcion Descripción general de la talla.
     */
    public TallaDTO(String nombreTalla, String descripcion) {
        this.nombreTalla = nombreTalla;
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el identificador de la talla.
     *
     * @return ID de la talla.
     */
    public String getIdTalla() {
        return idTalla;
    }

    /**
     * Establece el identificador de la talla.
     *
     * @param idTalla Nuevo ID de la talla.
     */
    public void setIdTalla(String idTalla) {
        this.idTalla = idTalla;
    }

    /**
     * Obtiene el nombre de la talla.
     *
     * @return Nombre de la talla.
     */
    public String getNombreTalla() {
        return nombreTalla;
    }

    /**
     * Establece el nombre de la talla.
     *
     * @param nombreTalla Nuevo nombre para la talla.
     */
    public void setNombreTalla(String nombreTalla) {
        this.nombreTalla = nombreTalla;
    }

    /**
     * Obtiene la descripción de la talla.
     *
     * @return Descripción de la talla.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la talla.
     *
     * @param descripcion Nueva descripción para la talla.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
