/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

/**
 *
 * @author santi
 */
/**
 * DTO utilizado para representar los criterios de búsqueda de una prenda.
 * Permite filtrar por temporada, material, marca, precio y talla.
 */
public class BuscarPrendaDTO {

    /** Temporada de la prenda (ej. Primavera, Verano, Otoño, Invierno). */
    private String temporada;

    /** Material principal de la prenda (ej. Algodón, Poliéster, Lana). */
    private String material;

    /** Marca de la prenda. */
    private String marca;

    /** Precio máximo o específico para filtrar prendas. */
    private Double precio;

    /** Nombre de la talla (ej. S, M, L, XL). */
    private String nombreTalla;

    /**
     * Constructor completo para inicializar los criterios de búsqueda.
     *
     * @param temporada temporada de la prenda
     * @param material material de la prenda
     * @param marca marca de la prenda
     * @param precio precio de la prenda
     * @param nombreTalla nombre de la talla
     */
    public BuscarPrendaDTO(String temporada, String material, String marca, Double precio, String nombreTalla) {
        this.temporada = temporada;
        this.material = material;
        this.marca = marca;
        this.precio = precio;
        this.nombreTalla = nombreTalla;
    }

    /** Constructor vacío requerido para serialización/deserialización. */
    public BuscarPrendaDTO() {
    }

    /**
     * Obtiene la temporada de la prenda.
     *
     * @return temporada
     */
    public String getTemporada() {
        return temporada;
    }

    /**
     * Establece la temporada de la prenda.
     *
     * @param temporada nueva temporada
     */
    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    /**
     * Obtiene el material de la prenda.
     *
     * @return material
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Establece el material de la prenda.
     *
     * @param material nuevo material
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Obtiene la marca de la prenda.
     *
     * @return marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca de la prenda.
     *
     * @param marca nueva marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene el precio de la prenda.
     *
     * @return precio
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio de la prenda.
     *
     * @param precio nuevo precio
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el nombre de la talla.
     *
     * @return nombre de la talla
     */
    public String getNombreTalla() {
        return nombreTalla;
    }

    /**
     * Establece el nombre de la talla.
     *
     * @param nombreTalla nueva talla
     */
    public void setNombreTalla(String nombreTalla) {
        this.nombreTalla = nombreTalla;
    }
}

