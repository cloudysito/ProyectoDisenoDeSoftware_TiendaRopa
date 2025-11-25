/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import com.mycompany.objetosnegocio.dominio.DetalleVenta;
import com.mycompany.objetosnegocio.dominio.Venta;
import com.mycompany.objetosnegocio.dto.DetalleVentaDTO;
import com.mycompany.objetosnegocio.dto.VentaDTO;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author garfi
 */
public class VentaMapper {
    
    private DetalleVentaMapper detalleVentaMapper = new DetalleVentaMapper();
    
    public Venta toEntity(VentaDTO dto) {
        if (dto == null) {
            return null;
        }
        Venta venta = new Venta();
        venta.setIdVenta(dto.getIdVenta());
        venta.setEmpleado(dto.getIdEmpleado());
        venta.setFechaHoraVenta(dto.getFechaHoraVenta());
        venta.setFolioVenta(dto.getFolioVenta());
        venta.setMetodoPago(dto.getMetodoPago());
        venta.setTotalVenta(dto.getTotalVenta());
        if (dto.getDetalles() != null) {
        List<DetalleVenta> detallesEntidad = dto.getDetalles().stream()
            .map(detalleVentaMapper::toEntity) 
            .collect(Collectors.toList());
        
        venta.setDetalles(detallesEntidad);
    }    
        
        return venta;
    }
    
    public VentaDTO toDTO(Venta venta) {
        if (venta == null) {
            return null;
        }
        VentaDTO dto = new VentaDTO();
        dto.setIdVenta(venta.getIdVenta());
        dto.setIdEmpleado(venta.getEmpleado());
        dto.setFechaHoraVenta(venta.getFechaHoraVenta());
        dto.setFolioVenta(venta.getFolioVenta());
        dto.setMetodoPago(venta.getMetodoPago());
        dto.setTotalVenta(venta.getTotalVenta());
        if (venta.getDetalles() != null) {
        List<DetalleVentaDTO> detallesDTO = venta.getDetalles().stream()
            .map(detalleVentaMapper::toDTO) 
            .collect(Collectors.toList());
            
        dto.setDetalles(detallesDTO);
    }
        
        return dto;
    }
}
