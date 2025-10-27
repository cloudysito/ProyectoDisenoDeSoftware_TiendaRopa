/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.realizarventasubsystem.Interfaz;

import com.mycompany.objetosnegocio.dto.EmpleadoDTO;
import com.mycompany.objetosnegocio.dto.ProductoDTO;
import com.mycompany.objetosnegocio.dto.VentaDTO;

/**
 *
 * @author santi
 */
public interface IRealizarVenta {
    VentaDTO crearVenta(EmpleadoDTO empleado, String metodoPago);
    ProductoDTO reducirStock(ProductoDTO producto, int cantidad);
    ProductoDTO cambiarTallaDisponible(ProductoDTO producto);
    boolean registrarVenta(VentaDTO venta);
}