/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import com.mycompany.dto_negocio.DetalleVentaDTO;

import objetosnegocio.dominioPojo.DetalleVenta;
import objetosnegocio.dominioPojo.RopaTalla;
import org.bson.types.ObjectId;


/**
 * Mapper para DetalleVenta.
 * Convierte los ítems individuales de una venta.
 * @author garfi
 */
public class DetalleVentaMapper {
    
    /**
     * Convierte a entidad. 
     * Nota: Si el DTO no tiene ID, genera uno nuevo automáticamente.
     */
    public static DetalleVenta toEntity(DetalleVentaDTO dto) {
        if (dto == null) {
            return null;
        }
        DetalleVenta dv = new DetalleVenta();
        if (dto.getIdDetalleVenta() != null) {
            dv.setId(new ObjectId(dto.getIdDetalleVenta()));
        } else {
            dv.setId(new ObjectId()); // <-- asigna un ID nuevo si no tiene
        }
        RopaTalla ropaTallaEntidad = RopaTallaMapper.toEntity(dto.getRopaTalla());
        dv.setRopaTalla(ropaTallaEntidad);
        dv.setCantidadVendida(dto.getCantidadVendida());
        dv.setSubtotal(dto.getSubtotal());               
        
        return dv;
    }
    
    public static DetalleVentaDTO toDTO(DetalleVenta dv) {
        if (dv == null) {
            return null;
        }
        DetalleVentaDTO dto = new DetalleVentaDTO();
        dto.setIdDetalleVenta(
            dv.getId() != null ? dv.getId().toHexString() : null
        );
        dto.setRopaTalla(RopaTallaMapper.toDTO(dv.getRopaTalla()));
        dto.setCantidadVendida(dv.getCantidadVendida());
        dto.setSubtotal(dv.getSubtotal());
        
        return dto;
    }
    
}
