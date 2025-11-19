/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objetosnegocio.dto;

/**
 *
 * @author santi
 */
public class PagoDTO {
    private String metodo;
    private int monto;
    private boolean exitoso;

    public PagoDTO() {}

    public PagoDTO(String metodo, int monto, boolean exitoso) {
        this.metodo = metodo;
        this.monto = monto;
        this.exitoso = exitoso;
    }

    public String getMetodo() { return metodo; }
    public void setMetodo(String metodo) { this.metodo = metodo; }

    public int getMonto() { return monto; }
    public void setMonto(int monto) { this.monto = monto; }

    public boolean isExitoso() { return exitoso; }
    public void setExitoso(boolean exitoso) { this.exitoso = exitoso; }
}

