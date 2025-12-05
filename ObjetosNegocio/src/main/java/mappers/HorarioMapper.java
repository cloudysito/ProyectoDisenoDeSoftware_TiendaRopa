/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import com.mycompany.dto_negocio.DiaHorarioDTO;
import com.mycompany.dto_negocio.HorarioDTO;
import java.util.List;
import java.util.stream.Collectors;
import objetosnegocio.dominioPojo.DiaHorario;
import objetosnegocio.dominioPojo.Horario;
import org.bson.types.ObjectId;

/**
 * Mapper para la entidad Horario.
 * Utiliza Java Streams para convertir la lista de días (DiaHorario) contenida.
 * @author santi
 */
public class HorarioMapper {
    public static Horario toEntity(HorarioDTO dto) {
        if (dto == null) {
            return null;
        }
        Horario horario = new Horario();
        if (dto.getId()!= null) {
            horario.setId(new ObjectId(dto.getId()));
        }
        if (dto.getDias()!= null) {
        List<DiaHorario> diasTrabajo = dto.getDias().stream()
            .map(DiaHorarioMapper::toEntity)
            .collect(Collectors.toList());

        horario.setDias(diasTrabajo);
            }   
        
        return horario;
    }
    
    public static HorarioDTO toDTO(Horario entity) {
        if (entity == null) {
            return null;
        }

        HorarioDTO dto = new HorarioDTO();

        if (entity.getId() != null) {
            dto.setId(entity.getId().toString());
        }

        if (entity.getDias() != null) {
            List<DiaHorarioDTO> diasDTO = entity.getDias().stream()
                .map(DiaHorarioMapper::toDTO)
                .collect(Collectors.toList());
            dto.setDias(diasDTO);
        }

        return dto;
    }

}
