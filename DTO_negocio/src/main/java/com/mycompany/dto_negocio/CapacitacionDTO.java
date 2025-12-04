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
 * Representa una capacitación asignada a un empleado, incluyendo el tema,
 * el estado y el identificador de la capacitación.
 */
public class CapacitacionDTO {

    private String idCapacitacion;
    private EmpleadoDTO nombreEmpleado;
    private TemaCapacitacionDTO temaCapacitacion;
    private String estado;

    /**
     * Constructor vacío para CapacitacionDTO.
     */
    public CapacitacionDTO() {}

    /**
     * Constructor con todos los atributos de la capacitación.
     *
     * @param idCapacitacion identificador único de la capacitación
     * @param nombreEmpleado empleado al que se asigna la capacitación
     * @param temaCapacitacion tema o contenido de la capacitación
     * @param estado estado actual de la capacitación (ej. Pendiente, Aprobada)
     */
    public CapacitacionDTO(String idCapacitacion, EmpleadoDTO nombreEmpleado, TemaCapacitacionDTO temaCapacitacion, String estado){
        this.idCapacitacion = idCapacitacion;
        this.nombreEmpleado = nombreEmpleado;
        this.temaCapacitacion = temaCapacitacion;
        this.estado = estado;
    }

    /**
     * Constructor sin ID de capacitación.
     *
     * @param nombreEmpleado empleado al que se asigna la capacitación
     * @param temaCapacitacion tema o contenido de la capacitación
     * @param estado estado actual de la capacitación
     */
    public CapacitacionDTO(EmpleadoDTO nombreEmpleado, TemaCapacitacionDTO temaCapacitacion, String estado){
        this.nombreEmpleado = nombreEmpleado;
        this.temaCapacitacion = temaCapacitacion;
        this.estado = estado;
    }

    /**
     * Obtiene el identificador de la capacitación.
     *
     * @return id de la capacitación
     */
    public String getIdCapacitacion() {
        return idCapacitacion;
    }

    /**
     * Establece el identificador de la capacitación.
     *
     * @param idCapacitacion nuevo ID
     */
    public void setIdCapacitacion(String idCapacitacion) {
        this.idCapacitacion = idCapacitacion;
    }

    /**
     * Obtiene el empleado asignado a la capacitación.
     *
     * @return empleado asignado
     */
    public EmpleadoDTO getNombreEmpleado() {
        return nombreEmpleado;
    }

    /**
     * Establece el empleado asignado a la capacitación.
     *
     * @param nombreEmpleado empleado
     */
    public void setNombreEmpleado(EmpleadoDTO nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    /**
     * Obtiene el tema de la capacitación.
     *
     * @return tema de la capacitación
     */
    public TemaCapacitacionDTO getTemaCapacitacion() {
        return temaCapacitacion;
    }

    /**
     * Establece el tema de la capacitación.
     *
     * @param temaCapacitacion nuevo tema
     */
    public void setTemaCapacitacion(TemaCapacitacionDTO temaCapacitacion) {
        this.temaCapacitacion = temaCapacitacion;
    }

    /**
     * Obtiene el estado actual de la capacitación.
     *
     * @return estado de la capacitación
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la capacitación.
     *
     * @param estado nuevo estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
