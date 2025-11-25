/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio.dominioPojo;

import org.bson.types.ObjectId;

public class RopaTalla {

    private ObjectId id;
    private Ropa ropa;
    private Talla talla;
    private String codigo;
    private int cantidad;

    public RopaTalla() {}

    public RopaTalla(Ropa ropa, Talla talla, String codigo, int cantidad) {
        this.ropa = ropa;
        this.talla = talla;
        this.codigo = codigo;
        this.cantidad = cantidad;
    }
    
    public RopaTalla(ObjectId id, Ropa ropa, Talla talla, String codigo, int cantidad) {
        this.id = id;
        this.ropa = ropa;
        this.talla = talla;
        this.codigo = codigo;
        this.cantidad = cantidad;
    }

    public Ropa getRopa() { return ropa; }
    public void setRopa(Ropa ropa) { this.ropa = ropa; } 
    public ObjectId getId() { return id; }
    public void setId(ObjectId id) { this.id = id; }
    public Talla getTalla() { return talla; }
    public void setTalla(Talla talla) { this.talla = talla; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    @Override
    public String toString() {
        return (ropa != null ? ropa.getNombreArticulo() : "?") + " - " + (talla != null ? talla.getNombreTalla() : "?");
    }
}