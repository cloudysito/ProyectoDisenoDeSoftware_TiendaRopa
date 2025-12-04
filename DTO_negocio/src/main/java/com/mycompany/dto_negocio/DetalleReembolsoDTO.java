/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

/**
 *
 * @author emiim
 */
/**
 * Representa el detalle de un reembolso, incluyendo la prenda devuelta,
 * la cantidad y el subtotal reembolsado.
 */
public class DetalleReembolsoDTO {

    private RopaTallaDTO ropaTalla;
    private int cantidadDevuelta;
    private double subtotalReembolsado;

    /**
     * Constructor vacío para DetalleReembolsoDTO.
     */
    public DetalleReembolsoDTO() {}

    /**
     * Obtiene la prenda con su talla asociada.
     *
     * @return objeto RopaTallaDTO que representa la prenda devuelta
     */
    public RopaTallaDTO getRopaTalla() {
        return ropaTalla;
    }

    /**
     * Establece la prenda con su talla asociada.
     *
     * @param ropaTalla nueva prenda-talla devuelta
     */
    public void setRopaTalla(RopaTallaDTO ropaTalla) {
        this.ropaTalla = ropaTalla;
    }

    /**
     * Obtiene la cantidad de artículos devueltos.
     *
     * @return cantidad devuelta
     */
    public int getCantidadDevuelta() {
        return cantidadDevuelta;
    }

    /**
     * Establece la cantidad de artículos devueltos.
     *
     * @param cantidadDevuelta nueva cantidad devuelta
     */
    public void setCantidadDevuelta(int cantidadDevuelta) {
        this.cantidadDevuelta = cantidadDevuelta;
    }

    /**
     * Obtiene el subtotal correspondiente al monto reembolsado.
     *
     * @return subtotal reembolsado
     */
    public double getSubtotalReembolsado() {
        return subtotalReembolsado;
    }

    /**
     * Establece el subtotal reembolsado.
     *
     * @param subtotalReembolsado nuevo subtotal
     */
    public void setSubtotalReembolsado(double subtotalReembolsado) {
        this.subtotalReembolsado = subtotalReembolsado;
    }

    /**
     * Obtiene el nombre de la prenda devuelta.
     *
     * @return nombre de la prenda o "Desconocido" si no existe información suficiente
     */
    public String getNombrePrenda() {
        if (ropaTalla != null && ropaTalla.getRopa() != null) {
            return ropaTalla.getRopa().getNombreArticulo();
        }
        return "Desconocido";
    }
}
