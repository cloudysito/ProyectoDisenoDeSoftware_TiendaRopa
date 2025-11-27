/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import com.mycompany.dto_negocio.TallaDTO;
import objetosnegocio.dominioPojo.Talla;
import org.bson.types.ObjectId;

/**
 *
 * @author garfi
 */
public class TallaMapper {
    
    public static Talla toEntity(TallaDTO dto) {
        if (dto == null) {
            return null;
        }
        Talla talla = new Talla();
        talla.setId(new ObjectId(dto.getIdTalla()));
        talla.setNombreTalla(dto.getNombreTalla());
        talla.setDescripcion(dto.getDescripcion());
        
        return talla;
    }
    
    public static TallaDTO toDTO(Talla talla) {
        if (talla == null) {
            return null;
        }
        TallaDTO dto = new TallaDTO();
        dto.setIdTalla(talla.getId().toHexString());
        dto.setNombreTalla(talla.getNombreTalla());
        dto.setDescripcion(talla.getDescripcion());
        
        return dto;
    }
    
}
