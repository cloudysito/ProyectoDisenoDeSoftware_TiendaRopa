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
 * Representa una venta realizada en el sistema, incluyendo información general como
 * folio, fecha, total, método de pago, empleado responsable y los detalles de la venta.
 */
public class Venta {

    /** Identificador único generado por MongoDB. */
    private ObjectId id;

    /** Folio consecutivo asignado a la venta. */
    private int folioVenta;

    /** Fecha y hora exacta en que se realizó la venta. */
    private Date fechaHoraVenta;

    /** Monto total pagado en la venta. */
    private double totalVenta;

    /** Método de pago utilizado por el cliente. */
    private String metodoPago;

    /** Empleado que realizó la venta. */
    private Empleado empleado;

    /** Lista de productos y cantidades incluidos en la venta. */
    private List<DetalleVenta> detalles = new ArrayList<>();

    /**
     * Constructor vacío requerido para procesos de serialización/deserialización.
     */
    public Venta() {}

    /**
     * Constructor completo para inicializar una venta con todos sus datos principales.
     *
     * @param id identificador único de la venta
     * @param folioVenta folio asignado a la venta
     * @param fechaHoraVenta fecha y hora de realización
     * @param totalVenta monto total de la venta
     * @param metodoPago método de pago utilizado
     * @param empleado empleado responsable de la venta
     */
    public Venta(ObjectId id, int folioVenta, Date fechaHoraVenta, double totalVenta, String metodoPago, Empleado empleado) {
        this.id = id;
        this.folioVenta = folioVenta;
        this.fechaHoraVenta = fechaHoraVenta;
        this.totalVenta = totalVenta;
        this.metodoPago = metodoPago;
        this.empleado = empleado;
    }

    /**
     * Agrega un detalle a la venta si no es nulo.
     *
     * @param detalle detalle de venta a agregar
     */
    public void agregarDetalle(DetalleVenta detalle) {
        if (detalle != null) {
            detalles.add(detalle);
        }
    }

    /**
     * Obtiene el identificador de la venta.
     *
     * @return id de la venta
     */
    public ObjectId getId() { return id; }

    /**
     * Establece el identificador de la venta.
     *
     * @param id identificador único
     */
    public void setId(ObjectId id) { this.id = id; }

    /**
     * Obtiene el folio asignado a la venta.
     *
     * @return folio de la venta
     */
    public int getFolioVenta() { return folioVenta; }

    /**
     * Establece el folio asignado a la venta.
     *
     * @param folioVenta nuevo folio
     */
    public void setFolioVenta(int folioVenta) { this.folioVenta = folioVenta; }

    /**
     * Obtiene la fecha y hora en que fue realizada la venta.
     *
     * @return fecha y hora de la venta
     */
    public Date getFechaHoraVenta() { return fechaHoraVenta; }

    /**
     * Establece la fecha y hora de la venta.
     *
     * @param fechaHoraVenta nueva fecha y hora
     */
    public void setFechaHoraVenta(Date fechaHoraVenta) { this.fechaHoraVenta = fechaHoraVenta; }

    /**
     * Obtiene el total de la venta.
     *
     * @return monto total
     */
    public double getTotalVenta() { return totalVenta; }

    /**
     * Establece el total de la venta.
     *
     * @param totalVenta nuevo total
     */
    public void setTotalVenta(double totalVenta) { this.totalVenta = totalVenta; }

    /**
     * Obtiene el método de pago usado en la venta.
     *
     * @return método de pago
     */
    public String getMetodoPago() { return metodoPago; }

    /**
     * Establece el método de pago usado en la venta.
     *
     * @param metodoPago nuevo método de pago
     */
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    /**
     * Obtiene el empleado responsable de la venta.
     *
     * @return empleado que realizó la venta
     */
    public Empleado getEmpleado() { return empleado; }

    /**
     * Establece el empleado responsable de la venta.
     *
     * @param empleado nuevo empleado asociado
     */
    public void setEmpleado(Empleado empleado) { this.empleado = empleado; }

    /**
     * Obtiene la lista de detalles de la venta.
     *
     * @return lista de detalles
     */
    public List<DetalleVenta> getDetalles() { return detalles; }

    /**
     * Establece la lista de detalles de la venta.
     *
     * @param detalles nueva lista de detalles
     */
    public void setDetalles(List<DetalleVenta> detalles) { this.detalles = detalles; }

    /**
     * Representación en cadena de la venta, mostrando folio y total.
     *
     * @return representación textual de la venta
     */
    @Override
    public String toString() {
        return "Venta #" + folioVenta + " - Total: $" + totalVenta;
    }
}
