/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio.dominioPojo;

import java.io.Serializable;
import org.bson.types.ObjectId;

/**
 * Representa una talla de prenda dentro del sistema. Incluye un identificador,
 * el nombre de la talla y una descripción adicional.
 */
public class Talla implements Serializable {

    /** Identificador único de la talla (MongoDB). */
    private ObjectId id;

    /** Nombre de la talla, por ejemplo: S, M, L, XL, etc. */
    private String nombreTalla;

    /** Descripción adicional sobre la talla. */
    private String descripcion;

    /**
     * Constructor vacío requerido para serialización y deserialización.
     */
    public Talla() {}

    /**
     * Constructor que inicializa la talla con un nombre y una descripción.
     *
     * @param nombreTalla nombre de la talla
     * @param descripcion descripción adicional de la talla
     */
    public Talla(String nombreTalla, String descripcion) {
        this.nombreTalla = nombreTalla;
        this.descripcion = descripcion;
    }

    /**
     * Constructor completo para inicializar todos los atributos.
     *
     * @param id identificador único de la talla
     * @param nombreTalla nombre de la talla
     * @param descripcion descripción de la talla
     */
    public Talla(ObjectId id, String nombreTalla, String descripcion) {
        this.id = id;
        this.nombreTalla = nombreTalla;
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el identificador único de la talla.
     *
     * @return id de la talla
     */
    public ObjectId getId() { return id; }

    /**
     * Establece el identificador único de la talla.
     *
     * @param id nuevo identificador
     */
    public void setId(ObjectId id) { this.id = id; }

    /**
     * Obtiene el nombre de la talla.
     *
     * @return nombre de la talla
     */
    public String getNombreTalla() { return nombreTalla; }

    /**
     * Establece el nombre de la talla.
     *
     * @param nombreTalla nuevo nombre de la talla
     */
    public void setNombreTalla(String nombreTalla) { this.nombreTalla = nombreTalla; }

    /**
     * Obtiene la descripción de la talla.
     *
     * @return descripción de la talla
     */
    public String getDescripcion() { return descripcion; }

    /**
     * Establece la descripción de la talla.
     *
     * @param descripcion nueva descripción
     */
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    /**
     * Devuelve una representación en texto de la talla.
     *
     * @return nombre de la talla
     */
    @Override
    public String toString() { return nombreTalla; }
}
