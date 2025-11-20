/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.realizarventasubsystem.Interfaz;

import com.mycompany.objetosnegocio.dominio.DetalleVenta;
import com.mycompany.objetosnegocio.dominio.Empleado;
import com.mycompany.objetosnegocio.dominio.RopaTalla;
import com.mycompany.objetosnegocio.dominio.Venta;
import com.mycompany.objetosnegocio.dto.EmpleadoDTO;
import com.mycompany.objetosnegocio.dto.ProductoDTO;
import com.mycompany.objetosnegocio.dto.VentaDTO;

/**
 *
 * @author santi
 */
public interface IRealizarVenta {
    Venta crearVenta(Venta venta);
    DetalleVenta reducirStock(DetalleVenta detalleVenta);
    DetalleVenta cambiarTallaDisponible(DetalleVenta producto);
    boolean registrarVenta(Venta venta);
}