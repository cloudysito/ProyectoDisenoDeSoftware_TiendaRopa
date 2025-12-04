/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio.dominioPojo;

import org.bson.types.ObjectId;

/**
 *
 * @author emiim
 */
/**
 * Representa el detalle de un reembolso, incluyendo la prenda devuelta,
 * la cantidad y el subtotal reembolsado.
 */
public class DetalleReembolso {

    /** Identificador único del detalle de reembolso. */
    private ObjectId id; 

    /** Relación a la prenda y talla que se está devolviendo. */
    private RopaTalla ropaTalla; 
    
    /** Cantidad de unidades devueltas. */
    private int cantidadDevuelta;

    /** Monto correspondiente al subtotal reembolsado por este detalle. */
    private double subtotalReembolsado;

    /**
     * Constructor vacío que inicializa el identificador con un nuevo ObjectId.
     */
    public DetalleReembolso() {
        this.id = new ObjectId();
    }

    /**
     * Constructor que inicializa todos los atributos del detalle de reembolso.
     *
     * @param ropaTalla prenda y talla asociada al reembolso
     * @param cantidadDevuelta cantidad de unidades devueltas
     * @param subtotalReembolsado monto subtotal reembolsado
     */
    public DetalleReembolso(RopaTalla ropaTalla, int cantidadDevuelta, double subtotalReembolsado) {
        this.id = new ObjectId();
        this.ropaTalla = ropaTalla;
        this.cantidadDevuelta = cantidadDevuelta;
        this.subtotalReembolsado = subtotalReembolsado;
    }

    /**
     * Obtiene el identificador del detalle de reembolso.
     *
     * @return id del detalle
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador del detalle de reembolso.
     *
     * @param id nuevo identificador
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene la prenda y talla asociada al reembolso.
     *
     * @return objeto RopaTalla asociado
     */
    public RopaTalla getRopaTalla() {
        return ropaTalla;
    }

    /**
     * Establece la prenda y talla asociada al reembolso.
     *
     * @param ropaTalla nueva prenda-talla asociada
     */
    public void setRopaTalla(RopaTalla ropaTalla) {
        this.ropaTalla = ropaTalla;
    }

    /**
     * Obtiene la cantidad de unidades devueltas.
     *
     * @return cantidad devuelta
     */
    public int getCantidadDevuelta() {
        return cantidadDevuelta;
    }

    /**
     * Establece la cantidad de unidades devueltas.
     *
     * @param cantidadDevuelta nueva cantidad devuelta
     */
    public void setCantidadDevuelta(int cantidadDevuelta) {
        this.cantidadDevuelta = cantidadDevuelta;
    }

    /**
     * Obtiene el subtotal reembolsado correspondiente a este detalle.
     *
     * @return subtotal reembolsado
     */
    public double getSubtotalReembolsado() {
        return subtotalReembolsado;
    }

    /**
     * Establece el subtotal reembolsado correspondiente a este detalle.
     *
     * @param subtotalReembolsado nuevo subtotal reembolsado
     */
    public void setSubtotalReembolsado(double subtotalReembolsado) {
        this.subtotalReembolsado = subtotalReembolsado;
    }
}
