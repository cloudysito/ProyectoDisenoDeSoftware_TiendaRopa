/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import com.mycompany.dto_negocio.BonificacionDTO;
import objetosnegocio.dominioPojo.Bonificacion;
import objetosnegocio.dominioPojo.Empleado;
import objetosnegocio.dominioPojo.Recompensa;
import org.bson.types.ObjectId;

/**
 *
 * @author riosr
 */
public class BonificacionMapper {
    
    public static Bonificacion toEntity(BonificacionDTO dto) {
        if (dto == null) {
            return null;
        }
        Bonificacion b = new Bonificacion();
        if (dto.getIdBonificacion()!= null) {
            b.setIdBonificacion(new ObjectId(dto.getIdBonificacion()));
        }
        Empleado nombreEmpleado = EmpleadoMapper.toEntity(dto.getNombreEmpleado());
        b.setNombreEmpleado(nombreEmpleado);
        b.setPuntosTotales(dto.getPuntosTotales());
        Recompensa nombreRecompensa = RecompensaMapper.toEntity(dto.getNombreRecompensa());
        b.setNombreRecompensa(nombreRecompensa);
        return b;
    }
    
    public static BonificacionDTO toDTO(Bonificacion b) {
        if (b == null) {
            return null;
        }
        BonificacionDTO dto = new BonificacionDTO();
        dto.setIdBonificacion(
            b.getIdBonificacion()!= null ? b.getIdBonificacion().toHexString() : null
        );
        dto.setNombreEmpleado(EmpleadoMapper.toDTO(b.getNombreEmpleado()));
        dto.setPuntosTotales(b.getPuntosTotales());
        dto.setNombreRecompensa(RecompensaMapper.toDTO(b.getNombreRecompensa()));
        return dto;
    }
}
