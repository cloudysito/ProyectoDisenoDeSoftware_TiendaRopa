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
 * Representa el detalle de una venta, incluyendo la prenda vendida, la cantidad
 * y el subtotal correspondiente.
 */
public class DetalleVentaDTO {

    private String idDetalleVenta;
    private RopaTallaDTO ropaTalla;
    private int cantidadVendida;
    private double subtotal;

    /**
     * Constructor vacío para DetalleVentaDTO.
     */
    public DetalleVentaDTO() {}

    /**
     * Constructor con todos los atributos.
     *
     * @param idDetalleVenta identificador del detalle de venta
     * @param ropaTalla      prenda con su talla asociada
     * @param cantidadVendida cantidad vendida del artículo
     * @param subtotal       subtotal correspondiente al artículo
     */
    public DetalleVentaDTO(String idDetalleVenta, RopaTallaDTO ropaTalla, int cantidadVendida, double subtotal) {
        this.idDetalleVenta = idDetalleVenta;
        this.ropaTalla = ropaTalla;
        this.cantidadVendida = cantidadVendida;
        this.subtotal = subtotal;
    }

    /**
     * Constructor sin ID.
     *
     * @param ropaTalla      prenda con su talla asociada
     * @param cantidadVendida cantidad de artículos vendidos
     * @param subtotal       subtotal correspondiente al artículo
     */
    public DetalleVentaDTO(RopaTallaDTO ropaTalla, int cantidadVendida, double subtotal) {
        this.ropaTalla = ropaTalla;
        this.cantidadVendida = cantidadVendida;
        this.subtotal = subtotal;
    }

    /**
     * Obtiene el identificador del detalle de venta.
     *
     * @return id del detalle de venta
     */
    public String getIdDetalleVenta() {
        return idDetalleVenta;
    }

    /**
     * Establece el identificador del detalle de venta.
     *
     * @param idDetalleVenta nuevo id
     */
    public void setIdDetalleVenta(String idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    /**
     * Obtiene la prenda con su talla correspondiente.
     *
     * @return objeto RopaTallaDTO
     */
    public RopaTallaDTO getRopaTalla() {
        return ropaTalla;
    }

    /**
     * Establece la prenda con su talla correspondiente.
     *
     * @param ropaTalla nueva prenda-talla
     */
    public void setRopaTalla(RopaTallaDTO ropaTalla) {
        this.ropaTalla = ropaTalla;
    }

    /**
     * Obtiene la cantidad vendida del artículo.
     *
     * @return cantidad vendida
     */
    public int getCantidadVendida() {
        return cantidadVendida;
    }

    /**
     * Establece la cantidad vendida del artículo.
     *
     * @param cantidadVendida nueva cantidad vendida
     */
    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    /**
     * Obtiene el subtotal del artículo vendido.
     *
     * @return subtotal calculado
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * Establece el subtotal del artículo vendido.
     *
     * @param subtotal nuevo subtotal
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
