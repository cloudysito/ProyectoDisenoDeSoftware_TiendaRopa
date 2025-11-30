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
    private String id;
    private String descripcion;
    private int cantidadVenta;

    public BonificacionDTO() {}
    
    public BonificacionDTO(String id, String descripcion, int cantidadVenta) {
        this.id = id;
        this.descripcion = descripcion;
        this.cantidadVenta = cantidadVenta;
    }
    
    public BonificacionDTO(String descripcion, int cantidadVenta){
        this.descripcion = descripcion;
        this.cantidadVenta = cantidadVenta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
