/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

import java.util.List;

/**
 *
 * @author emiim
 */
public class SolicitudReembolsoDTO {
    private VentaDTO ventaOriginal;
    private EmpleadoDTO empleado;
    private String metodoReembolso;
    private double montoTotal;
    
    private List<DetalleReembolsoDTO> listaDetalles;

    public SolicitudReembolsoDTO() {}

    public VentaDTO getVentaOriginal() {
        return ventaOriginal;
    }

    public void setVentaOriginal(VentaDTO ventaOriginal) {
        this.ventaOriginal = ventaOriginal;
    }

    public EmpleadoDTO getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoDTO empleado) {
        this.empleado = empleado;
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

    public List<DetalleReembolsoDTO> getListaDetalles() {
        return listaDetalles;
    }

    public void setListaDetalles(List<DetalleReembolsoDTO> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }
}
