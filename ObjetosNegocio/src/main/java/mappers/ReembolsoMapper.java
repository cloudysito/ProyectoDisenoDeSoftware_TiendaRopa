/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import com.mycompany.dto_negocio.DetalleReembolsoDTO;
import com.mycompany.dto_negocio.SolicitudReembolsoDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import objetosnegocio.dominioPojo.DetalleReembolso;
import objetosnegocio.dominioPojo.Reembolso;
import objetosnegocio.dominioPojo.RopaTalla;
import org.bson.types.ObjectId;

/**
 *
 * @author emiim
 */
public class ReembolsoMapper {
   public static Reembolso toEntity(SolicitudReembolsoDTO dto) {
        if (dto == null) return null;

        Reembolso entidad = new Reembolso();
        if (dto.getVentaOriginal() != null) {
            entidad.setIdVentaOriginal(new ObjectId(dto.getVentaOriginal().getIdVenta()));
        }

        if (dto.getEmpleado() != null) {
            entidad.setEmpleado(EmpleadoMapper.toEntity(dto.getEmpleado()));
        }

        entidad.setMetodoReembolso(dto.getMetodoReembolso());
        entidad.setTotalReembolsado(dto.getMontoTotal());
        entidad.setFechaDevolucion(new Date());

        List<DetalleReembolso> detalles = new ArrayList<>(); 
        
        if (dto.getListaDetalles() != null) {
            for (DetalleReembolsoDTO dDTO : dto.getListaDetalles()) {
                DetalleReembolso dEntidad = new DetalleReembolso();
                
                dEntidad.setCantidadDevuelta(dDTO.getCantidadDevuelta());
                dEntidad.setSubtotalReembolsado(dDTO.getSubtotalReembolsado());

                if (dDTO.getRopaTalla() != null) {
                    RopaTalla rt = RopaTallaMapper.toEntity(dDTO.getRopaTalla());
                    dEntidad.setRopaTalla(rt);
                }

                detalles.add(dEntidad);
            }
        }
     
        entidad.setDetalles(detalles);
        return entidad;
    }
}
