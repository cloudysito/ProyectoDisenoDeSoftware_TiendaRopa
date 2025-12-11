/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

/**
 *
 * @author c
 */
public class PagoPaypalDTO {

    private double monto;
    private String cuenta;
    private String contrasenia;

    public PagoPaypalDTO() {}

    public PagoPaypalDTO(double monto, String cuenta, String contrasenia) {
        this.monto = monto;
        this.cuenta = cuenta;
        this.contrasenia = contrasenia;
    }
 public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    /*Convierte PagoPaypalDTO a un generico parq ue lo pueda utilizar fachada y el subsitema de pagos*/
    public PagoDTO toPagoDTO() {
        return new PagoDTO("Paypal", this.monto, false);
    }
  
}
