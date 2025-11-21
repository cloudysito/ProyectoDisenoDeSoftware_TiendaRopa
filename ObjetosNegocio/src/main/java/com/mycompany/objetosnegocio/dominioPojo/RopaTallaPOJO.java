/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objetosnegocio.dominioPojo;

import java.io.Serializable;

/**
 *
 * @author emiim
 */
public class RopaTallaPOJO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private int id;
    private RopaPOJO ropa; 
    private TallaPOJO talla;
    private String codigo;
    private int cantidad;
 
    public RopaTallaPOJO() {}

    public RopaTallaPOJO(int id, RopaPOJO ropa, TallaPOJO talla, String codigo, int cantidad) {
        this.id = id;
        this.ropa = ropa;
        this.talla = talla;
        this.codigo = codigo;
        this.cantidad = cantidad;
    }

    public RopaTallaPOJO(RopaPOJO ropa, TallaPOJO talla, String codigo, int cantidad) {
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

    public RopaPOJO getRopa() {
        return ropa;
    }

    public void setRopa(RopaPOJO ropa) {
        this.ropa = ropa;
    }

    public TallaPOJO getTalla() {
        return talla;
    }

    public void setTalla(TallaPOJO talla) {
        this.talla = talla;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        String nombreRopa = (ropa != null) ? ropa.getNombreArticulo(): "Sin Ropa";
        String descTalla = (talla != null) ? talla.getDescripcion() : "Sin Talla";
        
        return nombreRopa + " - " + descTalla + " (" + cantidad + ")";
    }
    
}
