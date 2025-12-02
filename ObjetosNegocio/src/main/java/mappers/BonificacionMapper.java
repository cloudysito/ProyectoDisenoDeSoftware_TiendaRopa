/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import com.mycompany.dto_negocio.BonificacionDTO;
import objetosnegocio.dominioPojo.Bonificacion;
import org.bson.types.ObjectId;

/**
 *
 * @author riosr
 */
public class BonificacionMapper {
    
    public static Bonificacion toEntity(BonificacionDTO dto) {
        if (dto == null) {
            return null;
        }
        Bonificacion b = new Bonificacion();
        if (dto.getIdBonificacion()!= null) {
            b.setIdBonificacion(new ObjectId(dto.getIdBonificacion()));
        }
//        b.setDescripcion(dto.ge());
//        b.setCantidadVenta(dto.getCantidadVenta());
        return b;
    }
    
    public static BonificacionDTO toDTO(Bonificacion b) {
        if (b == null) {
            return null;
        }
        BonificacionDTO dto = new BonificacionDTO();
//        dto.setIdBonificacion(String.valueOf(b.getId()));
//        dto.setDescripcion(b.getDescripcion());
//        dto.setCantidadVenta(b.getCantidadVenta());
        return dto;
    }
}
