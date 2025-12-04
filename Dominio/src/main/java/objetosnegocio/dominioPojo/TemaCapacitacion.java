/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio.dominioPojo;

import org.bson.types.ObjectId;

/**
 *
 * @author riosr
 */
/**
 * Representa un tema disponible para una capacitación dentro del sistema.
 * Incluye un identificador único y el nombre del tema.
 */
public class TemaCapacitacion {

    /** Identificador único del tema de capacitación (MongoDB). */
    private ObjectId idTemaCapacitacion;

    /** Nombre o título del tema de capacitación. */
    private String temaCapacitacion;

    /**
     * Constructor vacío requerido para serialización y deserialización.
     */
    public TemaCapacitacion() {}

    /**
     * Constructor que inicializa el tema de capacitación con su nombre.
     *
     * @param temaCapacitacion nombre del tema de capacitación
     */
    public TemaCapacitacion(String temaCapacitacion){
        this.temaCapacitacion = temaCapacitacion;
    }

    /**
     * Constructor completo que inicializa el identificador y el nombre del tema.
     *
     * @param idTemaCapacitacion identificador único del tema
     * @param temaCapacitacion nombre del tema de capacitación
     */
    public TemaCapacitacion(ObjectId idTemaCapacitacion, String temaCapacitacion) {
        this.idTemaCapacitacion = idTemaCapacitacion;
        this.temaCapacitacion = temaCapacitacion;
    }

    /**
     * Obtiene el identificador del tema de capacitación.
     *
     * @return id del tema
     */
    public ObjectId getIdTemaCapacitacion() {
        return idTemaCapacitacion;
    }

    /**
     * Establece el identificador del tema de capacitación.
     *
     * @param idTemaCapacitacion nuevo identificador
     */
    public void setIdTemaCapacitacion(ObjectId idTemaCapacitacion) {
        this.idTemaCapacitacion = idTemaCapacitacion;
    }

    /**
     * Obtiene el nombre del tema de capacitación.
     *
     * @return nombre del tema
     */
    public String getTemaCapacitacion() {
        return temaCapacitacion;
    }

    /**
     * Establece el nombre del tema de capacitación.
     *
     * @param temaCapacitacion nuevo nombre del tema
     */
    public void setTemaCapacitacion(String temaCapacitacion) {
        this.temaCapacitacion = temaCapacitacion;
    }
}

