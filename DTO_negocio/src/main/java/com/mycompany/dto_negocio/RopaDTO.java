/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

/**
 *
 * @author garfi
 */
/**
 * DTO que representa un artículo de ropa.
 */
public class RopaDTO {

    private String idRopa;
    private String nombreArticulo;
    private String urlImagen;
    private double precio;
    private String descripcion;
    private String Temporada;
    private String Marca;
    private String Material;

    /**
     * Constructor vacío.
     */
    public RopaDTO() {
    }

    /**
     * Constructor con todos los atributos.
     *
     * @param idRopa Identificador de la prenda.
     * @param nombreArticulo Nombre del artículo.
     * @param precio Precio de la prenda.
     * @param descripcion Descripción general.
     * @param Temporada Temporada de uso.
     * @param Marca Marca de la prenda.
     * @param Material Material principal.
     */
    public RopaDTO(String idRopa, String nombreArticulo, double precio, String descripcion, String Temporada, String Marca, String Material) {
        this.idRopa = idRopa;
        this.nombreArticulo = nombreArticulo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.Temporada = Temporada;
        this.Marca = Marca;
        this.Material = Material;
    }

    /**
     * Constructor sin ID.
     *
     * @param nombreArticulo Nombre del artículo.
     * @param precio Precio de la prenda.
     * @param descripcion Descripción general.
     * @param Temporada Temporada de uso.
     * @param Marca Marca de la prenda.
     * @param Material Material principal.
     */
    public RopaDTO(String nombreArticulo, double precio, String descripcion, String Temporada, String Marca, String Material) {
        this.nombreArticulo = nombreArticulo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.Temporada = Temporada;
        this.Marca = Marca;
        this.Material = Material;
    }

    /** @return ID de la ropa. */
    public String getIdRopa() {
        return idRopa;
    }

    /** @param idRopa ID de la ropa. */
    public void setIdRopa(String idRopa) {
        this.idRopa = idRopa;
    }

    /** @return Nombre del artículo. */
    public String getNombreArticulo() {
        return nombreArticulo;
    }

    /** @param nombreArticulo Nombre del artículo. */
    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    /** @return URL de la imagen. */
    public String getUrlImagen() {
        return urlImagen;
    }

    /** @param urlImagen URL de la imagen asociada. */
    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    /** @return Precio del artículo. */
    public double getPrecio() {
        return precio;
    }

    /** @param precio Precio del artículo. */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /** @return Descripción general. */
    public String getDescripcion() {
        return descripcion;
    }

    /** @param descripcion Descripción general. */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /** @return Temporada del artículo. */
    public String getTemporada() {
        return Temporada;
    }

    /** @param Temporada Temporada del artículo. */
    public void setTemporada(String Temporada) {
        this.Temporada = Temporada;
    }

    /** @return Marca del artículo. */
    public String getMarca() {
        return Marca;
    }

    /** @param Marca Marca del artículo. */
    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    /** @return Material del artículo. */
    public String getMaterial() {
        return Material;
    }

    /** @param Material Material del artículo. */
    public void setMaterial(String Material) {
        this.Material = Material;
    }
}
