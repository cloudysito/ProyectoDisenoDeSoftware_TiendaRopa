/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio.dominioPojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

public class Venta {
    private ObjectId id;
    private int folioVenta;
    private Date fechaHoraVenta;
    private double totalVenta;
    private String metodoPago;
    private Empleado empleado;
    
    private List<DetalleVenta> detalles = new ArrayList<>();

    public Venta() {}

    public Venta(ObjectId id, int folioVenta, Date fechaHoraVenta, double totalVenta, String metodoPago, Empleado empleado) {
        this.id = id;
        this.folioVenta = folioVenta;
        this.fechaHoraVenta = fechaHoraVenta;
        this.totalVenta = totalVenta;
        this.metodoPago = metodoPago;
        this.empleado = empleado;
    }
    
    public void agregarDetalle(DetalleVenta detalle) {
        if (detalle != null) {
            detalles.add(detalle);
        }
    }

    public ObjectId getId() { return id; }
    public void setId(ObjectId id) { this.id = id; }
    public int getFolioVenta() { return folioVenta; }
    public void setFolioVenta(int folioVenta) { this.folioVenta = folioVenta; }
    public Date getFechaHoraVenta() { return fechaHoraVenta; }
    public void setFechaHoraVenta(Date fechaHoraVenta) { this.fechaHoraVenta = fechaHoraVenta; }
    public double getTotalVenta() { return totalVenta; }
    public void setTotalVenta(double totalVenta) { this.totalVenta = totalVenta; }
    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
    public Empleado getEmpleado() { return empleado; }
    public void setEmpleado(Empleado empleado) { this.empleado = empleado; }
    public List<DetalleVenta> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleVenta> detalles) { this.detalles = detalles; }

    @Override
    public String toString() {
        return "Venta #" + folioVenta + " - Total: $" + totalVenta;
    }
}