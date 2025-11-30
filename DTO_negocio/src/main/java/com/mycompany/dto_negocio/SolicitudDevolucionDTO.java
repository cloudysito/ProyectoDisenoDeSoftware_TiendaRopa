/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

import java.util.List;

public class SolicitudDevolucionDTO {
    
    private String idVentaOriginal; 
    private String idEmpleado;
    private String metodoReembolso;
    private double montoTotal;
    private List<DetalleDevolucionDTO> listaDetalles; // Dice que productos se devuelven

    public SolicitudDevolucionDTO() {
    }

    public SolicitudDevolucionDTO(String idVentaOriginal, String idEmpleado, String metodoReembolso, double montoTotal, List<DetalleDevolucionDTO> listaDetalles) {
        this.idVentaOriginal = idVentaOriginal;
        this.idEmpleado = idEmpleado;
        this.metodoReembolso = metodoReembolso;
        this.montoTotal = montoTotal;
        this.listaDetalles = listaDetalles;
    }

    public String getIdVentaOriginal() {
        return idVentaOriginal;
    }

    public void setIdVentaOriginal(String idVentaOriginal) {
        this.idVentaOriginal = idVentaOriginal;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getMetodoReembolso() {
        return metodoReembolso;
    }

    public void setMetodoReembolso(String metodoReembolso) {
        this.metodoReembolso = metodoReembolso;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public List<DetalleDevolucionDTO> getListaDetalles() {
        return listaDetalles;
    }

    public void setListaDetalles(List<DetalleDevolucionDTO> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }
}