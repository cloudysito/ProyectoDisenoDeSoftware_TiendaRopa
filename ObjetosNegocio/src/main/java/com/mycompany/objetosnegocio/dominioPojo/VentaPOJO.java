/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objetosnegocio.dominioPojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author emiim
 */
public class VentaPOJO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private int idVenta;
    private int folioVenta;
    private Date fechaHoraVenta;
    private int totalVenta;
    private String metodoPago;
    private EmpleadoPOJO empleado;
    
    private List<DetalleVentaPOJO> detalles = new ArrayList<>();

    public VentaPOJO() {}

    public VentaPOJO(int idVenta, int folioVenta, Date fechaHoraVenta, int totalVenta,
                     String metodoPago, EmpleadoPOJO empleado) {
        this.idVenta = idVenta;
        this.folioVenta = folioVenta;
        this.fechaHoraVenta = fechaHoraVenta;
        this.totalVenta = totalVenta;
        this.metodoPago = metodoPago;
        this.empleado = empleado;
    }
    
    public VentaPOJO(int folioVenta, Date fechaHoraVenta, int totalVenta,
                     String metodoPago, EmpleadoPOJO empleado) {
        this.folioVenta = folioVenta;
        this.fechaHoraVenta = fechaHoraVenta;
        this.totalVenta = totalVenta;
        this.metodoPago = metodoPago;
        this.empleado = empleado;
    }

    public void agregarDetalleVenta(DetalleVentaPOJO detalle) {
        if (detalle != null) {
            detalle.setVenta(this);
            detalles.add(detalle);
        }
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
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

    public int getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(int totalVenta) {
        this.totalVenta = totalVenta;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public EmpleadoPOJO getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoPOJO empleado) {
        this.empleado = empleado;
    }

    public List<DetalleVentaPOJO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleVentaPOJO> detalles) {
        this.detalles = detalles;
    }
    
    @Override
    public String toString() {
        return "Venta #" + folioVenta + " (" + metodoPago + ") Total: $" + totalVenta;
    }
    
}
