/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import com.mycompany.dto_negocio.SugerenciaDTO;
import objetosnegocio.dominioPojo.Empleado;
import objetosnegocio.dominioPojo.Sugerencia;
import org.bson.types.ObjectId;

/**
 *
 * @author santi
 */
public class SugerenciaMapper {
    public static Sugerencia toEntity(SugerenciaDTO dto) {
        if (dto == null) {
            return null;
        }

        Sugerencia sugerencia = new Sugerencia();

        if (dto.getId() != null && !dto.getId().isEmpty()) {
            sugerencia.setId(new ObjectId(dto.getId()));
        }

        if (dto.getEmpleadoDTO()!= null) {
            Empleado empleadoEntidad = EmpleadoMapper.toEntity(dto.getEmpleadoDTO());
            sugerencia.setEmpleado(empleadoEntidad);
        }

        sugerencia.setDescripcion(dto.getDescripcion());
        sugerencia.setEstado(dto.getEstado());
        sugerencia.setFechaPublicacion(dto.getFechaPublicacion());

        return sugerencia;
    }
    
    public static SugerenciaDTO toDTO(Sugerencia sugerencia) {
        if (sugerencia == null) {
            return null;
        }

        SugerenciaDTO dto = new SugerenciaDTO();

        if (sugerencia.getId() != null) {
            dto.setId(sugerencia.getId().toHexString());
        }

        dto.setEmpleadoDTO(EmpleadoMapper.toDTO(sugerencia.getEmpleado()));
        dto.setDescripcion(sugerencia.getDescripcion());
        dto.setEstado(sugerencia.getEstado());
        dto.setFechaPublicacion(sugerencia.getFechaPublicacion());

        return dto;
    }


}
