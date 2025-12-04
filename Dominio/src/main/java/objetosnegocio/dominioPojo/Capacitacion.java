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
 * Representa una capacitación asignada a un empleado, incluyendo el tema
 * impartido y el estado actual del proceso de capacitación.
 */
public class Capacitacion {

    /** Identificador único de la capacitación. */
    private ObjectId idCapacitacion;

    /** Empleado asociado a la capacitación. */
    private Empleado nombreEmpleado;

    /** Tema o contenido de la capacitación. */
    private TemaCapacitacion temaCapacitacion;

    /** Estado actual de la capacitación (ej. "Pendiente", "Completada"). */
    private String estado;
    
    /**
     * Constructor vacío.
     */
    public Capacitacion() {}
    
    /**
     * Constructor que inicializa los datos principales de la capacitación.
     *
     * @param nombreEmpleado empleado que recibe la capacitación
     * @param temaCapacitacion tema de la capacitación
     * @param estado estado actual de la capacitación
     */
    public Capacitacion(Empleado nombreEmpleado, TemaCapacitacion temaCapacitacion, String estado){
        this.nombreEmpleado = nombreEmpleado;
        this.temaCapacitacion = temaCapacitacion;
        this.estado = estado;
    }

    /**
     * Constructor que inicializa todos los atributos, incluyendo el ID.
     *
     * @param idCapacitacion identificador único de la capacitación
     * @param nombreEmpleado empleado que recibe la capacitación
     * @param temaCapacitacion tema impartido en la capacitación
     * @param estado estado actual del proceso de capacitación
     */
    public Capacitacion(ObjectId idCapacitacion, Empleado nombreEmpleado, TemaCapacitacion temaCapacitacion, String estado) {
        this.idCapacitacion = idCapacitacion;
        this.nombreEmpleado = nombreEmpleado;
        this.temaCapacitacion = temaCapacitacion;
        this.estado = estado;
    }

    /**
     * Obtiene el identificador único de la capacitación.
     *
     * @return id de la capacitación
     */
    public ObjectId getIdCapacitacion() {
        return idCapacitacion;
    }

    /**
     * Establece el identificador único de la capacitación.
     *
     * @param idCapacitacion nuevo identificador de la capacitación
     */
    public void setIdCapacitacion(ObjectId idCapacitacion) {
        this.idCapacitacion = idCapacitacion;
    }

    /**
     * Obtiene el empleado asociado a la capacitación.
     *
     * @return empleado asignado
     */
    public Empleado getNombreEmpleado() {
        return nombreEmpleado;
    }

    /**
     * Establece el empleado asociado a la capacitación.
     *
     * @param nombreEmpleado nuevo empleado asignado
     */
    public void setNombreEmpleado(Empleado nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    /**
     * Obtiene el tema de la capacitación.
     *
     * @return tema impartido
     */
    public TemaCapacitacion getTemaCapacitacion() {
        return temaCapacitacion;
    }

    /**
     * Establece el tema de la capacitación.
     *
     * @param temaCapacitacion nuevo tema impartido
     */
    public void setTemaCapacitacion(TemaCapacitacion temaCapacitacion) {
        this.temaCapacitacion = temaCapacitacion;
    }

    /**
     * Obtiene el estado actual de la capacitación.
     *
     * @return estado actual
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual de la capacitación.
     *
     * @param estado nuevo estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
