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
    private List<DetalleVentaDTO> detalles = new ArrayList<>();

    /**
     * Constructor vacío para inicialización estándar.
     */
    public VentaDTO() {}

    /**
     * Constructor completo que inicializa todos los atributos de la venta.
     *
     * @param idVenta Identificador único de la venta.
     * @param folioVenta Número de folio de la venta.
     * @param fechaHoraVenta Fecha y hora en que se realizó la venta.
     * @param totalVenta Monto total de la venta.
     * @param metodoPago Método de pago utilizado.
     * @param empleado Empleado que realizó la venta.
     * @param detalles Lista de detalles asociados a la venta.
     */
    public VentaDTO(String idVenta, int folioVenta, Date fechaHoraVenta, double totalVenta,
                    String metodoPago, EmpleadoDTO empleado, List<DetalleVentaDTO> detalles) {
        this.idVenta = idVenta;
        this.folioVenta = folioVenta;
        this.fechaHoraVenta = fechaHoraVenta;
        this.totalVenta = totalVenta;
        this.metodoPago = metodoPago;
        this.empleado = empleado;
        this.detalles = detalles;
    }

    /**
     * Constructor sin ID, usado para ventas nuevas que generarán un ID posteriormente.
     *
     * @param folioVenta Número de folio de la venta.
     * @param fechaHoraVenta Fecha y hora en que se realizó la venta.
     * @param totalVenta Monto total de la venta.
     * @param metodoPago Método de pago utilizado.
     * @param empleado Empleado que realizó la venta.
     * @param detalles Lista de detalles asociados a la venta.
     */
    public VentaDTO(int folioVenta, Date fechaHoraVenta, double totalVenta,
                    String metodoPago, EmpleadoDTO empleado, List<DetalleVentaDTO> detalles) {
        this.folioVenta = folioVenta;
        this.fechaHoraVenta = fechaHoraVenta;
        this.totalVenta = totalVenta;
        this.metodoPago = metodoPago;
        this.empleado = empleado;
        this.detalles = detalles;
    }

    /**
     * Agrega un detalle a la venta si no es nulo.
     *
     * @param detalle Objeto DetalleVentaDTO a agregar.
     */
    public void agregarDetalle(DetalleVentaDTO detalle) {
        if (detalle != null) {
            detalles.add(detalle);
        }
    }

    /**
     * Calcula el total de la venta basándose en los subtotales de los detalles.
     * Aplica un descuento del 10% si se venden 3 o más prendas.
     *
     * @return Total de la venta con o sin descuento aplicado.
     */
    public double getTotalVenta() {
        double subtotal = 0.0;
        int cantidadPrendas = 0;

        for (DetalleVentaDTO d : detalles) {
            subtotal += d.getSubtotal();
            cantidadPrendas += d.getCantidadVendida();
        }

        if (cantidadPrendas >= 3) {
            return subtotal * 0.90; // 10% de descuento
        }

        return subtotal;
    }

    /**
     * Indica si la venta tiene aplicado el descuento por cantidad de prendas.
     *
     * @return true si se vendieron 3 o más prendas, false en caso contrario.
     */
    public boolean tieneDescuentoAplicado() {
        int cantidadPrendas = 0;
        for (DetalleVentaDTO d : detalles) {
            cantidadPrendas += d.getCantidadVendida();
        }
        return cantidadPrendas >= 3;
    }

    /**
     * @return ID único de la venta.
     */
    public String getIdVenta() {
        return idVenta;
    }

    /**
     * @param idVenta Nuevo ID de venta a establecer.
     */
    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    /**
     * @return Número de folio de la venta.
     */
    public int getFolioVenta() {
        return folioVenta;
    }

    /**
     * @param folioVenta Nuevo folio de venta.
     */
    public void setFolioVenta(int folioVenta) {
        this.folioVenta = folioVenta;
    }

    /**
     * @return Fecha y hora de la venta.
     */
    public Date getFechaHoraVenta() {
        return fechaHoraVenta;
    }

    /**
     * @param fechaHoraVenta Nueva fecha y hora de la venta.
     */
    public void setFechaHoraVenta(Date fechaHoraVenta) {
        this.fechaHoraVenta = fechaHoraVenta;
    }

    /**
     * Establece el total de la venta (usualmente no se usa porque el total se calcula automáticamente).
     *
     * @param totalVenta Total de la venta.
     */
    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    /**
     * @return Método de pago utilizado.
     */
    public String getMetodoPago() {
        return metodoPago;
    }

    /**
     * @param metodoPago Nuevo método de pago.
     */
    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    /**
     * @return Empleado que realizó la venta.
     */
    public EmpleadoDTO getEmpleado() {
        return empleado;
    }

    /**
     * @param empleado Nuevo empleado asociado a la venta.
     */
    public void setEmpleado(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }

    /**
     * @return Lista de detalles de la venta.
     */
    public List<DetalleVentaDTO> getDetalles() {
        return detalles;
    }

    /**
     * @param detalles Nueva lista de detalles para la venta.
     */
    public void setDetalles(List<DetalleVentaDTO> detalles) {
        this.detalles = detalles;
    }
}
