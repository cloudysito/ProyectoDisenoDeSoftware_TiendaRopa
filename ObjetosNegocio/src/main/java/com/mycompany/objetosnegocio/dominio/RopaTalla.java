/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objetosnegocio.dominio;

/**
 *
 * @author santi
 */
public class RopaTalla {
    private int id;
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

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public Ropa getRopa() { return ropa; }
    public void setRopa(Ropa ropa) { this.ropa = ropa; }

    public Talla getTalla() { return talla; }
    public void setTalla(Talla talla) { this.talla = talla; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    @Override
    public String toString() {
        return ropa.getNombreArticulo() + " - " + talla.getNombreTalla() + " (" + cantidad + ")";
    }
}

