/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import com.mycompany.dto_negocio.BonificacionRecompenzaDTO;
import objetosnegocio.dominioPojo.Bonificacion;
import objetosnegocio.dominioPojo.BonificacionRecompenza;
import objetosnegocio.dominioPojo.Empleado;
import objetosnegocio.dominioPojo.Recompenza;
import org.bson.types.ObjectId;

/**
 *
 * @author riosr
 */
public class BonificacionRecompenzaMapper {
    
    public static BonificacionRecompenza toEntity(BonificacionRecompenzaDTO dto) {
        if (dto == null) {
            return null;
        }
        BonificacionRecompenza br = new BonificacionRecompenza();
        if (dto.getIdBonificacionRecompenza()!= null) {
            br.setId(new ObjectId(dto.getIdBonificacionRecompenza()));
        }
        Empleado empleadoEntidad = EmpleadoMapper.toEntity(dto.getNombreEmpleado());
        br.setNombreEmpleado(empleadoEntidad);
        Bonificacion bonificacionEntidad = BonificacionMapper.toEntity(dto.getNombreBonificacion());
        br.setNombreBonificacion(bonificacionEntidad);
        Recompenza recompenzaEntidad = RecompenzaMapper.toEntity(dto.getNombreRecompenza());
        br.setNombreRecompenza(recompenzaEntidad);
        
        return br;
    }
    
    public static BonificacionRecompenzaDTO toDTO(BonificacionRecompenza br) {
        if (br == null) {
            return null;
        }
        BonificacionRecompenzaDTO dto = new BonificacionRecompenzaDTO();
        dto.setIdBonificacionRecompenza(String.valueOf(br.getId()));
        dto.setNombreEmpleado(EmpleadoMapper.toDTO(br.getNombreEmpleado()));
        dto.setNombreBonificacion(BonificacionMapper.toDTO(br.getNombreBonificacion()));
        dto.setNombreRecompenza(RecompenzaMapper.toDTO(br.getNombreRecompenza()));
        
        return dto;
    }
}
