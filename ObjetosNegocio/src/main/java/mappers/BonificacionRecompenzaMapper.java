/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import com.mycompany.dto_negocio.PuntosDTO;
import objetosnegocio.dominioPojo.Bonificacion;
import objetosnegocio.dominioPojo.Puntos;
import objetosnegocio.dominioPojo.Empleado;
import objetosnegocio.dominioPojo.Recompensa;
import org.bson.types.ObjectId;

/**
 *
 * @author riosr
 */
public class BonificacionRecompenzaMapper {
    
    public static Puntos toEntity(PuntosDTO dto) {
        if (dto == null) {
            return null;
        }
        Puntos br = new Puntos();
        if (dto.getIdPuntos()!= null) {
            br.setIdPuntos(new ObjectId(dto.getIdPuntos()));
        }
//        Empleado empleadoEntidad = EmpleadoMapper.toEntity(dto.getNombreEmpleado());
//        br.setNombreEmpleado(empleadoEntidad);
//        Bonificacion bonificacionEntidad = BonificacionMapper.toEntity(dto.getNombreBonificacion());
//        br.setNombreBonificacion(bonificacionEntidad);
//        Recompensa recompenzaEntidad = RecompenzaMapper.toEntity(dto.getNombreRecompenza());
//        br.setNombreRecompenza(recompenzaEntidad);
        
        return br;
    }
    
    public static PuntosDTO toDTO(Puntos br) {
        if (br == null) {
            return null;
        }
        PuntosDTO dto = new PuntosDTO();
//        dto.setIdBonificacionRecompenza(String.valueOf(br.getId()));
//        dto.setNombreEmpleado(EmpleadoMapper.toDTO(br.getNombreEmpleado()));
//        dto.setNombreBonificacion(BonificacionMapper.toDTO(br.getNombreBonificacion()));
//        dto.setNombreRecompenza(RecompenzaMapper.toDTO(br.getNombreRecompenza()));
//        
        return dto;
    }
}
