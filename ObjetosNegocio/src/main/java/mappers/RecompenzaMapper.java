/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import com.mycompany.dto_negocio.RecompenzaDTO;
import objetosnegocio.dominioPojo.Recompenza;
import org.bson.types.ObjectId;

/**
 *
 * @author riosr
 */
public class RecompenzaMapper {
    
    public static Recompenza toEntity(RecompenzaDTO dto) {
        if (dto == null) {
            return null;
        }
        Recompenza r = new Recompenza();
        if (dto.getIdRecompenza()!= null) {
            r.setId(new ObjectId(dto.getIdRecompenza()));
        }
        r.setNombreRecompenza(dto.getNombreRecompenza());
        r.setPuntosNecesarios(dto.getPuntosNecesarios());
        return r;
    }
    
    public static RecompenzaDTO toDTO(Recompenza r) {
        if (r == null) {
            return null;
        }
        RecompenzaDTO dto = new RecompenzaDTO();
        dto.setId(String.valueOf(r.getId()));
        dto.setNombreRecompenza(r.getNombreRecompenza());
        dto.setPuntosNecesarios(r.getPuntosNecesarios());
        return dto;
    }
}
