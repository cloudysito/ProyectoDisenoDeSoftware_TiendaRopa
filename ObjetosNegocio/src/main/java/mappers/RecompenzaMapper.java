/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import com.mycompany.dto_negocio.RecompensaDTO;
import objetosnegocio.dominioPojo.Recompensa;
import org.bson.types.ObjectId;

/**
 *
 * @author riosr
 */
public class RecompenzaMapper {
    
    public static Recompensa toEntity(RecompensaDTO dto) {
        if (dto == null) {
            return null;
        }
        Recompensa r = new Recompensa();
        if (dto.getIdRecompenza()!= null) {
            r.setId(new ObjectId(dto.getIdRecompenza()));
        }
        r.setNombreRecompenza(dto.getNombreRecompenza());
        r.setPuntosNecesarios(dto.getPuntosNecesarios());
        return r;
    }
    
    public static RecompensaDTO toDTO(Recompensa r) {
        if (r == null) {
            return null;
        }
        RecompensaDTO dto = new RecompensaDTO();
        dto.setId(String.valueOf(r.getId()));
        dto.setNombreRecompenza(r.getNombreRecompenza());
        dto.setPuntosNecesarios(r.getPuntosNecesarios());
        return dto;
    }
}
