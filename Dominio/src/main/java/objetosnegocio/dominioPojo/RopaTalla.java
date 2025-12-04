/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio.dominioPojo;

import org.bson.types.ObjectId;

/**
 * Representa la relación entre una prenda de ropa y una talla específica,
 * incluyendo su código identificador y la cantidad disponible.
 */
public class RopaTalla {

    /** Identificador único del documento en MongoDB. */
    private ObjectId id;

    /** Objeto que representa la prenda de ropa asociada. */
    private Ropa ropa;

    /** Objeto que representa la talla asociada a la prenda. */
    private Talla talla;

    /** Código único que identifica la combinación de ropa y talla. */
    private String codigo;

    /** Cantidad disponible de la prenda en la talla indicada. */
    private int cantidad;

    /**
     * Constructor vacío requerido por algunos frameworks de persistencia.
     */
    public RopaTalla() {}

    /**
     * Crea una relación entre una prenda y una talla sin especificar el ID.
     *
     * @param ropa la prenda de ropa asociada
     * @param talla la talla de la prenda
     * @param codigo el código identificador
     * @param cantidad la cantidad disponible
     */
    public RopaTalla(Ropa ropa, Talla talla, String codigo, int cantidad) {
        this.ropa = ropa;
        this.talla = talla;
        this.codigo = codigo;
        this.cantidad = cantidad;
    }

    /**
     * Crea una relación completa entre una prenda y una talla, incluyendo el ID.
     *
     * @param id identificador único
     * @param ropa la prenda de ropa asociada
     * @param talla la talla de la prenda
     * @param codigo el código identificador
     * @param cantidad la cantidad disponible
     */
    public RopaTalla(ObjectId id, Ropa ropa, Talla talla, String codigo, int cantidad) {
        this.id = id;
        this.ropa = ropa;
        this.talla = talla;
        this.codigo = codigo;
        this.cantidad = cantidad;
    }

    /**
     * Obtiene la prenda de ropa asociada.
     *
     * @return la prenda de ropa
     */
    public Ropa getRopa() { return ropa; }

    /**
     * Establece la prenda de ropa asociada.
     *
     * @param ropa la prenda de ropa
     */
    public void setRopa(Ropa ropa) { this.ropa = ropa; }

    /**
     * Obtiene el identificador único.
     *
     * @return el id
     */
    public ObjectId getId() { return id; }

    /**
     * Establece el identificador único.
     *
     * @param id el id
     */
    public void setId(ObjectId id) { this.id = id; }

    /**
     * Obtiene la talla asociada.
     *
     * @return la talla
     */
    public Talla getTalla() { return talla; }

    /**
     * Establece la talla asociada.
     *
     * @param talla la talla
     */
    public void setTalla(Talla talla) { this.talla = talla; }

    /**
     * Obtiene el código identificador.
     *
     * @return el código
     */
    public String getCodigo() { return codigo; }

    /**
     * Establece el código identificador.
     *
     * @param codigo el código
     */
    public void setCodigo(String codigo) { this.codigo = codigo; }

    /**
     * Obtiene la cantidad disponible.
     *
     * @return la cantidad
     */
    public int getCantidad() { return cantidad; }

    /**
     * Establece la cantidad disponible.
     *
     * @param cantidad la cantidad
     */
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    /**
     * Devuelve una representación en texto de la relación ropa-talla.
     * Incluye el nombre del artículo y el nombre de la talla.
     *
     * @return una cadena representativa de la relación
     */
    @Override
    public String toString() {
        return (ropa != null ? ropa.getNombreArticulo() : "?") + " - " +
               (talla != null ? talla.getNombreTalla() : "?");
    }
}
