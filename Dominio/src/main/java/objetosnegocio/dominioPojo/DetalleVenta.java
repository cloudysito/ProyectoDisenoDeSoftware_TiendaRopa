/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio.dominioPojo;

import org.bson.types.ObjectId;

/**
 * Representa el detalle individual dentro de una venta,
 * incluyendo la prenda vendida, la cantidad y el subtotal generado.
 */
public class DetalleVenta {

    /** Identificador único del detalle de venta. */
    private ObjectId id;

    /** Relación a la prenda con su talla específica. */
    private RopaTalla ropaTalla;

    /** Cantidad de unidades vendidas. */
    private int cantidadVendida;

    /** Subtotal correspondiente a la línea de venta. */
    private double subtotal;

    /** Constructor vacío. */
    public DetalleVenta() {}

    /**
     * Constructor que inicializa los atributos del detalle de venta.
     *
     * @param ropaTalla Prenda y talla asociada a la venta.
     * @param cantidadVendida Cantidad de unidades vendidas.
     * @param subtotal Subtotal generado por este detalle.
     */
    public DetalleVenta(RopaTalla ropaTalla, int cantidadVendida, double subtotal) {
        this.ropaTalla = ropaTalla;
        this.cantidadVendida = cantidadVendida;
        this.subtotal = subtotal;
    }

    /**
     * Obtiene el identificador del detalle.
     *
     * @return ObjectId del detalle.
     */
    public ObjectId getId() { return id; }

    /**
     * Establece el identificador del detalle.
     *
     * @param id ObjectId del detalle.
     */
    public void setId(ObjectId id) { this.id = id; }

    /**
     * Obtiene la prenda y talla asociada.
     *
     * @return Objeto RopaTalla.
     */
    public RopaTalla getRopaTalla() { return ropaTalla; }

    /**
     * Establece la prenda y talla asociada.
     *
     * @param ropaTalla Objeto RopaTalla.
     */
    public void setRopaTalla(RopaTalla ropaTalla) { this.ropaTalla = ropaTalla; }

    /**
     * Obtiene la cantidad vendida del artículo.
     *
     * @return Cantidad vendida.
     */
    public int getCantidadVendida() { return cantidadVendida; }

    /**
     * Establece la cantidad vendida del artículo.
     *
     * @param cantidadVendida Cantidad vendida.
     */
    public void setCantidadVendida(int cantidadVendida) { this.cantidadVendida = cantidadVendida; }

    /**
     * Obtiene el subtotal del detalle de venta.
     *
     * @return Subtotal.
     */
    public double getSubtotal() { return subtotal; }

    /**
     * Establece el subtotal del detalle de venta.
     *
     * @param subtotal Subtotal del detalle.
     */
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
}
