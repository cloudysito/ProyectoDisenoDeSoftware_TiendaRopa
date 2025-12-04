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
 * DTO que representa la información asociada a una bonificación otorgada a un empleado.
 * Incluye el identificador de la bonificación, el empleado, los puntos acumulados
 * y la recompensa obtenida.
 */
public class BonificacionDTO {

    /** Identificador único de la bonificación. */
    private String idBonificacion;

    /** Empleado asociado a la bonificación. */
    private EmpleadoDTO nombreEmpleado;

    /** Cantidad total de puntos acumulados por el empleado. */
    private int puntosTotales;

    /** Recompensa asignada al empleado según sus puntos. */
    private RecompensaDTO nombreRecompensa;

    /**
     * Constructor vacío utilizado para procesos de serialización/deserialización.
     */
    public BonificacionDTO() {}

    /**
     * Constructor completo para inicializar todos los atributos de la bonificación.
     *
     * @param idBonificacion identificador único de la bonificación
     * @param nombreEmpleado empleado que recibe la bonificación
     * @param puntosTotales puntos acumulados del empleado
     * @param nombreRecompensa recompensa asignada
     */
    public BonificacionDTO(String idBonificacion, EmpleadoDTO nombreEmpleado, int puntosTotales, RecompensaDTO nombreRecompensa) {
        this.idBonificacion = idBonificacion;
        this.nombreEmpleado = nombreEmpleado;
        this.puntosTotales = puntosTotales;
        this.nombreRecompensa = nombreRecompensa;
    }

    /**
     * Constructor alterno sin idBonificacion, útil para crear nuevas bonificaciones.
     *
     * @param nombreEmpleado empleado que recibe la bonificación
     * @param puntosTotales puntos acumulados del empleado
     * @param nombreRecompensa recompensa asignada
     */
    public BonificacionDTO(EmpleadoDTO nombreEmpleado, int puntosTotales, RecompensaDTO nombreRecompensa){
        this.nombreEmpleado = nombreEmpleado;
        this.puntosTotales = puntosTotales;
        this.nombreRecompensa = nombreRecompensa;
    }

    /**
     * Obtiene el identificador de la bonificación.
     *
     * @return id de la bonificación
     */
    public String getIdBonificacion() {
        return idBonificacion;
    }

    /**
     * Establece el identificador de la bonificación.
     *
     * @param idBonificacion nuevo id de la bonificación
     */
    public void setIdBonificacion(String idBonificacion) {
        this.idBonificacion = idBonificacion;
    }

    /**
     * Obtiene el empleado asociado a la bonificación.
     *
     * @return empleado
     */
    public EmpleadoDTO getNombreEmpleado() {
        return nombreEmpleado;
    }

    /**
     * Establece el empleado asociado a la bonificación.
     *
     * @param nombreEmpleado nuevo empleado
     */
    public void setNombreEmpleado(EmpleadoDTO nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    /**
     * Obtiene el total de puntos del empleado.
     *
     * @return puntos acumulados
     */
    public int getPuntosTotales() {
        return puntosTotales;
    }

    /**
     * Establece el total de puntos del empleado.
     *
     * @param puntosTotales nuevos puntos acumulados
     */
    public void setPuntosTotales(int puntosTotales) {
        this.puntosTotales = puntosTotales;
    }

    /**
     * Obtiene la recompensa asignada al empleado.
     *
     * @return recompensa
     */
    public RecompensaDTO getNombreRecompensa() {
        return nombreRecompensa;
    }

    /**
     * Establece la recompensa asignada al empleado.
     *
     * @param nombreRecompensa nueva recompensa
     */
    public void setNombreRecompensa(RecompensaDTO nombreRecompensa) {
        this.nombreRecompensa = nombreRecompensa;
    }
}
