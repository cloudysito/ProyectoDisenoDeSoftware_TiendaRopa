/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio.dominioPojo;

import org.bson.types.ObjectId;

/**
 * Representa una prenda de ropa con sus datos principales como nombre, descripción,
 * temporada, marca, material, imagen y precio.
 */
public class Ropa {

    /** Identificador único del documento en MongoDB. */
    private ObjectId id;

    /** Nombre del artículo de ropa. */
    private String nombreArticulo;

    /** URL de la imagen asociada a la prenda. */
    private String urlImagen;

    /** Precio de la prenda. */
    private double precio;

    /** Descripción del artículo. */
    private String descripcion;

    /** Temporada a la cual pertenece la prenda. */
    private String temporada;

    /** Marca del artículo. */
    private String marca;

    /** Material del que está fabricada la prenda. */
    private String material;

    /**
     * Constructor vacío requerido por frameworks de persistencia.
     */
    public Ropa() {}

    /**
     * Crea una prenda de ropa sin especificar el ID.
     *
     * @param nombreArticulo nombre del artículo
     * @param descripcion descripción del artículo
     * @param temporada temporada de la prenda
     * @param marca marca del artículo
     * @param material material de fabricación
     * @param precio precio del artículo
     */
    public Ropa(String nombreArticulo, String descripcion, String temporada, String marca, String material, double precio) {
        this.nombreArticulo = nombreArticulo;
        this.descripcion = descripcion;
        this.temporada = temporada;
        this.marca = marca;
        this.material = material;
        this.precio = precio;
    }

    /**
     * Crea una prenda de ropa especificando su ID.
     *
     * @param id identificador único
     * @param nombreArticulo nombre del artículo
     * @param descripcion descripción del artículo
     * @param temporada temporada de la prenda
     * @param marca marca del artículo
     * @param material material de fabricación
     * @param precio precio del artículo
     */
    public Ropa(ObjectId id, String nombreArticulo, String descripcion, String temporada, String marca, String material, double precio) {
        this.id = id;
        this.nombreArticulo = nombreArticulo;
        this.descripcion = descripcion;
        this.temporada = temporada;
        this.marca = marca;
        this.material = material;
        this.precio = precio;
    }

    /**
     * Obtiene la URL de la imagen asociada.
     *
     * @return la URL de la imagen
     */
    public String getUrlImagen() {
        return urlImagen;
    }

    /**
     * Establece la URL de la imagen asociada.
     *
     * @param urlImagen la URL de la imagen
     */
    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

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
     * Obtiene el nombre del artículo.
     *
     * @return el nombre del artículo
     */
    public String getNombreArticulo() { return nombreArticulo; }

    /**
     * Establece el nombre del artículo.
     *
     * @param nombreArticulo el nombre del artículo
     */
    public void setNombreArticulo(String nombreArticulo) { this.nombreArticulo = nombreArticulo; }

    /**
     * Obtiene el precio del artículo.
     *
     * @return el precio
     */
    public double getPrecio() { return precio; }

    /**
     * Establece el precio del artículo.
     *
     * @param precio el precio
     */
    public void setPrecio(double precio) { this.precio = precio; }

    /**
     * Obtiene la descripción del artículo.
     *
     * @return la descripción
     */
    public String getDescripcion() { return descripcion; }

    /**
     * Establece la descripción del artículo.
     *
     * @param descripcion la descripción
     */
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    /**
     * Obtiene la temporada de la prenda.
     *
     * @return la temporada
     */
    public String getTemporada() { return temporada; }

    /**
     * Establece la temporada de la prenda.
     *
     * @param temporada la temporada
     */
    public void setTemporada(String temporada) { this.temporada = temporada; }

    /**
     * Obtiene la marca de la prenda.
     *
     * @return la marca
     */
    public String getMarca() { return marca; }

    /**
     * Establece la marca de la prenda.
     *
     * @param marca la marca
     */
    public void setMarca(String marca) { this.marca = marca; }

    /**
     * Obtiene el material de la prenda.
     *
     * @return el material
     */
    public String getMaterial() { return material; }

    /**
     * Establece el material de la prenda.
     *
     * @param material el material
     */
    public void setMaterial(String material) { this.material = material; }

    /**
     * Devuelve el nombre del artículo como representación en texto.
     *
     * @return el nombre del artículo
     */
    @Override
    public String toString() { 
        return nombreArticulo; 
    }
}
