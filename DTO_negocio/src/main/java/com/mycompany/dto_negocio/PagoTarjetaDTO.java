/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

/**
 *
 * @author c
 */
public class PagoTarjetaDTO {

    private double monto;
    private String numeroTarjeta;
    private String nombreTitular;
    private String fechaVencimiento;
    private String cvv;

    public PagoTarjetaDTO() {}

    public PagoTarjetaDTO(double monto, String numeroTarjeta, String nombreTitular,String fechaVencimiento, String cvv) {

        this.monto = monto;
        this.numeroTarjeta = numeroTarjeta;
        this.nombreTitular = nombreTitular;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
    }

     public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
    /*Convierte PagoTarjetaDTO a un PagoDTO generico*/
    public PagoDTO toPagoDTO() {
        return new PagoDTO("Tarjeta", this.monto, false);
    }
}
    


