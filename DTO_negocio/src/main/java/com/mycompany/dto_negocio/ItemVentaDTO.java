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
 * Representa un ítem dentro de una venta, incluyendo la prenda seleccionada,
 * su precio unitario y la cantidad comprada.
 */
public class ItemVentaDTO {
    private RopaTallaDTO ropaTalla;
    private double precioUnitario;
    private int cantidadComprada;

    /**
     * Constructor vacío para ItemVentaDTO.
     */
    public ItemVentaDTO() {}

    /**
     * Obtiene la prenda con su talla correspondiente.
     *
     * @return la prenda con talla
     */
    public RopaTallaDTO getRopaTalla() {
        return ropaTalla;
    }

    /**
     * Establece la prenda con su talla correspondiente.
     *
     * @param ropaTalla la prenda con talla
     */
    public void setRopaTalla(RopaTallaDTO ropaTalla) {
        this.ropaTalla = ropaTalla;
    }

    /**
     * Obtiene el precio unitario del ítem.
     *
     * @return el precio unitario
     */
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Establece el precio unitario del ítem.
     *
     * @param precioUnitario el precio unitario
     */
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    /**
     * Obtiene la cantidad comprada del ítem.
     *
     * @return la cantidad comprada
     */
    public int getCantidadComprada() {
        return cantidadComprada;
    }

    /**
     * Establece la cantidad comprada del ítem.
     *
     * @param cantidadComprada la cantidad comprada
     */
    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }
}
