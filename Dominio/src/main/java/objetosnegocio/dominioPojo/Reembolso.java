/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio.dominioPojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author emiim
 */
public class Reembolso {
    private ObjectId id;
    private ObjectId idVentaOriginal;
    private Empleado empleado;  
    private Date fechaDevolucion;
    private double totalReembolsado;
    private String metodoReembolso;
    
    private List<DetalleReembolso> detalles = new ArrayList<>();

    public Reembolso() {}

    public Reembolso(ObjectId idVentaOriginal, Empleado empleado, Date fechaDevolucion, double totalReembolsado, String metodoReembolso) {
        this.idVentaOriginal = idVentaOriginal;
        this.empleado = empleado;
        this.fechaDevolucion = fechaDevolucion;
        this.totalReembolsado = totalReembolsado;
        this.metodoReembolso = metodoReembolso;
    }
    
    public void agregarDetalle(DetalleReembolso detalle) {
        if (detalle != null) {
            detalles.add(detalle);
        }
    }

    public ObjectId getId() { return id; }
    public void setId(ObjectId id) { this.id = id; }

    public ObjectId getIdVentaOriginal() { return idVentaOriginal; }
    public void setIdVentaOriginal(ObjectId idVentaOriginal) { this.idVentaOriginal = idVentaOriginal; }

    public Empleado getEmpleado() { return empleado; }
    public void setEmpleado(Empleado empleado) { this.empleado = empleado; }

    public Date getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(Date fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }

    public double getTotalReembolsado() { return totalReembolsado; }
    public void setTotalReembolsado(double totalReembolsado) { this.totalReembolsado = totalReembolsado; }

    public String getMetodoReembolso() { return metodoReembolso; }
    public void setMetodoReembolso(String metodoReembolso) { this.metodoReembolso = metodoReembolso; }

    public List<DetalleReembolso> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleReembolso> detalles) { this.detalles = detalles; }

    @Override
    public String toString() {
        return "Devolución de Venta: " + (idVentaOriginal != null ? idVentaOriginal.toString() : "N/A") + 
               " - Total: $" + totalReembolsado;
    }
}
