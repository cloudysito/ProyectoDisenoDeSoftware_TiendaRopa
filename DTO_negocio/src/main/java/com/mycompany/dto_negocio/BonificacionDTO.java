/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

/**
 *
 * @author riosr
 */
public class BonificacionDTO {
    private String idBonificacion;
    private String descripcion;
    private int cantidadVenta;

    public BonificacionDTO() {}
    
    public BonificacionDTO(String idBonificacion, String descripcion, int cantidadVenta) {
        this.idBonificacion = idBonificacion;
        this.descripcion = descripcion;
        this.cantidadVenta = cantidadVenta;
    }
    
    public BonificacionDTO(String descripcion, int cantidadVenta){
        this.descripcion = descripcion;
        this.cantidadVenta = cantidadVenta;
    }

    public String getIdBonificacion() {
        return idBonificacion;
    }

    public void setIdBonificacion(String id) {
        this.idBonificacion = idBonificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadVenta() {
        return cantidadVenta;
    }

    public void setCantidadVenta(int cantidadVenta) {
        this.cantidadVenta = cantidadVenta;
    }
    
}
