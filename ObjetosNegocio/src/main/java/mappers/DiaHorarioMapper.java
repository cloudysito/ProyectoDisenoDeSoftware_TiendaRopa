/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import com.mycompany.dto_negocio.DiaHorarioDTO;
import objetosnegocio.dominioPojo.DiaHorario;
import org.bson.types.ObjectId;

/**
 *
 * @author santi
 */
public class DiaHorarioMapper {
    public static DiaHorario toEntity(DiaHorarioDTO dto) {
        if (dto == null) {
            return null;
        }
        DiaHorario diaHorario = new DiaHorario();
        if (dto.getId()!= null) {
            diaHorario.setId(new ObjectId(dto.getId()));
        }
        diaHorario.setDia(dto.getDia());
        diaHorario.setHoraEntrada(dto.getHoraEntrada());
        diaHorario.setHoraSalida(dto.getHoraSalida());
        
        return diaHorario;
    }
    
   public static DiaHorarioDTO toDTO(DiaHorario entity) {
        if (entity == null) {
            return null;
        }

        DiaHorarioDTO dto = new DiaHorarioDTO();

        if (entity.getId() != null) {
            dto.setId(entity.getId().toString());
        }

        dto.setDia(entity.getDia());
        dto.setHoraEntrada(entity.getHoraEntrada());
        dto.setHoraSalida(entity.getHoraSalida());

        return dto;
}

}
