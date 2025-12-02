/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import com.mycompany.dto_negocio.CapacitacionDTO;
import objetosnegocio.dominioPojo.Capacitacion;
import objetosnegocio.dominioPojo.Empleado;
import objetosnegocio.dominioPojo.TemaCapacitacion;
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
            c.setIdCapacitacion(new ObjectId(dto.getIdCapacitacion()));
        }
        Empleado nombreEmpleado = EmpleadoMapper.toEntity(dto.getNombreEmpleado());
        c.setNombreEmpleado(nombreEmpleado);
        TemaCapacitacion temaCapacitacion = TemaCapacitacionMapper.toEntity(dto.getTemaCapacitacion());
        c.setTemaCapacitacion(temaCapacitacion);
        c.setEstado(dto.getEstado());
        
        return c;
    }
    
    public static CapacitacionDTO toDTO(Capacitacion c) {
        if (c == null) {
            return null;
        }
        CapacitacionDTO dto = new CapacitacionDTO();
        dto.setIdCapacitacion(
            c.getIdCapacitacion()!= null ? c.getIdCapacitacion().toHexString() : null
        );
        dto.setNombreEmpleado(EmpleadoMapper.toDTO(c.getNombreEmpleado()));
        dto.setTemaCapacitacion(TemaCapacitacionMapper.toDTO(c.getTemaCapacitacion()));
        dto.setEstado(c.getEstado());
        
        return dto;
    }
}
