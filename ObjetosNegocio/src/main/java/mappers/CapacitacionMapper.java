/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import com.mycompany.dto_negocio.CapacitacionDTO;
import objetosnegocio.dominioPojo.Capacitacion;
import org.bson.types.ObjectId;

/**
 *
 * @author riosr
 */
public class CapacitacionMapper {
    
    public static Capacitacion toEntity(CapacitacionDTO dto) {
        if (dto == null) {
            return null;
        }
        Capacitacion c = new Capacitacion();
        if (dto.getIdCapacitacion()!= null) {
            c.setId(new ObjectId(dto.getIdCapacitacion()));
        }
        c.setTemaCapacitacion(dto.getTemaCapacitacion());
        c.setEstado(dto.getEstado());
        return c;
    }
    
    public static CapacitacionDTO toDTO(Capacitacion c) {
        if (c == null) {
            return null;
        }
        CapacitacionDTO dto = new CapacitacionDTO();
        dto.setIdCapacitacion(String.valueOf(c.getId()));
        dto.setTemaCapacitacion(c.getTemaCapacitacion());
        dto.setEstado(c.getEstado());
        return dto;
    }
}
