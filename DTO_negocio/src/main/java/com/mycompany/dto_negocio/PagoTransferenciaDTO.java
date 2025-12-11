/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

/**
 *
 * @author c
 */
public class PagoTransferenciaDTO {

    private double monto;
    private String numeroCuenta;
    private String nombre;
    private String banco;

    public PagoTransferenciaDTO() {}

    public PagoTransferenciaDTO(double monto, String numeroCuenta, String nombre, String banco) {
        this.monto = monto;
        this.numeroCuenta = numeroCuenta;
        this.nombre = nombre;
        this.banco = banco;
    }
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }
    /*Convierte PagoTransferenciaDTO a un PagoDTO generico*/
    public PagoDTO toPagoDTO() {
        return new PagoDTO("Transferencia", this.monto, false);
    }
   
}
