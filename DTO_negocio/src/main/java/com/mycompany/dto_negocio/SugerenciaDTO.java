/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

import java.util.Date;

/**
 *
 * @author santi
 */
/**
 * Representa una sugerencia realizada por un empleado,
 * incluyendo su descripción, fecha de publicación y estado.
 */
public class SugerenciaDTO {

    private String id;
    private EmpleadoDTO empleado;
    private String descripcion;
    private String estado;
    private Date fechaPublicacion;

    /**
     * Constructor completo que inicializa todos los atributos.
     *
     * @param id Identificador único de la sugerencia.
     * @param empleado Empleado que realizó la sugerencia.
     * @param descripcion Texto descriptivo de la sugerencia.
     * @param estado Estado actual de la sugerencia (por ejemplo: Pendiente, Aprobada, Rechazada).
     * @param fechaPublicacion Fecha en la que se registró la sugerencia.
     */
    public SugerenciaDTO(String id, EmpleadoDTO empleado, String descripcion, String estado, Date fechaPublicacion) {
        this.id = id;
        this.empleado = empleado;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     * Constructor vacío para inicialización por defecto.
     */
    public SugerenciaDTO() {
    }

    /**
     * Constructor que inicializa todos los atributos excepto el ID.
     *
     * @param empleado Empleado que realizó la sugerencia.
     * @param descripcion Texto descriptivo de la sugerencia.
     * @param estado Estado actual de la sugerencia.
     * @param fechaPublicacion Fecha en la que se registró la sugerencia.
     */
    public SugerenciaDTO(EmpleadoDTO empleado, String descripcion, String estado, Date fechaPublicacion) {
        this.empleado = empleado;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     * Obtiene el identificador de la sugerencia.
     *
     * @return ID de la sugerencia.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador de la sugerencia.
     *
     * @param id Nuevo ID de la sugerencia.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el empleado que realizó la sugerencia.
     *
     * @return EmpleadoDTO asociado a la sugerencia.
     */
    public EmpleadoDTO getEmpleadoDTO() {
        return empleado;
    }

    /**
     * Establece el empleado que realizó la sugerencia.
     *
     * @param empleado Nuevo empleado asociado a la sugerencia.
     */
    public void setEmpleadoDTO(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }

    /**
     * Obtiene la descripción de la sugerencia.
     *
     * @return Texto descriptivo de la sugerencia.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la sugerencia.
     *
     * @param descripcion Nueva descripción de la sugerencia.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el estado actual de la sugerencia.
     *
     * @return Estado de la sugerencia.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la sugerencia.
     *
     * @param estado Nuevo estado de la sugerencia.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la fecha en que se publicó la sugerencia.
     *
     * @return Fecha de publicación.
     */
    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * Establece la fecha de publicación de la sugerencia.
     *
     * @param fechaPublicacion Nueva fecha de publicación.
     */
    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}
