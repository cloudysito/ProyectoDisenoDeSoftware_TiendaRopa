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

    /**
    * Crea una nueva entidad de venta en la base de datos o en la sesión de trabajo.
    * Se encarga de generar un folio único para la venta.
    *
    * @param venta El DTO de la venta con la información inicial.
    * @return El DTO de la venta actualizado con su ID/Folio generado y la fecha/hora.
    */
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

    /**
    * Reduce la cantidad de stock disponible para la prenda especificada en el detalle,
    * delegando la operación a la capa de negocio (RopaTallaBO).
    *
    * @param detalleVenta El DTO que indica la prenda, talla y cantidad a reducir.
    * @return El DTO del detalle de venta.
    */
    @Override
    public DetalleVentaDTO reducirStock(DetalleVentaDTO detalleVenta) {
       
        RopaTallaBO.getInstance().reducirStock(detalleVenta);
        return detalleVenta;
    }

    
    /**
    * Obtiene la lista completa de tallas disponibles en el sistema,
    * delegando la operación a la capa de negocio (TallaBO).
    *
    * @return Una lista de objetos TallaDTO.
        */
    @Override
    public List<TallaDTO> obtenerTallas(){
        return TallaBO.getInstance().buscarTodos();
    }

    /**
    * Persiste la venta completa y sus detalles en la base de datos.
    * Itera sobre los detalles de la venta para reducir el stock de cada producto
    * antes de guardar la venta final.
    *
    * @param venta El DTO de la venta completada.
    * @return {@code true} si la venta se registra exitosamente.
    */
    @Override
    public boolean registrarVenta(VentaDTO venta) {
        for (DetalleVentaDTO detalleVentaDTO : venta.getDetalles()) {
            DetalleVentaDTO detalleVentaDTO1 = reducirStock(detalleVentaDTO);
        }
        
        VentaBO.getInstance().guardarVenta(venta);
        return true;
    }

    
    /**
    * Cambia la talla seleccionada para una prenda específica, buscando el stock
    * disponible para esa nueva combinación Ropa-Talla en la capa de negocio.
    *
    * @param dto El DTO de la prenda original (RopaDTO).
    * @param nombreTalla El nombre de la nueva talla a buscar.
    * @return Un nuevo DTO de RopaTallaDTO con el stock de la talla solicitada.
    */
    @Override
    public RopaTallaDTO cambiarTallaDisponible(RopaDTO dto, String nombreTalla) {
        return RopaTallaBO.getInstance().buscarRopaTalla(dto, nombreTalla);
    }
   
}
