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
 * Representa la asignación de puntos a un artículo de ropa,
 * los cuales pueden utilizarse para programas de recompensas.
 */
public class Puntos {

    /** Identificador único del registro de puntos. */
    private ObjectId idPuntos;

    /** Artículo de ropa al que pertenecen los puntos. */
    private Ropa nombreArticulo;

    /** Cantidad de puntos asignados al artículo. */
    private int puntosIndividuales;

    /**
     * Constructor vacío requerido por frameworks de persistencia.
     */
    public Puntos() {}

    /**
     * Constructor para crear un registro de puntos sin especificar ID.
     *
     * @param nombreArticulo artículo de ropa asociado
     * @param puntosIndividuales puntos otorgados al artículo
     */
    public Puntos(Ropa nombreArticulo, int puntosIndividuales){
        this.nombreArticulo = nombreArticulo;
        this.puntosIndividuales = puntosIndividuales;
    }

    /**
     * Constructor para crear un registro de puntos completo.
     *
     * @param idPuntos identificador único de puntos
     * @param nombreArticulo artículo de ropa asociado
     * @param puntosIndividuales puntos otorgados al artículo
     */
    public Puntos(ObjectId idPuntos, Ropa nombreArticulo, int puntosIndividuales){
        this.idPuntos = idPuntos;
        this.nombreArticulo = nombreArticulo;
        this.puntosIndividuales = puntosIndividuales;
    }

    /**
     * Obtiene el ID del registro de puntos.
     *
     * @return id de puntos
     */
    public ObjectId getIdPuntos() {
        return idPuntos;
    }

    /**
     * Establece el ID del registro de puntos.
     *
     * @param idPuntos nuevo identificador
     */
    public void setIdPuntos(ObjectId idPuntos) {
        this.idPuntos = idPuntos;
    }

    /**
     * Obtiene el artículo de ropa asociado.
     *
     * @return artículo de ropa
     */
    public Ropa getNombreArticulo() {
        return nombreArticulo;
    }

    /**
     * Establece el artículo de ropa asociado.
     *
     * @param nombreArticulo nuevo artículo
     */
    public void setNombreArticulo(Ropa nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    /**
     * Obtiene los puntos asignados al artículo.
     *
     * @return puntos individuales
     */
    public int getPuntosIndividuales() {
        return puntosIndividuales;
    }

    /**
     * Establece los puntos asignados al artículo.
     *
     * @param puntosIndividuales nueva cantidad de puntos
     */
    public void setPuntosIndividuales(int puntosIndividuales) {
        this.puntosIndividuales = puntosIndividuales;
    }
}
