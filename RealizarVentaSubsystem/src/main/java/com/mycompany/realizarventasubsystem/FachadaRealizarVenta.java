/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.realizarventasubsystem;

import com.mycompany.objetosnegocio.dominio.DetalleVenta;
import com.mycompany.objetosnegocio.dominio.Empleado;
import com.mycompany.objetosnegocio.dominio.RopaTalla;
import com.mycompany.objetosnegocio.dominio.Venta;
import com.mycompany.objetosnegocio.dto.EmpleadoDTO;
import com.mycompany.objetosnegocio.dto.ProductoDTO;
import com.mycompany.objetosnegocio.dto.VentaDTO;
import com.mycompany.realizarventasubsystem.Interfaz.IRealizarVenta;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author santi
 */
public class FachadaRealizarVenta implements IRealizarVenta {

    @Override
    public Venta crearVenta(Venta venta) {
        venta.setFechaHoraVenta(Date.from(Instant.MIN));
        venta.setFolioVenta(23);
        return venta;
        
    }

    @Override
    public DetalleVenta reducirStock(DetalleVenta detalleVenta) {
        return detalleVenta;
    }

    @Override
    public DetalleVenta cambiarTallaDisponible(DetalleVenta producto) {
        return producto;
    }

    @Override
    public boolean registrarVenta(Venta venta) {
        return true;
    }
   
}
