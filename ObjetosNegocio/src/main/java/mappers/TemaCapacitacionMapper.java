/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import com.mycompany.dto_negocio.TemaCapacitacionDTO;
import objetosnegocio.dominioPojo.TemaCapacitacion;
import org.bson.types.ObjectId;

/**
 * Mapper para la entidad TemaCapacitacion.
 * @author riosr
 */
public class TemaCapacitacionMapper {
    public static TemaCapacitacion toEntity(TemaCapacitacionDTO dto) {
        if (dto == null) {
            return null;
        }
        TemaCapacitacion tc = new TemaCapacitacion();
        if (dto.getIdTemaCapacitacion()!= null) {
            tc.setIdTemaCapacitacion(new ObjectId(dto.getIdTemaCapacitacion()));
        }
        tc.setTemaCapacitacion(dto.getTemaCapacitacion());
        
        
        return tc;
    }
    
    public static TemaCapacitacionDTO toDTO(TemaCapacitacion tc) {
        if (tc == null) {
            return null;
        }
        TemaCapacitacionDTO dto = new TemaCapacitacionDTO();
        dto.setIdTemaCapacitacion(
            tc.getIdTemaCapacitacion()!= null ? tc.getIdTemaCapacitacion().toHexString() : null
        );
        dto.setTemaCapacitacion(tc.getTemaCapacitacion());
        return dto;
    }
}
