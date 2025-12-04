/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author santi
 */
public class VentaDTO {
    private String idVenta;
    private int folioVenta;
    private Date fechaHoraVenta;
    private double totalVenta = 0;
    private String metodoPago;
    private EmpleadoDTO empleado;
    private List<DetalleVentaDTO> detalles = new ArrayList<DetalleVentaDTO>();

    public VentaDTO() {}

    public VentaDTO(String idVenta, int folioVenta, Date fechaHoraVenta, double totalVenta, String metodoPago, EmpleadoDTO empleado, List<DetalleVentaDTO> detalles) {
        this.idVenta = idVenta;
        this.folioVenta = folioVenta;
        this.fechaHoraVenta = fechaHoraVenta;
        this.totalVenta = totalVenta;
        this.metodoPago = metodoPago;
        this.empleado = empleado;
        this.detalles = detalles;
    }

    public VentaDTO(int folioVenta, Date fechaHoraVenta, double totalVenta, String metodoPago, EmpleadoDTO empleado, List<DetalleVentaDTO> detalles) {
        this.folioVenta = folioVenta;
        this.fechaHoraVenta = fechaHoraVenta;
        this.totalVenta = totalVenta;
        this.metodoPago = metodoPago;
        this.empleado = empleado;
        this.detalles = detalles;
    }
    
    public void agregarDetalle(DetalleVentaDTO detalle) {
        if (detalle != null) {
            detalles.add(detalle);
        }
    }

    public double getTotalVenta() {
        double subtotal = 0.0;
        int cantidadPrendas = 0;

        for (DetalleVentaDTO d : detalles) {
            subtotal += d.getSubtotal();
            cantidadPrendas += d.getCantidadVendida();
        }

        // 3 prendas = 10% descuento
        if (cantidadPrendas >= 3) {
            return subtotal * 0.90; 
        }

        return subtotal;
    }
    
    public boolean tieneDescuentoAplicado() {
        int cantidadPrendas = 0;
        for (DetalleVentaDTO d : detalles) {
            cantidadPrendas += d.getCantidadVendida();
        }
        return cantidadPrendas >= 3;
    }
    
    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public int getFolioVenta() {
        return folioVenta;
    }

    public void setFolioVenta(int folioVenta) {
        this.folioVenta = folioVenta;
    }

    public Date getFechaHoraVenta() {
        return fechaHoraVenta;
    }

    public void setFechaHoraVenta(Date fechaHoraVenta) {
        this.fechaHoraVenta = fechaHoraVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public EmpleadoDTO getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }

    public List<DetalleVentaDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleVentaDTO> detalles) {
        this.detalles = detalles;
    }

    
}
