/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objetosnegocio.dto;

/**
 *
 * @author garfi
 */
public class RopaTallaDTO {
    
    private String idRopaTalla;
    private String idRopa;
    private String idTalla;
    private String codigoBarras;
    private int cantidad;

    public RopaTallaDTO() {
    }

    public RopaTallaDTO(String idRopaTalla, String idRopa, String idTalla, String codigoBarras, int cantidad) {
        this.idRopaTalla = idRopaTalla;
        this.idRopa = idRopa;
        this.idTalla = idTalla;
        this.codigoBarras = codigoBarras;
        this.cantidad = cantidad;
    }

    public String getIdRopaTalla() {
        return idRopaTalla;
    }

    public void setIdRopaTalla(String idRopaTalla) {
        this.idRopaTalla = idRopaTalla;
    }

    public String getIdRopa() {
        return idRopa;
    }

    public void setIdRopa(String idRopa) {
        this.idRopa = idRopa;
    }

    public String getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(String idTalla) {
        this.idTalla = idTalla;
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
