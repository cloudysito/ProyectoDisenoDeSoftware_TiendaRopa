/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.realizarventasubsystem;

import BOs.Exception.BOException;
import BOs.VentaBO;
import BOs.RopaTallaBO;
import BOs.TallaBO;
import com.mycompany.dto_negocio.DetalleVentaDTO;
import com.mycompany.dto_negocio.RopaDTO;
import com.mycompany.dto_negocio.RopaTallaDTO;
import com.mycompany.dto_negocio.TallaDTO;
import com.mycompany.dto_negocio.VentaDTO;
import com.mycompany.realizarventasubsystem.Interfaz.IRealizarVenta;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 *
 * @author santi
 */
public class FachadaRealizarVenta implements IRealizarVenta {

    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";  // Letras y números

    
    @Override
    public VentaDTO crearVenta(VentaDTO venta) {
        int folio;
        boolean folioValido = false;
        Random random = new Random();
        do {
            folio = 10000000 + random.nextInt(90000000); 
            try {
                VentaDTO ventaExistente = VentaBO.getInstance().buscarPorFolio(folio);
                folioValido = ventaExistente == null;
            } catch (BOException e) {
                // throw new MongoException("Error al verificar existencia del folio: " + folio, e.getCause());
            }
        } while (!folioValido);
        venta.setFolioVenta(folio); 
        venta.setFechaHoraVenta(Date.from(Instant.now()));
        return venta;
    }

    @Override
    public DetalleVentaDTO reducirStock(DetalleVentaDTO detalleVenta) {
       
        RopaTallaBO.getInstance().reducirStock(detalleVenta);
        return detalleVenta;
    }

    
    
    @Override
    public List<TallaDTO> obtenerTallas(){
        return TallaBO.getInstance().buscarTodos();
    }

    @Override
    public boolean registrarVenta(VentaDTO venta) {
        for (DetalleVentaDTO detalleVentaDTO : venta.getDetalles()) {
            DetalleVentaDTO detalleVentaDTO1 = reducirStock(detalleVentaDTO);
        }
        
        VentaBO.getInstance().guardarVenta(venta);
        return true;
    }

    @Override
    public RopaTallaDTO cambiarTallaDisponible(RopaDTO dto, String nombreTalla) {
        return RopaTallaBO.getInstance().buscarRopaTalla(dto, nombreTalla);
    }
   
}
