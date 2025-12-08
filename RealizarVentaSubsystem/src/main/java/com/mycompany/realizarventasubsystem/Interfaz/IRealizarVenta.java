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
    
    /**
    * Crea una nueva entidad de venta en la base de datos o en la sesión de trabajo.
    *
    * @param venta El DTO de la venta con la información inicial.
    * @return El DTO de la venta actualizado con su ID/Folio generado.
    */
    VentaDTO crearVenta(VentaDTO venta);
    
    /**
    * Reduce la cantidad de stock disponible para la prenda especificada en el detalle.
    *
    * @param detalleVenta El DTO que indica la prenda, talla y cantidad a reducir.
    * @return El DTO del detalle de venta actualizado tras la reducción.
    */
    DetalleVentaDTO reducirStock(DetalleVentaDTO detalleVenta);
    
    /**
    * Obtiene la lista completa de tallas disponibles en el sistema.
    *
    * @return Una lista de objetos TallaDTO.
    */
    public List<TallaDTO> obtenerTallas();
    
    /**
    * Cambia la talla seleccionada para una prenda específica, buscando el stock
    * disponible para esa nueva combinación Ropa-Talla.
    *
    * @param dto El DTO de la prenda original.
    * @param nombreTalla El nombre de la nueva talla a buscar.
    * @return Un nuevo DTO de RopaTallaDTO con el stock de la talla solicitada.
    */
    RopaTallaDTO cambiarTallaDisponible(RopaDTO dto, String nombreTalla);
    
    /**
    * Persiste la venta completa y sus detalles en la base de datos, marcando la
    * transacción como finalizada.
    *
    * @param venta El DTO de la venta completada.
    * @return {@code true} si la venta se registra exitosamente, {@code false} en caso contrario.
    */
    boolean registrarVenta(VentaDTO venta);
    
    
}