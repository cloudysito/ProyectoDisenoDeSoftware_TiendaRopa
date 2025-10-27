/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objetosnegocio.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author santi
 */
public class Venta {
    private int idVenta;
    private int folioVenta;
    private Date fechaHoraVenta;
    private int totalVenta;
    private String metodoPago;
    private Empleado empleado;
    private List<DetalleVenta> detalles = new ArrayList<>();

    public Venta() {}

    public Venta(int idVenta, int folioVenta, Date fechaHoraVenta, int totalVenta,
                 String metodoPago, Empleado empleado) {
        this.idVenta = idVenta;
        this.folioVenta = folioVenta;
        this.fechaHoraVenta = fechaHoraVenta;
        this.totalVenta = totalVenta;
        this.metodoPago = metodoPago;
        this.empleado = empleado;
    }

    public void agregarDetalle(DetalleVenta detalle) {
        detalles.add(detalle);
    }

    public List<DetalleVenta> getDetalles() { return detalles; }

    public int getIdVenta() { return idVenta; }
    public void setIdVenta(int idVenta) { this.idVenta = idVenta; }

    public int getFolioVenta() { return folioVenta; }
    public void setFolioVenta(int folioVenta) { this.folioVenta = folioVenta; }

    public Date getFechaHoraVenta() { return fechaHoraVenta; }
    public void setFechaHoraVenta(Date fechaHoraVenta) { this.fechaHoraVenta = fechaHoraVenta; }

    public int getTotalVenta() { return totalVenta; }
    public void setTotalVenta(int totalVenta) { this.totalVenta = totalVenta; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public Empleado getEmpleado() { return empleado; }
    public void setEmpleado(Empleado empleado) { this.empleado = empleado; }

    @Override
    public String toString() {
        return "Venta #" + folioVenta + " (" + metodoPago + ") Total: $" + totalVenta;
    }
}
