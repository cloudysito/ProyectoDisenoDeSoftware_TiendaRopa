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
/**
 * Representa un reembolso realizado sobre una venta existente.
 * Incluye información del empleado que registró la devolución,
 * fecha, monto reembolsado, método utilizado y los detalles del reembolso.
 */
public class Reembolso {

    /** Identificador único del reembolso en MongoDB. */
    private ObjectId id;

    /** ID de la venta original sobre la cual se realiza el reembolso. */
    private ObjectId idVentaOriginal;

    /** Empleado que procesó el reembolso. */
    private Empleado empleado;

    /** Fecha en que se realizó la devolución. */
    private Date fechaDevolucion;

    /** Monto total reembolsado. */
    private double totalReembolsado;

    /** Método por el cual se realizó el reembolso (efectivo, tarjeta, etc.). */
    private String metodoReembolso;

    /** Lista de detalles específicos incluidos en el reembolso. */
    private List<DetalleReembolso> detalles = new ArrayList<>();

    /**
     * Constructor vacío requerido por frameworks de persistencia.
     */
    public Reembolso() {}

    /**
     * Constructor para crear un reembolso sin especificar el ID.
     *
     * @param idVentaOriginal ID de la venta original
     * @param empleado empleado que procesó el reembolso
     * @param fechaDevolucion fecha de la devolución
     * @param totalReembolsado monto total reembolsado
     * @param metodoReembolso método utilizado para el reembolso
     */
    public Reembolso(ObjectId idVentaOriginal, Empleado empleado, Date fechaDevolucion,
                     double totalReembolsado, String metodoReembolso) {
        this.idVentaOriginal = idVentaOriginal;
        this.empleado = empleado;
        this.fechaDevolucion = fechaDevolucion;
        this.totalReembolsado = totalReembolsado;
        this.metodoReembolso = metodoReembolso;
    }

    /**
     * Agrega un detalle al reembolso.
     *
     * @param detalle detalle del reembolso a agregar
     */
    public void agregarDetalle(DetalleReembolso detalle) {
        if (detalle != null) {
            detalles.add(detalle);
        }
    }

    /**
     * Obtiene el ID del reembolso.
     *
     * @return el id
     */
    public ObjectId getId() { return id; }

    /**
     * Establece el ID del reembolso.
     *
     * @param id el id
     */
    public void setId(ObjectId id) { this.id = id; }

    /**
     * Obtiene el ID de la venta original.
     *
     * @return id de la venta original
     */
    public ObjectId getIdVentaOriginal() { return idVentaOriginal; }

    /**
     * Establece el ID de la venta original.
     *
     * @param idVentaOriginal id de la venta original
     */
    public void setIdVentaOriginal(ObjectId idVentaOriginal) { this.idVentaOriginal = idVentaOriginal; }

    /**
     * Obtiene el empleado que procesó el reembolso.
     *
     * @return el empleado
     */
    public Empleado getEmpleado() { return empleado; }

    /**
     * Establece el empleado que procesó el reembolso.
     *
     * @param empleado el empleado
     */
    public void setEmpleado(Empleado empleado) { this.empleado = empleado; }

    /**
     * Obtiene la fecha en que se realizó el reembolso.
     *
     * @return fecha de devolución
     */
    public Date getFechaDevolucion() { return fechaDevolucion; }

    /**
     * Establece la fecha de la devolución.
     *
     * @param fechaDevolucion fecha de devolución
     */
    public void setFechaDevolucion(Date fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }

    /**
     * Obtiene el total reembolsado.
     *
     * @return monto reembolsado
     */
    public double getTotalReembolsado() { return totalReembolsado; }

    /**
     * Establece el total reembolsado.
     *
     * @param totalReembolsado monto reembolsado
     */
    public void setTotalReembolsado(double totalReembolsado) { this.totalReembolsado = totalReembolsado; }

    /**
     * Obtiene el método de reembolso.
     *
     * @return método de reembolso
     */
    public String getMetodoReembolso() { return metodoReembolso; }

    /**
     * Establece el método de reembolso.
     *
     * @param metodoReembolso método de reembolso
     */
    public void setMetodoReembolso(String metodoReembolso) { this.metodoReembolso = metodoReembolso; }

    /**
     * Obtiene la lista de detalles del reembolso.
     *
     * @return lista de detalles
     */
    public List<DetalleReembolso> getDetalles() { return detalles; }

    /**
     * Establece la lista completa de detalles.
     *
     * @param detalles lista de detalles
     */
    public void setDetalles(List<DetalleReembolso> detalles) { this.detalles = detalles; }

    /**
     * Representación en texto del reembolso.
     *
     * @return resumen del reembolso
     */
    @Override
    public String toString() {
        return "Devolución de Venta: " +
               (idVentaOriginal != null ? idVentaOriginal.toString() : "N/A") +
               " - Total: $" + totalReembolsado;
    }
}
