/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.realizarventasubsystem.Interfaz;

import com.mycompany.dto_negocio.DetalleVentaDTO;
import com.mycompany.dto_negocio.VentaDTO;

/**
 *
 * @author santi
 */
public interface IRealizarVenta {
    VentaDTO crearVenta(VentaDTO venta);
    DetalleVentaDTO reducirStock(DetalleVentaDTO detalleVenta);
    DetalleVentaDTO cambiarTallaDisponible(DetalleVentaDTO producto);
    boolean registrarVenta(VentaDTO venta);
}