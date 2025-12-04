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
/**
 * Representa una solicitud de reembolso realizada por un empleado,
 * basada en una venta original y detallando los productos a reembolsar.
 */
public class SolicitudReembolsoDTO {

    private VentaDTO ventaOriginal;
    private EmpleadoDTO empleado;
    private String metodoReembolso;
    private double montoTotal;
    private List<DetalleReembolsoDTO> listaDetalles;

    /**
     * Constructor vacío para inicialización por defecto.
     */
    public SolicitudReembolsoDTO() {}

    /**
     * Obtiene la venta original asociada al reembolso.
     *
     * @return Objeto VentaDTO correspondiente a la venta original.
     */
    public VentaDTO getVentaOriginal() {
        return ventaOriginal;
    }

    /**
     * Establece la venta original de la cual se solicita el reembolso.
     *
     * @param ventaOriginal Venta original asociada a la solicitud.
     */
    public void setVentaOriginal(VentaDTO ventaOriginal) {
        this.ventaOriginal = ventaOriginal;
    }

    /**
     * Obtiene el empleado que genera la solicitud de reembolso.
     *
     * @return Objeto EmpleadoDTO del empleado solicitante.
     */
    public EmpleadoDTO getEmpleado() {
        return empleado;
    }

    /**
     * Establece el empleado que realiza la solicitud de reembolso.
     *
     * @param empleado Empleado solicitante del reembolso.
     */
    public void setEmpleado(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }

    /**
     * Obtiene el método en el que se realizará el reembolso.
     *
     * @return Método de reembolso (ej. Efectivo, Transferencia, Vale).
     */
    public String getMetodoReembolso() {
        return metodoReembolso;
    }

    /**
     * Establece el método de reembolso.
     *
     * @param metodoReembolso Nuevo método de reembolso.
     */
    public void setMetodoReembolso(String metodoReembolso) {
        this.metodoReembolso = metodoReembolso;
    }

    /**
     * Obtiene el monto total a reembolsar.
     *
     * @return Monto total del reembolso.
     */
    public double getMontoTotal() {
        return montoTotal;
    }

    /**
     * Establece el monto total del reembolso.
     *
     * @param montoTotal Nuevo monto total.
     */
    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    /**
     * Obtiene la lista de detalles del reembolso,
     * que contiene los productos o elementos a devolver.
     *
     * @return Lista de DetalleReembolsoDTO.
     */
    public List<DetalleReembolsoDTO> getListaDetalles() {
        return listaDetalles;
    }

    /**
     * Establece la lista de detalles del reembolso.
     *
     * @param listaDetalles Lista de objetos DetalleReembolsoDTO.
     */
    public void setListaDetalles(List<DetalleReembolsoDTO> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }
}
