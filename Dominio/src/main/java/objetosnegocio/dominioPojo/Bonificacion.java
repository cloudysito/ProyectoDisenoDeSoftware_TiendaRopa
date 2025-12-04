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
 * Representa una bonificación asignada a un empleado, incluyendo sus puntos totales
 * y la recompensa obtenida.
 */
public class Bonificacion {

    /** Identificador único de la bonificación. */
    private ObjectId idBonificacion;

    /** Empleado al que pertenece la bonificación. */
    private Empleado nombreEmpleado;

    /** Total de puntos acumulados por el empleado. */
    private int puntosTotales;

    /** Recompensa asignada en función de los puntos obtenidos. */
    private Recompensa nombreRecompensa;
    
    /**
     * Constructor vacío para permitir la creación de objetos sin inicialización inmediata.
     */
    public Bonificacion() {}
    
    /**
     * Crea una bonificación sin especificar un ID.
     *
     * @param nombreEmpleado Empleado que recibe la bonificación.
     * @param puntosTotales Cantidad total de puntos acumulados.
     * @param nombreRecompensa Recompensa otorgada.
     */
    public Bonificacion(Empleado nombreEmpleado, int puntosTotales, Recompensa nombreRecompensa){
        this.nombreEmpleado = nombreEmpleado;
        this.puntosTotales = puntosTotales;
        this.nombreRecompensa = nombreRecompensa;
    }
    
    /**
     * Crea una bonificación especificando todos sus atributos.
     *
     * @param id Identificador único de la bonificación.
     * @param nombreEmpleado Empleado que recibe la bonificación.
     * @param puntosTotales Cantidad total de puntos acumulados.
     * @param nombreRecompensa Recompensa otorgada.
     */
    public Bonificacion(ObjectId id, Empleado nombreEmpleado, int puntosTotales, Recompensa nombreRecompensa){
        this.idBonificacion = idBonificacion;
        this.nombreEmpleado = nombreEmpleado;
        this.puntosTotales = puntosTotales;
        this.nombreRecompensa = nombreRecompensa;
    }

    /**
     * Obtiene el identificador de la bonificación.
     *
     * @return ID de la bonificación.
     */
    public ObjectId getIdBonificacion() {
        return idBonificacion;
    }

    /**
     * Establece el identificador de la bonificación.
     *
     * @param idBonificacion Nuevo identificador.
     */
    public void setIdBonificacion(ObjectId idBonificacion) {
        this.idBonificacion = idBonificacion;
    }

    /**
     * Obtiene el empleado asociado a la bonificación.
     *
     * @return Empleado de la bonificación.
     */
    public Empleado getNombreEmpleado() {
        return nombreEmpleado;
    }

    /**
     * Asigna un empleado a la bonificación.
     *
     * @param nombreEmpleado Empleado que recibirá la bonificación.
     */
    public void setNombreEmpleado(Empleado nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    /**
     * Obtiene el total de puntos acumulados por el empleado.
     *
     * @return Puntos totales.
     */
    public int getPuntosTotales() {
        return puntosTotales;
    }

    /**
     * Establece el total de puntos acumulados.
     *
     * @param puntosTotales Nuevo total de puntos.
     */
    public void setPuntosTotales(int puntosTotales) {
        this.puntosTotales = puntosTotales;
    }

    /**
     * Obtiene la recompensa asignada.
     *
     * @return Recompensa de la bonificación.
     */
    public Recompensa getNombreRecompensa() {
        return nombreRecompensa;
    }

    /**
     * Asigna una recompensa a la bonificación.
     *
     * @param nombreRecompensa Nueva recompensa.
     */
    public void setNombreRecompensa(Recompensa nombreRecompensa) {
        this.nombreRecompensa = nombreRecompensa;
    }
}
