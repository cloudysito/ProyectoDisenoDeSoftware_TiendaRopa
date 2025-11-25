/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import com.mycompany.objetosnegocio.dominio.DetalleVenta;
import com.mycompany.objetosnegocio.dto.DetalleVentaDTO;

/**
 *
 * @author garfi
 */
public class DetalleVentaMapper {
    
    public DetalleVenta toEntity(DetalleVentaDTO dto) {
        if (dto == null) {
            return null;
        }
        DetalleVenta dv = new DetalleVenta();
        dv.setIdDetalleVenta(dto.getIdDetalleVenta());
        dv.setRopaTalla(dto.setRopaTalla(ropaTalla));
        dv.setCantidadVendida(dto.getCantidadVendida());
        dv.setSubtotal(dto.getSubtotal());               
        
        return dv;
    }
    
    public DetalleVentaDTO toDTO(DetalleVenta dv) {
        if (dv == null) {
            return null;
        }
        DetalleVentaDTO dto = new DetalleVentaDTO();
        dto.setIdDetalleVenta(dv.getIdDetalleVenta());
        dto.setRopaTalla(dv.getRopaTalla());
        dto.setCantidadVendida(dv.getCantidadVendida());
        dto.setSubtotal(dv.getSubtotal());
        
        return dto;
    }
    
}
