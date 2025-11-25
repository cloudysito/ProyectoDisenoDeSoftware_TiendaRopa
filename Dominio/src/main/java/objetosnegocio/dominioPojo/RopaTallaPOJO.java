/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio.dominioPojo;

import java.io.Serializable;

public class RopaTallaPOJO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private RopaPOJO ropa;
    private TallaPOJO talla;
    private String codigo;
    private int cantidad;

    public RopaTallaPOJO() {}

    public RopaTallaPOJO(RopaPOJO ropa, TallaPOJO talla, String codigo, int cantidad) {
        this.ropa = ropa;
        this.talla = talla;
        this.codigo = codigo;
        this.cantidad = cantidad;
    }
    
    public RopaTallaPOJO(String id, RopaPOJO ropa, TallaPOJO talla, String codigo, int cantidad) {
        this.id = id;
        this.ropa = ropa;
        this.talla = talla;
        this.codigo = codigo;
        this.cantidad = cantidad;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public RopaPOJO getRopa() { return ropa; }
    public void setRopa(RopaPOJO ropa) { this.ropa = ropa; }
    public TallaPOJO getTalla() { return talla; }
    public void setTalla(TallaPOJO talla) { this.talla = talla; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    @Override
    public String toString() {
        return (ropa != null ? ropa.getNombreArticulo() : "?") + " - " + (talla != null ? talla.getNombreTalla() : "?");
    }
}