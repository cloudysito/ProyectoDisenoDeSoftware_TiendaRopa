/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.realizarventasubsystem.Interfaz;

import com.mycompany.dto_negocio.DetalleVentaDTO;
import com.mycompany.dto_negocio.RopaDTO;
import com.mycompany.dto_negocio.RopaTallaDTO;
import com.mycompany.dto_negocio.TallaDTO;
import com.mycompany.dto_negocio.VentaDTO;
import java.util.List;

/**
 *
 * @author santi
 */
public interface IRealizarVenta {
    VentaDTO crearVenta(VentaDTO venta);
    DetalleVentaDTO reducirStock(DetalleVentaDTO detalleVenta);
    public List<TallaDTO> obtenerTallas();
    RopaTallaDTO cambiarTallaDisponible(RopaDTO dto, String nombreTalla);
    boolean registrarVenta(VentaDTO venta);
}