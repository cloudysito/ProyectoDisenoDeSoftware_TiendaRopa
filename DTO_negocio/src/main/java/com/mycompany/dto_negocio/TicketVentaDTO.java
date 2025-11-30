/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author emiim
 */
public class TicketVentaDTO {
    private String idVenta;
    private Date fechaCompra;
    private List<ItemVentaDTO> itemsComprados = new ArrayList<>();

    public TicketVentaDTO() {}

    public String getIdVenta() { return idVenta; }
    public void setIdVenta(String idVenta) { this.idVenta = idVenta; }

    public Date getFechaCompra() { return fechaCompra; }
    public void setFechaCompra(Date fechaCompra) { this.fechaCompra = fechaCompra; }

    public List<ItemVentaDTO> getItemsComprados() { return itemsComprados; }
    public void setItemsComprados(List<ItemVentaDTO> itemsComprados) { this.itemsComprados = itemsComprados; }
}
