/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.realizarventasubsystem;

import com.mycompany.objetosnegocio.dto.EmpleadoDTO;
import com.mycompany.objetosnegocio.dto.ProductoDTO;
import com.mycompany.objetosnegocio.dto.VentaDTO;
import com.mycompany.realizarventasubsystem.Interfaz.IRealizarVenta;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author santi
 */
public class FachadaRealizarVenta implements IRealizarVenta {
    @Override
    public VentaDTO crearVenta(EmpleadoDTO empleado, String metodoPago) {
        return new VentaDTO(1001, new Date(), 500, metodoPago, empleado.getIdEmpleado(), new ArrayList<>());
    }

    @Override
    public ProductoDTO reducirStock(ProductoDTO producto, int cantidad) {
        producto.setCantidadDisponible(producto.getCantidadDisponible() - cantidad);
        return producto;
    }

    @Override
    public ProductoDTO cambiarTallaDisponible(ProductoDTO producto) {
        producto.setTalla("L");
        return producto;
    }

    @Override
    public boolean registrarVenta(VentaDTO venta) {
        return true;
    }
}
