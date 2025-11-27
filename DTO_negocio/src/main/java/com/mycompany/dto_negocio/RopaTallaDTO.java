/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

/**
 *
 * @author garfi
 */
public class RopaTallaDTO {
    
    private String idRopaTalla;
    private RopaDTO Ropa;
    private TallaDTO Talla;
    private String codigoBarras;
    private int cantidad;

    public RopaTallaDTO() {
    }

    public RopaTallaDTO(String idRopaTalla, RopaDTO Ropa, TallaDTO Talla, String codigoBarras, int cantidad) {
        this.idRopaTalla = idRopaTalla;
        this.Ropa = Ropa;
        this.Talla = Talla;
        this.codigoBarras = codigoBarras;
        this.cantidad = cantidad;
    }


    public String getIdRopaTalla() {
        return idRopaTalla;
    }

    public void setIdRopaTalla(String idRopaTalla) {
        this.idRopaTalla = idRopaTalla;
    }

    public RopaDTO getRopa() {
        return Ropa;
    }

    public void setRopa(RopaDTO Ropa) {
        this.Ropa = Ropa;
    }

    public TallaDTO getTalla() {
        return Talla;
    }

    public void setTalla(TallaDTO Talla) {
        this.Talla = Talla;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
