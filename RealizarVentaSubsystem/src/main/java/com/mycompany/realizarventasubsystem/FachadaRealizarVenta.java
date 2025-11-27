/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.realizarventasubsystem;

import com.mycompany.dto_negocio.DetalleVentaDTO;
import com.mycompany.dto_negocio.VentaDTO;
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
    public VentaDTO crearVenta(VentaDTO venta) {
        venta.setFechaHoraVenta(Date.from(Instant.MIN));
        venta.setFolioVenta(23);
        return venta;
        
    }

    @Override
    public DetalleVentaDTO reducirStock(DetalleVentaDTO detalleVenta) {
        return detalleVenta;
    }

    @Override
    public DetalleVentaDTO cambiarTallaDisponible(DetalleVentaDTO producto) {
        return producto;
    }

    @Override
    public boolean registrarVenta(VentaDTO venta) {
        return true;
    }
   
}
