/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio.dominioPojo;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author santi
 */
/**
 * Representa una sugerencia realizada por un empleado dentro del sistema.
 * Contiene información como la descripción, estado y fecha de publicación.
 */
public class Sugerencia {

    /** Identificador único de la sugerencia (MongoDB). */
    private ObjectId id;

    /** Empleado que realizó la sugerencia. */
    private Empleado empleado;

    /** Texto descriptivo de la sugerencia. */
    private String descripcion;

    /** Estado de la sugerencia (por ejemplo: Pendiente, Aprobada, Rechazada). */
    private String estado;

    /** Fecha en la que la sugerencia fue registrada o publicada. */
    private Date fechaPublicacion;

    /**
     * Constructor completo para inicializar todos los atributos.
     *
     * @param id identificador único
     * @param empleado empleado que realizó la sugerencia
     * @param descripcion contenido de la sugerencia
     * @param estado estado actual de la sugerencia
     * @param fechaPublicacion fecha de publicación
     */
    public Sugerencia(ObjectId id, Empleado empleado, String descripcion, String estado, Date fechaPublicacion) {
        this.id = id;
        this.empleado = empleado;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     * Constructor vacío requerido para serialización/deserialización.
     */
    public Sugerencia() {}

    /**
     * Constructor para crear una sugerencia sin especificar ID.
     *
     * @param empleado empleado que creó la sugerencia
     * @param descripcion texto de la sugerencia
     * @param estado estado inicial de la sugerencia
     * @param fechaPublicacion fecha en que se registró
     */
    public Sugerencia(Empleado empleado, String descripcion, String estado, Date fechaPublicacion) {
        this.empleado = empleado;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     * Obtiene el identificador único de la sugerencia.
     *
     * @return id de la sugerencia
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único de la sugerencia.
     *
     * @param id nuevo identificador
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el empleado asociado a la sugerencia.
     *
     * @return empleado autor de la sugerencia
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     * Establece el empleado asociado a la sugerencia.
     *
     * @param empleado empleado autor
     */
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    /**
     * Obtiene la descripción de la sugerencia.
     *
     * @return texto descriptivo
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la sugerencia.
     *
     * @param descripcion nuevo texto descriptivo
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el estado actual de la sugerencia.
     *
     * @return estado de la sugerencia
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la sugerencia.
     *
     * @param estado nuevo estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la fecha de publicación.
     *
     * @return fecha de registro de la sugerencia
     */
    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * Establece la fecha de publicación.
     *
     * @param fechaPublicacion nueva fecha
     */
    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}
