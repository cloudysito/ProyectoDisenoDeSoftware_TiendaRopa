/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio.dominioPojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VentaPOJO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private int folioVenta;
    private Date fechaHoraVenta;
    private double totalVenta;
    private String metodoPago;
    private EmpleadoPOJO empleado;
    
    private List<DetalleVentaPOJO> detalles = new ArrayList<>();

    public VentaPOJO() {}

    public VentaPOJO(String id, int folioVenta, Date fechaHoraVenta, double totalVenta, String metodoPago, EmpleadoPOJO empleado) {
        this.id = id;
        this.folioVenta = folioVenta;
        this.fechaHoraVenta = fechaHoraVenta;
        this.totalVenta = totalVenta;
        this.metodoPago = metodoPago;
        this.empleado = empleado;
    }
    
    public void agregarDetalle(DetalleVentaPOJO detalle) {
        if (detalle != null) {
            detalles.add(detalle);
        }
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public int getFolioVenta() { return folioVenta; }
    public void setFolioVenta(int folioVenta) { this.folioVenta = folioVenta; }
    public Date getFechaHoraVenta() { return fechaHoraVenta; }
    public void setFechaHoraVenta(Date fechaHoraVenta) { this.fechaHoraVenta = fechaHoraVenta; }
    public double getTotalVenta() { return totalVenta; }
    public void setTotalVenta(double totalVenta) { this.totalVenta = totalVenta; }
    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
    public EmpleadoPOJO getEmpleado() { return empleado; }
    public void setEmpleado(EmpleadoPOJO empleado) { this.empleado = empleado; }
    public List<DetalleVentaPOJO> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleVentaPOJO> detalles) { this.detalles = detalles; }

    @Override
    public String toString() {
        return "Venta #" + folioVenta + " - Total: $" + totalVenta;
    }
}