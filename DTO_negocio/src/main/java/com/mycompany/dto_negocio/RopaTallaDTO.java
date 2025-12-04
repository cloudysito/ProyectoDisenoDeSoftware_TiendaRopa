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
 * Representa la relación entre una prenda de ropa y una talla específica,
 * incluyendo su código de barras individual y la cantidad disponible.
 */
public class RopaTallaDTO {

    private String idRopaTalla;
    private RopaDTO Ropa;
    private TallaDTO Talla;
    private String codigoBarras;
    private int cantidad;

    /**
     * Constructor vacío para inicialización por defecto.
     */
    public RopaTallaDTO() {
    }

    /**
     * Constructor completo que inicializa todos los atributos.
     *
     * @param idRopaTalla Identificador único de la relación ropa–talla.
     * @param Ropa Objeto RopaDTO que representa la prenda asociada.
     * @param Talla Objeto TallaDTO que representa la talla de la prenda.
     * @param codigoBarras Código de barras único asociado a la combinación ropa–talla.
     * @param cantidad Existencias disponibles de esta combinación.
     */
    public RopaTallaDTO(String idRopaTalla, RopaDTO Ropa, TallaDTO Talla, String codigoBarras, int cantidad) {
        this.idRopaTalla = idRopaTalla;
        this.Ropa = Ropa;
        this.Talla = Talla;
        this.codigoBarras = codigoBarras;
        this.cantidad = cantidad;
    }

    /**
     * Constructor que inicializa todos los atributos excepto el ID.
     *
     * @param Ropa Prenda de ropa asociada.
     * @param Talla Talla de la prenda.
     * @param codigoBarras Código de barras asociado.
     * @param cantidad Existencias disponibles.
     */
    public RopaTallaDTO(RopaDTO Ropa, TallaDTO Talla, String codigoBarras, int cantidad) {
        this.Ropa = Ropa;
        this.Talla = Talla;
        this.codigoBarras = codigoBarras;
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el identificador de la relación ropa–talla.
     *
     * @return ID de la relación.
     */
    public String getIdRopaTalla() {
        return idRopaTalla;
    }

    /**
     * Establece el ID de la relación ropa–talla.
     *
     * @param idRopaTalla Nuevo identificador.
     */
    public void setIdRopaTalla(String idRopaTalla) {
        this.idRopaTalla = idRopaTalla;
    }

    /**
     * Obtiene la prenda asociada.
     *
     * @return Objeto RopaDTO.
     */
    public RopaDTO getRopa() {
        return Ropa;
    }

    /**
     * Establece la prenda asociada.
     *
     * @param Ropa Nueva prenda asociada.
     */
    public void setRopa(RopaDTO Ropa) {
        this.Ropa = Ropa;
    }

    /**
     * Obtiene la talla asignada a la prenda.
     *
     * @return Objeto TallaDTO.
     */
    public TallaDTO getTalla() {
        return Talla;
    }

    /**
     * Establece la talla asignada.
     *
     * @param Talla Nueva talla asociada.
     */
    public void setTalla(TallaDTO Talla) {
        this.Talla = Talla;
    }

    /**
     * Obtiene el código de barras correspondiente a esta combinación.
     *
     * @return Código de barras.
     */
    public String getCodigoBarras() {
        return codigoBarras;
    }

    /**
     * Establece el código de barras de esta combinación ropa–talla.
     *
     * @param codigoBarras Nuevo código de barras.
     */
    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    /**
     * Obtiene la cantidad disponible en inventario.
     *
     * @return Cantidad disponible.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad disponible.
     *
     * @param cantidad Nueva cantidad.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
