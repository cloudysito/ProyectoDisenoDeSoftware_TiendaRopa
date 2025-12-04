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
 * Representa un tema de capacitación con su identificador y nombre.
 */
public class TemaCapacitacionDTO {
    
    private String idTemaCapacitacion;
    private String temaCapacitacion;

    /**
     * Constructor vacío para inicialización por defecto.
     */
    public TemaCapacitacionDTO() {}

    /**
     * Constructor completo que inicializa todos los atributos.
     *
     * @param idTemaCapacitacion Identificador único del tema de capacitación.
     * @param temaCapacitacion Nombre o descripción del tema de capacitación.
     */
    public TemaCapacitacionDTO(String idTemaCapacitacion, String temaCapacitacion){
        this.idTemaCapacitacion = idTemaCapacitacion;
        this.temaCapacitacion = temaCapacitacion;
    }

    /**
     * Constructor que inicializa solo el nombre del tema de capacitación.
     *
     * @param temaCapacitacion Nombre o descripción del tema de capacitación.
     */
    public TemaCapacitacionDTO(String temaCapacitacion){
        this.temaCapacitacion = temaCapacitacion;
    }

    /**
     * Obtiene el identificador del tema de capacitación.
     *
     * @return ID del tema de capacitación.
     */
    public String getIdTemaCapacitacion() {
        return idTemaCapacitacion;
    }

    /**
     * Establece el identificador del tema de capacitación.
     *
     * @param idTemaCapacitacion Nuevo ID para el tema de capacitación.
     */
    public void setIdTemaCapacitacion(String idTemaCapacitacion) {
        this.idTemaCapacitacion = idTemaCapacitacion;
    }

    /**
     * Obtiene el nombre o descripción del tema de capacitación.
     *
     * @return Tema de capacitación.
     */
    public String getTemaCapacitacion() {
        return temaCapacitacion;
    }

    /**
     * Establece el nombre o descripción del tema de capacitación.
     *
     * @param temaCapacitacion Nuevo nombre del tema de capacitación.
     */
    public void setTemaCapacitacion(String temaCapacitacion) {
        this.temaCapacitacion = temaCapacitacion;
    }
}

