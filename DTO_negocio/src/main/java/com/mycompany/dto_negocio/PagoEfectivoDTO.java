/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

/**
 *
 * @author c
 */
public class PagoEfectivoDTO {
    /*Monto total a pagar*/
    private double monto;

    public PagoEfectivoDTO() {}

    public PagoEfectivoDTO(double monto) {
        this.monto = monto;
    }
    /*Obtiene el monto*/
    public double getMonto() {
        return monto;
    }
    /*Establece el monto a pagar*/
    public void setMonto(double monto) {
        this.monto = monto;
    }
    /*Convierte este objeto específico de efectivo a un PagoDTO genérico
    */
public PagoDTO toPagoDTO() {
        return new PagoDTO("Efectivo", this.monto, false);
    }
}
