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
 * Representa una recompensa disponible para los empleados,
 * la cual requiere una cierta cantidad de puntos para ser obtenida.
 */
public class Recompensa {

    /** Identificador único de la recompensa en la base de datos. */
    private ObjectId idRecompensa;

    /** Nombre de la recompensa. */
    private String nombreRecompensa;

    /** Cantidad de puntos necesarios para canjear la recompensa. */
    private int puntosNecesarios;

    /**
     * Constructor vacío requerido por frameworks de persistencia.
     */
    public Recompensa() {}

    /**
     * Constructor para crear una recompensa sin especificar el ID.
     *
     * @param nombreRecompenza nombre de la recompensa
     * @param puntosNecesarios puntos necesarios para obtenerla
     */
    public Recompensa(String nombreRecompenza, int puntosNecesarios){
        this.nombreRecompensa = nombreRecompenza;
        this.puntosNecesarios = puntosNecesarios;
    }

    /**
     * Constructor para crear una recompensa con todos sus atributos.
     *
     * @param idRecompensa identificador único
     * @param nombreRecompensa nombre de la recompensa
     * @param puntosNecesarios puntos necesarios para obtenerla
     */
    public Recompensa(ObjectId idRecompensa, String nombreRecompensa, int puntosNecesarios){
        this.idRecompensa = idRecompensa;
        this.nombreRecompensa = nombreRecompensa;
        this.puntosNecesarios = puntosNecesarios;
    }

    /**
     * Obtiene el ID de la recompensa.
     *
     * @return id de la recompensa
     */
    public ObjectId getIdRecompensa() {
        return idRecompensa;
    }

    /**
     * Establece el ID de la recompensa.
     *
     * @param idRecompensa el nuevo ID
     */
    public void setIdRecompensa(ObjectId idRecompensa) {
        this.idRecompensa = idRecompensa;
    }

    /**
     * Obtiene el nombre de la recompensa.
     *
     * @return nombre de la recompensa
     */
    public String getNombreRecompensa() {
        return nombreRecompensa;
    }

    /**
     * Establece el nombre de la recompensa.
     *
     * @param nombreRecompensa nuevo nombre
     */
    public void setNombreRecompensa(String nombreRecompensa) {
        this.nombreRecompensa = nombreRecompensa;
    }

    /**
     * Obtiene los puntos necesarios para obtener la recompensa.
     *
     * @return puntos requeridos
     */
    public int getPuntosNecesarios() {
        return puntosNecesarios;
    }

    /**
     * Establece los puntos necesarios para obtener la recompensa.
     *
     * @param puntosNecesarios puntos requeridos
     */
    public void setPuntosNecesarios(int puntosNecesarios) {
        this.puntosNecesarios = puntosNecesarios;
    }
}
