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
 * Representa la información de un pago, incluyendo el método utilizado,
 * el monto pagado y si el pago fue exitoso.
 */
public class PagoDTO {
    private String metodo;
    private double monto;
    private boolean exitoso;

    /**
     * Constructor vacío para PagoDTO.
     */
    public PagoDTO() {}

    /**
     * Constructor que inicializa un PagoDTO con sus valores.
     *
     * @param metodo  el método de pago utilizado
     * @param monto   el monto del pago
     * @param exitoso indica si el pago fue exitoso
     */
    public PagoDTO(String metodo, double monto, boolean exitoso) {
        this.metodo = metodo;
        this.monto = monto;
        this.exitoso = exitoso;
    }

    /**
     * Obtiene el método de pago.
     *
     * @return el método de pago
     */
    public String getMetodo() { return metodo; }

    /**
     * Establece el método de pago.
     *
     * @param metodo el método de pago
     */
    public void setMetodo(String metodo) { this.metodo = metodo; }

    /**
     * Obtiene el monto del pago.
     *
     * @return el monto
     */
    public double getMonto() { return monto; }

    /**
     * Establece el monto del pago.
     *
     * @param monto el monto del pago
     */
    public void setMonto(double monto) { this.monto = monto; }

    /**
     * Indica si el pago fue exitoso.
     *
     * @return true si fue exitoso, false en caso contrario
     */
    public boolean isExitoso() { return exitoso; }

    /**
     * Establece si el pago fue exitoso.
     *
     * @param exitoso true si fue exitoso, false en caso contrario
     */
    public void setExitoso(boolean exitoso) { this.exitoso = exitoso; }
}


