/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import com.mycompany.dto_negocio.DetalleVentaDTO;
import com.mycompany.dto_negocio.VentaDTO;
import java.util.List;
import java.util.stream.Collectors;
import objetosnegocio.dominioPojo.DetalleVenta;
import objetosnegocio.dominioPojo.Empleado;
import objetosnegocio.dominioPojo.Venta;
import org.bson.types.ObjectId;

/**
 *
 * @author garfi
 */
public class VentaMapper {
    
    private DetalleVentaMapper detalleVentaMapper = new DetalleVentaMapper();
    private final EmpleadoMapper empleadoMapper = new EmpleadoMapper();
    
    
    public Venta toEntity(VentaDTO dto) {
        if (dto == null) {
            return null;
        }
        Venta venta = new Venta();
        venta.setId(new ObjectId(dto.getIdVenta()));
        Empleado empleadoEntidad = empleadoMapper.toEntity(dto.getEmpleado());
        venta.setEmpleado(empleadoEntidad);
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
        dto.setIdVenta(venta.getId().toHexString());
        dto.setEmpleado(empleadoMapper.toDTO(venta.getEmpleado()));
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
